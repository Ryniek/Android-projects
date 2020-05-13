package com.example.myapplication;

import java.util.Arrays;
import java.util.List;

public class ItalianTeam {
    private String name;
    private List<String> players;
    private int logoImageId;

    public static final ItalianTeam[] ITALIAN_TEAMS = {
            new ItalianTeam("Perugia", Arrays.asList("Wilfredo Leon", "Aleksandar Atanasijević", "Filippo Lanza"),
                    R.drawable.perugia),
            new ItalianTeam("Lube Civitanova", Arrays.asList("Osmany Juantorena", "Joandry Leal Hidalgo", "Luciano De Cecco"),
                    R.drawable.lube),
            new ItalianTeam("Modena", Arrays.asList("Micah Christenson", "Matthew Anderson", "Ivan Zaytsev"),
                    R.drawable.modena)
    };

    public ItalianTeam(String name, List<String> players, int logoImageId) {
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
