package com.shivetya.magiworld;

import java.util.Scanner;

public class Player {

    private Scanner sc = new Scanner(System.in);

    private Character character;
    private String name;


    Player(int number){

        name = "Joueur"+number;
        character = creator();
    }

    Player(int number, Character character){

        name = "Joueur"+number;
        this.character = character;
    }

    private Character creator(){

        int choice = askCharacter();
        int level = askLevel();
        int strength = askStrength();
        int agility = askAgility();
        int intelligence = askIntelligence();
        Character character;

        if(strength + agility + intelligence != level ) throw new BadSpecException();

        switch(choice){
            case 1 :
                character = new Warrior(level, strength, agility, intelligence);
            break;

            case 2 :
                character = new Ranger(level, strength, agility, intelligence);
            break;

            case 3 :
                character = new Magus(level, strength, agility, intelligence);
            break;

            default :
                throw new BadSpecException();
        }
        return character;
    }

    void basicAttack(Character attacked){
        this.character.basicAttack(attacked);
        System.out.println(name + this.character.displayBasicAttack());
    }

    void specialAttack(Character attacked){
        this.character.specialAttack(attacked);
    }

    private int askCharacter(){

        int choice = 0;

        while(choice < 1 || choice > 3){
            System.out.println("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)");
            choice = sc.nextInt();
        }
        return choice;
    }

    private int askLevel() {

        int level;

        System.out.println("Niveau du personnage ?");
        level = sc.nextInt();

        if (level < 1 || level > 100) throw new BadSpecException();

        return level;
    }

    private int askStrength(){

        int strength;

        System.out.println("Force du personnage ?");
        strength = sc.nextInt();

        if (strength < 0 || strength > 100) throw new BadSpecException();

        return strength;
    }

    private int askAgility() {

        int agility;

        System.out.println("Agilité du personnage ?");
        agility = sc.nextInt();

        if (agility < 0 || agility > 100) throw new BadSpecException();

        return agility;
    }

    private int askIntelligence() {

        int intelligence;

        System.out.println("Intelligence du personnage ?");
        intelligence = sc.nextInt();

        if (intelligence < 0 || intelligence > 100) throw new BadSpecException();

        return intelligence;
    }

    public String getName(){
        return name;
    }

    Character getCharacter(){
        return character;
    }


}
