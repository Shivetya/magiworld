package com.shivetya.magiworld;

import java.util.Scanner;

public class Input {

    Scanner sc = new Scanner(System.in);

    Input(){

    }

    int askCharacter(){

        int choice = 0;

        while(choice < 1 || choice > 3){
            System.out.println("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)");
            choice = sc.nextInt();
        }
        return choice;
    }

    int askLevel() {

        int level;

        System.out.println("Niveau du personnage ?");
        level = sc.nextInt();

        if (level < 1 || level > 100) throw new BadSpecException();

        return level;
    }

    int askStrength(){

        int strength;

        System.out.println("Force du personnage ?");
        strength = sc.nextInt();

        if (strength < 0 || strength > 100) throw new BadSpecException();

        return strength;
    }

    int askAgility() {

        int agility;

        System.out.println("Agilité du personnage ?");
        agility = sc.nextInt();

        if (agility < 0 || agility > 100) throw new BadSpecException();

        return agility;
    }

    int askIntelligence() {

        int intelligence;

        System.out.println("Intelligence du personnage ?");
        intelligence = sc.nextInt();

        if (intelligence < 0 || intelligence > 100) throw new BadSpecException();

        return intelligence;
    }

}
