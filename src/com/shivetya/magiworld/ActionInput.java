package com.shivetya.magiworld;

public enum ActionInput {

    BASIC_ATTACK( 1,"Attaque Basique"),
    SPECIAL_ATTACK(2,"Attaque Spéciale");

    private int number;
    private String description;

    ActionInput(int number, String description) {
        this.number = number;
        this.description = description;
    }

    public int getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }
}
