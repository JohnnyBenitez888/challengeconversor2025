package com.johnnybenitez.challengeconversor2025.principal;

import com.johnnybenitez.challengeconversor2025.servicio.Conversor;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Conversor conversor = new Conversor();
        int opcion;
        double cantidad;

        do {
            System.out.println("Conversor de Monedas de Alura!!\n");
            System.out.println("1 - Dólar a Peso Argentino");
            System.out.println("2 - Peso Argentino a Dólar");
            System.out.println("3 - Euro a Peso Argentino");
            System.out.println("4 - Peso Argentino a Euro");
            System.out.println("5 - Dólar a Real Brasileño");
            System.out.println("6 - Real Brasileño a Dólar");
            System.out.println("7 - Dólar a Peso Colombiano");
            System.out.println("8 - Peso Colombiano a Dólar");
            System.out.println("9 - Salir");
            System.out.println("----------Elija una opción----------\n**************************\n");
            opcion = scanner.nextInt();

            String monedaBase = "";
            String monedaDestino = "";

            switch (opcion) {
                case 1 -> {
                    monedaBase = "USD";
                    monedaDestino = "ARS";
                }
                case 2 -> {
                    monedaBase = "ARS";
                    monedaDestino = "USD";
                }
                case 3 -> {
                    monedaBase = "EUR";
                    monedaDestino = "ARS";
                }
                case 4 -> {
                    monedaBase = "ARS";
                    monedaDestino = "EUR";
                }
                case 5 -> {
                    monedaBase = "USD";
                    monedaDestino = "BRL";
                }
                case 6 -> {
                    monedaBase = "BRL";
                    monedaDestino = "USD";
                }
                case 7 -> {
                    monedaBase = "USD";
                    monedaDestino = "COP";
                }
                case 8 -> {
                    monedaBase = "COP";
                    monedaDestino = "USD";
                }
                case 9 -> System.out.println("Gracias por usar el conversor de Alura!!");

                default -> {
                    System.out.println("Opción no valida");
                    continue;
                }
            }
            if (opcion >= 1 && opcion <= 8) {
                System.out.println("Ingrese la cantidad a convertir:");
                cantidad = scanner.nextDouble();
                double resultado = conversor.convertir(monedaBase, monedaDestino, cantidad);
                System.out.println(resultado);
                System.out.printf("El valor $%.0f %s corresponde al valor final de $%.2f %s\n\n",
                        cantidad,
                        monedaBase,
                        resultado,
                        monedaDestino
                );
                System.out.println("====================================");
            }
        } while (opcion != 9);
        scanner.close();
    }
}
