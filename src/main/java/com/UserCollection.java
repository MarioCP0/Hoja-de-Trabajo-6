package com;

import com.FactoryReleated.MapEnum;
import com.FactoryReleated.MapFactory;
import java.util.Map;

public class UserCollection {
    private Map<String, Integer> cardCount;

    public UserCollection(MapEnum mapEnum) {
        MapFactory<String, Integer> mapFactory = new MapFactory<String, Integer>(); // podria hacerlo estatico, pero nah pero hell naw
        cardCount =  mapFactory.CreateMap(mapEnum);
    }

    public void addCard(String cardName) {
        cardCount.put(cardName, cardCount.getOrDefault(cardName, 0) + 1);
    }

    public String getCardType(String cardName, Map<String, String> allCards) {
        return allCards.get(cardName);
    }    

    public Map<String, Integer> getAllCards() {
        return cardCount;
    }

}

