package com.shivetya.magiworld;

public enum CharacterInput {
    WARRIOR(1, "Guerrier"),
    RANGER(2, "Rôdeur"),
    MAGUS(3, "Mage");

    int number;
    String description;

    CharacterInput(int number, String description) {
        this.number = number;
        this.description = description;
    }

    public int getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }

    public static CharacterInput fromValues(Integer number){

        CharacterInput result = null;

        for (CharacterInput ci : CharacterInput.values()){
            if (number == ci.getNumber()) result = ci;
        }
        return result;
    }
}
