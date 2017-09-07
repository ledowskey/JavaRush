package com.javarush.task.task15.task1507;

/* 
ООП - Перегрузка
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    public static void printMatrix(int m, String value) {
        System.out.println(m + value);
    }

    public static void printMatrix(String value) {
        System.out.println(value);
    }

    public static void printMatrix(String value, int m) {
        System.out.println(value + m);
    }

    public static void printMatrix(String value, int m, int n) {
        System.out.println(value + m + n);
    }

    public static void printMatrix(int m, String value, int n) {
        System.out.println(m + value + n);
    }

    public static int printMatrix(int m, int n) {
        return m + n;

    }

    public static Object printMatrix(Object value) {
        return value;
    }

    public static void printMatrix(Object value, int m) {
        System.out.println(value);
    }
}
