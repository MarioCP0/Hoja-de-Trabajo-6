package com;

import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import com.FactoryReleated.*;

public class App {
    public static void main(String[] args) {
        TxtLoader file = new TxtLoader();
        MapFactory<String, String> Factory = new MapFactory<String, String>();


        System.out.println("Elige una opcion");
        System.out.println("1. HashMap");
        System.out.println("2. TreeMap");
        System.out.println("3. LinkedHashMap\n");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();

        MapEnum mapEnum = MapEnum.values()[option-1];

        Map<String, String> allCards = file.LoadTxt(Factory.CreateMap(mapEnum));
        UserCollection userCollection = new UserCollection(mapEnum);
        
        int choice = 0;


        //TODO: CHAMBE :D

        while (choice != 7) {
            System.out.println("\nElige una opción:");
            System.out.println("1. Agregar una carta a la colección del usuario");
            System.out.println("2. Mostrar el tipo de una carta específica");
            System.out.println("3. Mostrar el nombre, tipo y cantidad de cada carta en la colección");
            System.out.println("4. Mostrar el nombre, tipo y cantidad de cada carta en la colección, ordenadas por tipo");
            System.out.println("5. Mostrar el nombre y tipo de todas las cartas existentes");
            System.out.println("6. Mostrar el nombre y tipo de todas las cartas existentes, ordenadas por tipo");
            System.out.println("7. Salir");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Ingrese el nombre de la carta que desea agregar:");
                    sc.nextLine();
                    String cardName = sc.nextLine();
                    if (allCards.containsKey(cardName)) {
                        userCollection.addCard(cardName);
                        System.out.println("Carta agregada exitosamente.");
                    } else {
                        System.out.println("La carta ingresada no se encuentra entre las cartas disponibles.");
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el nombre de la carta:");
                    sc.nextLine();
                    String cardToFind = sc.nextLine();
                    String type = userCollection.getCardType(cardToFind, allCards);
                    if (type != null) {
                        System.out.println("El tipo de la carta es: " + type);
                    } else {
                        System.out.println("La carta ingresada no se encuentra en la colección.");
                    }
                    break;
                case 3:
                    System.out.println("Cartas en la colección del usuario:");
                    Map<String, Integer> userCards = userCollection.getAllCards();
                    for (Map.Entry<String, Integer> entry : userCards.entrySet()) {
                        System.out.println("Nombre: " + entry.getKey() + ", Tipo: " + allCards.get(entry.getKey())
                                + ", Cantidad: " + entry.getValue());
                    }
                    break;
                case 4:
                    System.out.println("Las cartas ordenadas por tipo:");
                    for (Map.Entry<String, String> entry : allCards.entrySet()) {
                    System.out.println("Nombre: " + entry.getKey() + ", Tipo: " + entry.getValue());
                    }
                    break;
                case 5:
                    System.out.println("Todas las cartas disponibles:");
                    for (Map.Entry<String, String> entry : allCards.entrySet()) {
                        System.out.println("Nombre: " + entry.getKey() + ", Tipo: " + entry.getValue());
                    }
                    break;
                case 6:
                    System.out.println("Todas las cartas ordenadas por tipo:");
                    for (Map.Entry<String, String> entry : allCards.entrySet()) {
                    System.out.println("Nombre: " + entry.getKey() + ", Tipo: " + entry.getValue());
                    }
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
        sc.close();
    }
}
