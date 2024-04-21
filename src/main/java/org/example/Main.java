package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("Заводчанин Великий");
        employee.printName();

        Product product = new Product("Спички высококачественные");
        product.printName();

        employee.raiseSalary(50000, 2);
        System.out.println(product.calculateDiscountedPrice(100, 5));
        System.out.println(product.sum(10, 2));
        System.out.println(product.calculateProductionCapacity(10, 2));

        String jsonData = JsonFormatter.formatToJson("Hello, world!");
        System.out.println("Формат JSON: " + jsonData);

        double result = MathOperations.power(2, 3);
        System.out.println("Степени: " + result);

        int randomNum = MathOperations.getRandomNumber(1, 100);
        System.out.println("Рандом: " + randomNum);

        int[] numbers = {10, 5, 8, 15, 3};
        int maxNumber = ArrayOperations.findMax(numbers);
        System.out.println("Максимальное число: " + maxNumber);
    }
}

class Employee {
    private String name;
    private double salary;

    public Employee(String name) {
        this.name = name;
    }

    public void printName() {
        System.out.println("Имя сотрудника: " + name);
    }

    public void raiseSalary(double salary, double cooficent) {
        this.salary = salary + (salary * cooficent);
        System.out.println("Мы повысили вашу зарплату в " + cooficent + " раз. Ваша новая зарплата: " + this.salary);
    }
}

class Product {
    private String name;
    private double price;

    public Product(String name) {
        this.name = name;
    }

    public void printName() {
        System.out.println("Название продукта: " + name);
    }

    public double calculateDiscountedPrice(double originalPrice, double discountPercentage) {
        double discountAmount = originalPrice * (discountPercentage / 100.0);
        return originalPrice - discountAmount;
    }

    public int sum(int a, int b) {
        return a + b;
    }

    public double calculateProductionCapacity(int numberOfWorkers, int workingHoursPerDay) {
        return numberOfWorkers * workingHoursPerDay;
    }
}

class JsonFormatter {
    public static String formatToJson(String data) {
        return "{ \"data\": \"" + data + "\" }";
    }
}

class MathOperations {
    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public static int getRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}

class ArrayOperations {
    public static int findMax(int[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Нельзя передавать пустой массив");
        }
        int max = array[0];
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}
