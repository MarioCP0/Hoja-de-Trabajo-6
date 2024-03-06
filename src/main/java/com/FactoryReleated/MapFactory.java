package com.FactoryReleated;
import java.util.Map;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;

public class MapFactory<T,K> {

    public Map<T,K> CreateMap(MapEnum mapEnum){
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
