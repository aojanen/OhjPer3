/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 *
 * @author akseli
 */
import java.util.Scanner;

public class Mean {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter numbers: ");
        String line = myScanner.nextLine();
        String[] numbers = line.split(" ");
        double sum = 0;
        for (String s : numbers){
            sum += Double.parseDouble(s);
        }
        System.out.println();
        System.out.print("Mean: " + sum/numbers.length);
    }
}
