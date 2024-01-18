/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ttakoj
 */
import java.util.Scanner;

public class Median {

	public static void main(String[] args) {
		Scanner user = new Scanner(System.in);
		System.out.print("Enter numbers: ");
		String line = user.nextLine();
		String[] numbers = line.split("\\s");

		double median;
		if (numbers.length % 2 == 0) {
			median = (Double.valueOf(numbers[numbers.length / 2]) + Double.valueOf(numbers[numbers.length / 2 - 1])) / 2;
		} else {
			median = Double.valueOf(numbers[numbers.length / 2]);
		}
		System.out.println("Median: " + String.valueOf(median));
	}
}
