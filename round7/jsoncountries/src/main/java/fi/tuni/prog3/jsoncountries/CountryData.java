/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.jsoncountries;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ttakoj
 */
public class CountryData {

	private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

	public static List<Country> readFromJsons(String areaFile, String populationFile, String gdpFile) {
		List<Country> countries = new ArrayList<>();

		try ( FileReader areaReader = new FileReader(areaFile);  FileReader populationReader = new FileReader(populationFile);  FileReader gdpReader = new FileReader(gdpFile)) {

			countries.addAll(readCountryData(areaReader, "Area"));
			countries.addAll(readCountryData(populationReader, "Population"));
			countries.addAll(readCountryData(gdpReader, "GDP"));

		} catch (IOException e) {
			e.printStackTrace();
		}

		return countries;
	}

	private static List<Country> readCountryData(FileReader reader, String dataType) {
		List<Country> countries = new ArrayList<>();
		Map<String, Country> countryMap = new HashMap<>();

		JsonParser parser = new JsonParser();
		JsonElement rootElement = parser.parse(reader);

		JsonObject rootObject = rootElement.getAsJsonObject();
		JsonObject dataObject = rootObject.getAsJsonObject("Root").getAsJsonObject("data");
		JsonArray recordArray = dataObject.getAsJsonArray("record");

		for (JsonElement recordElement : recordArray) {
			JsonObject recordObject = recordElement.getAsJsonObject();
			JsonArray fieldArray = recordObject.getAsJsonArray("field");

			String countryName = "";
			double value = 0;

			for (JsonElement fieldElement : fieldArray) {
				JsonObject fieldObject = fieldElement.getAsJsonObject();
				String attributeName = fieldObject.getAsJsonObject("attributes").get("name").getAsString();

				if ("Country or Area".equals(attributeName)) {
					countryName = fieldObject.get("value").getAsString();
				} else if (dataType.equals(attributeName)) {
					value = fieldObject.get("value").getAsDouble();
				}
			}

			// Check if the country already exists in the map
			if (countryMap.containsKey(countryName)) {
				// Update the existing country with additional data
				Country existingCountry = countryMap.get(countryName);
				if (dataType.equals("Area")) {
					existingCountry.setArea(value);
				} else if (dataType.equals("Population")) {
					existingCountry.setPopulation((long) value);
				} else if (dataType.equals("GDP")) {
					existingCountry.setGdp(value);
				}
			} else {
				// Add a new country to the map
				Country newCountry = new Country(countryName, dataType.equals("Area") ? value : 0, dataType.equals("Population") ? (long) value : 0, dataType.equals("GDP") ? value : 0);
				countryMap.put(countryName, newCountry);
				countries.add(newCountry);
			}
		}

		return countries;
	}

	public static void writeToJson(List<Country> countries, String countryFile) {
		try ( FileWriter writer = new FileWriter(countryFile)) {
			gson.toJson(countries, writer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// Example usage
		List<Country> countries = readFromJsons("area.json", "population.json", "gdp.json");
		Collections.sort(countries); // Sort countries by name
		writeToJson(countries, "output.json");
	}
}
