package com;

import java.util.Scanner;

import com.FactoryReleated.MapEnum;
import com.FactoryReleated.MapFactory;

public class App {
    public static void main( String[] args ){

        // for debugging purposes (talvez se quede asi)
        MapFactory Factory = new MapFactory();

        TxtLoader file = new TxtLoader();

        System.out.println("Elige una opcion");
        System.out.println("1. HashMap");
        System.out.println("2. TreeMap");
        System.out.println("3. LinkedHashMap\n");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        sc.close();

        MapEnum mapEnum = MapEnum.values()[option-1];

        System.out.println(file.LoadTxt(Factory.CreateMap(mapEnum)));

        
    }
}
