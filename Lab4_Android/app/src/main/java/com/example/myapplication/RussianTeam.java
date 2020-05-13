package com.example.myapplication;

import java.util.Arrays;
import java.util.List;

public class RussianTeam {
    private String name;
    private List<String> players;
    private int logoImageId;

    public static final RussianTeam[] RUSSIAN_TEAMS = {
            new RussianTeam("Zenit Kazań", Arrays.asList("Maxim Mikhaylov", "Alexander Butko", "Cwetan Sokolow"),
                    R.drawable.zenit),
            new RussianTeam("Lokomotiw Nowosybirsk", Arrays.asList("Marko Ivović", "Siergiej Sawin", "Pawieł Krugłow"),
                    R.drawable.lokomotiv),
            new RussianTeam("Kuzbass Kemerowo", Arrays.asList("Igor Kobzar", "Aleksandr Markin", "Michaił Szczerbakow"),
                    R.drawable.kuzbass)
    };

    public RussianTeam(String name, List<String> players, int logoImageId) {
        this.name = name;
        this.players = players;
        this.logoImageId = logoImageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPlayers() {
        return players;
    }

    public void setPlayers(List<String> players) {
        this.players = players;
    }

    public int getLogoImageId() {
        return logoImageId;
    }

    public void setLogoImageId(int logoImageId) {
        this.logoImageId = logoImageId;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
