/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ttakoj
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Parameters {

	private static int findMaxLength(ArrayList<String> list) {
		return list.stream()
			.map(String::length)
			.max(Integer::compare)
			.orElse(0);
	}

	private static String repeatChar(char c, int count) {
		return new String(new char[count]).replace('\0', c);
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<String> parameters = new ArrayList<>();

		System.out.println("Parameters:");

		while (input.hasNextLine()) {
			String line = input.nextLine();
			if (line.equals("")) {
				break;
			}
			parameters.add(line);
		}

		Collections.sort(parameters);

		int firstColumnWidth = Integer.toString(parameters.size()).length();
		int secondColumnWidth = findMaxLength(parameters);

		System.out.println(repeatChar('#', firstColumnWidth + secondColumnWidth + 7));

		int lineNumber = 1;

		for (String line : parameters) {
			System.out.format("# %" + firstColumnWidth + "d | %-" + secondColumnWidth + "s #%n", lineNumber, line);
			++lineNumber;
			if (lineNumber > parameters.size()) {
				break;
			}
			System.out.println("#" + repeatChar('-', firstColumnWidth + 2) + "+" + repeatChar('-', secondColumnWidth + 2) + "#");

		}
			System.out.println(repeatChar('#', firstColumnWidth + secondColumnWidth + 7));

	}
}
