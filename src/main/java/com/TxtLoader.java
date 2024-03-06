package com;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Map;

public class TxtLoader {
    private String txt_path = "cards_desc.txt";

    public Map<String, ArrayList<String>> LoadTxt(Map<String, ArrayList<String>> map){
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(txt_path))) {
            String[] Keys = {"Hechizo", "Monstruo", "Trampa"};

            for (String key : Keys) { // Mirar si lo puedo refactorizar en un lambda
                map.put(key, new ArrayList<String>());
            }

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length >= 2) {
                    String key = parts[1].trim(); //Second value is the key.
                    String value = parts[0].trim(); //First value is the value.
                    if (map.containsKey(key)) {
                        map.get(key).add(value);
                    }
                }
            }
            return map;
        } catch (Exception e) {
            System.out.println(e);
        }
        return map;
    }
}
