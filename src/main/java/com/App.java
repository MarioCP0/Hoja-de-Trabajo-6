package com;

import java.util.ArrayList;

import com.FactoryClasses.MapEnum;
import com.FactoryClasses.MapFactory;

public class App 
{
    public static void main( String[] args ){
        MapFactory<String, ArrayList<String>> Factory = new MapFactory<String, ArrayList<String>>();

        TxtLoader file = new TxtLoader();

        System.out.println(file.LoadTxt(Factory.CreateMap(MapEnum.HASHMAP)));
    }
}
