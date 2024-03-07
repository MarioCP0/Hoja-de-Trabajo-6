package com.FactoryReleated;
import java.util.Map;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;

public class MapFactory {

    public <T,K>Map<T,K> CreateMap(MapEnum mapEnum){ // ver como solo usar los parametros en el metodo
        switch(mapEnum){
            case HASHMAP:
                return new HashMap<T,K>();
            case TREEMAP:
                return new TreeMap<T,K>();
            case LINKEDHASHMAP:
                return new LinkedHashMap<T,K>();
            default:
                return null;
        }
    }

}
