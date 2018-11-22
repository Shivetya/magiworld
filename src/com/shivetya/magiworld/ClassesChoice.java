package com.shivetya.magiworld;

public enum ClassesChoice {
    WARRIOR(1),
    RANGER(2),
    MAGUS(3);

    int choice;

    ClassesChoice(int choice){
        this.choice = choice;
    }

    int getChoice(){
        return choice;
    }


}
