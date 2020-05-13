package com.example.myapplication;

import java.util.Arrays;
import java.util.List;

public class PolishTeam {
    private String name;
    private List<String> players;
    private int logoImageId;

    public static final PolishTeam[] POLISH_TEAMS = {
            new PolishTeam("Zaksa Kędzierzyn Koźle", Arrays.asList("Benjamin Toniutti", "Łukasz Kaczmarek", "Paweł Zatorski"),
                    R.drawable.zaksa),
            new PolishTeam("PGE Skra Bełchatów", Arrays.asList("Mariusz Wlazły", "Artur Szalpuk", "Milad Ebaidpour"),
                    R.drawable.skra),
            new PolishTeam("Jastrzębski Węgiel", Arrays.asList("Christian Fromm", "Julian Jyneel", "Lukas Kampa"),
                    R.drawable.jsw)
    };

    public PolishTeam(String name, List<String> players, int logoImageId) {
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
