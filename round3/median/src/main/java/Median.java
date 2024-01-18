/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ttakoj
 */
import java.util.Scanner;
import java.util.Arrays;

public class Median {

	public static void main(String[] args) {
		Scanner user = new Scanner(System.in);
		System.out.print("Enter numbers:");
		String line = user.nextLine();
		double[] numbers = Arrays.stream(line.split("\\s"))
                                  .mapToDouble(Double::parseDouble)
                                  .toArray();
		Arrays.sort(numbers);

		double median;
		if (numbers.length % 2 == 0) {
			median = (numbers[numbers.length / 2] + numbers[(numbers.length / 2) - 1]) / 2;
		} else {
			median = numbers[numbers.length / 2];
		}
		System.out.println();
		System.out.println("Median: " + String.valueOf(median));
	}
}
