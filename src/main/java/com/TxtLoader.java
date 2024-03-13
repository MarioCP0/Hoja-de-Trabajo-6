package com;

import java.io.BufferedReader;
import java.util.Map;

public class TxtLoader {
    private String txt_path = "cards_desc.txt";

    @SuppressWarnings("unchecked") //I know that shit is insecured as shit
    public <T, K>Map<T, K> LoadTxt(Map<T, K> map){
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(txt_path))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length >= 2) {
                    String key = parts[0].trim();
                    String value = parts[1].trim(); 
                    map.put((T)key, (K)value);
                }
            }
            return map;
        } catch (Exception e) {
            System.out.println(e);
        }
        return map;
    }
}