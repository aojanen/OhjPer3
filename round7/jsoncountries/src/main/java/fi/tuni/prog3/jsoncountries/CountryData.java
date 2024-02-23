package fi.tuni.prog3.jsoncountries;

import com.google.gson.*;
import java.io.*;
import java.util.*;

public class CountryData {
    public static void main(String[] args) {
        String areaFile = "area1.json";
        String populationFile = "population1.json";
        String gdpFile = "gdp1.json";

        List<Country> countries = readFromJsons(areaFile, populationFile, gdpFile);

        for (Country country : countries) {
            System.out.println(country);
            System.out.println();
        }
    }

    public static List<Country> readFromJsons(String areaFile, String populationFile, String gdpFile) {
        List<Country> countries = new ArrayList<>();

        try (FileReader areaReader = new FileReader(areaFile);
             FileReader populationReader = new FileReader(populationFile);
             FileReader gdpReader = new FileReader(gdpFile)) {

            readCountryData(countries, areaReader, "Area");
            readCountryData(countries, populationReader, "Population");
            readCountryData(countries, gdpReader, "GDP");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return countries;
    }

    private static void readCountryData(List<Country> countries, FileReader reader, String dataType) {

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

            // Check if the country already exists in the list
            Country existingCountry = findCountryByName(countries, countryName);
            if (existingCountry != null) {
                updateCountryData(existingCountry, dataType, value);
            } else {
                // Create a new country instance and add it to the list
                Country newCountry = new Country(countryName, 0, 0, 0);
                updateCountryData(newCountry, dataType, value);
                countries.add(newCountry);
            }
        }

}

    private static Country findCountryByName(List<Country> countries, String name) {
        for (Country country : countries) {
            if (country.getName().equals(name)) {
                return country;
            }
        }
        return null;
    }

    private static void updateCountryData(Country country, String dataType, double value) {
        if (dataType.equals("Area")) {
            country.setArea(value);
        } else if (dataType.equals("Population")) {
            country.setPopulation((long) value);
        } else if (dataType.equals("GDP")) {
            country.setGdp(value);
        }
    }
}