package io.ao9.winewiki.wine;

import io.ao9.winewiki.wine.jpa.GrapeEntity;
import io.ao9.winewiki.wine.jpa.WineEntity;

public class Test {

    public static void main(String[] args) {
        WineEntity wine = new WineEntity("red wine","http" , new GrapeEntity(), "good wine");
        System.out.println(wine);
        WineEntity wine2 = new WineEntity();
        wine2.setDescription("dfdf");
        System.out.println(wine2.getName());

    }

}