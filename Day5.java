//A number is considered perfect if its digits sum up to exactly 10.
//Given a positive integer n, return the n-th perfect number.
//For example, given 1, you should return 19. Given 2, you should return 28.

import java.util.Scanner;

public class Day5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner class to take input from user
        System.out.println("Enter the number: ");
        int n = sc.nextInt(); // taking input from user
        int count = 0; // count to keep track of perfect numbers
        for (int i = 19; ; i++) { // starting from 19 as 19 is the first perfect number
            if (sumOfDigits(i) == 10) {  // checking if the sum of digits is 10
                count++;
            }
            if (count == n) {
                System.out.println(i);
                break;
            }
        }
    }

    public static int sumOfDigits(int n) {
        int sum = 0; // sum to store the sum of digits
        while (n > 0) { // loop to calculate the sum of digits
            sum += n % 10; // adding the last digit to sum
            n = n / 10; // removing the last digit
        }
        return sum; // returning the sum
    }
}