package org.example;

public class PowerAlgorithm {
    public static void main(String[] args) {
        System.out.println(daqPower(3, 6));
    }

    //Naive algorithm to compute the power of any number
    // Time complexity: O(n)
    public static int naivePower(int number, int power) {
        int result = number;
        for(int i = 1; i < power; i++) {
            result *= number;
        }
        return result;
    }

    // Divide and conquer method to compute the power of the number
    // Time complexity: O(lgn)
    public static int daqPower(int num, int power) {
        if(power == 1) {
            return num;
        }
        int result = 1;
        if(power % 2 == 0) {
            result = daqPower(num, power / 2);
            return result * result;
        }
        result = daqPower(num, (power - 1) / 2);
        return result * result * num;
    }
}