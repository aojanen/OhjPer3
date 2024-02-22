/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fi.tuni.prog3.sevenzipsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.Enumeration;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;

import java.util.Scanner;
import java.util.regex.Pattern;
import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;

/**
 *
 * @author ttakoj
 */
public class SevenZipSearch {

	public static void main(String args[]) {
		Scanner inp = new Scanner(System.in);
		System.out.print("File: ");
		final String inputFileName = inp.nextLine();
		System.out.print("Query: ");
		final String query = inp.nextLine();
		System.out.println();

		try ( SevenZFile file = new SevenZFile(Paths.get(inputFileName).toFile())) {
			for (SevenZArchiveEntry entry : file.getEntries()) {
				if (entry.getName().endsWith(".txt")) {
					System.out.println(entry.getName());
					try ( BufferedReader br
						= new BufferedReader(new InputStreamReader(file.getInputStream(entry)))) {
						String line = null;
						int inputLines = 0;
						while ((line = br.readLine()) != null) {
							inputLines += 1;
							if (line.toLowerCase().contains(query.toLowerCase())){
								line = line.replaceAll("(?i)" + Pattern.quote(query), query.toUpperCase());
								System.out.println(inputLines +": " + line);
							}
							//System.out.println(inputLines +": " + line);
						}
					} catch (IOException e) {
						System.out.println("Another PaniC!");
					}
				}
				System.out.println();
			}

		} catch (IOException e) {
			System.out.println("Panic!");
		}
	}
}
