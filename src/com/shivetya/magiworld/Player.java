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
        character = character;
    }

    /**
     * Methods Creator() allow to create Character to the player : it use methods "askX()" to have specifications of the
     * character to create.
     * if specifications are not in the normal range, program throw BadSpecException
     * @return the character created.
     */
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

    /**
     * Performs basic attack from the character to the character attacked. Display texts with actions done and damages done
     * @param attacked : character attacked
     */
    void basicAttack(Player attacked){
        character.basicAttack(attacked.getCharacter());
        System.out.println(name + character.displayBasicAttack());
        System.out.println(attacked.getName() + " perd " + character.getBasicDamage() + " points de vie.");
    }

    /**
     * perform special Attack from the character to the character attacked
     * IMPORTANT : if the character who perform this attack is Magus or Ranger, attacked must be himself !!
     * @param attacked is the target of the attack
     */
    void specialAttack(Player attacked){
        character.specialAttack(attacked.getCharacter());
        System.out.println(name + character.displaySpecialAttack());

        if (character instanceof Warrior){
            System.out.println(attacked.getName() + " perd " + character.getSpecialDamages() + " points de vie.");
            System.out.println(name + " perd " + character.getBasicDamage()/2 + " points de vie.");
        }
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

    String getName(){
        return name;
    }

    Character getCharacter(){
        return character;
    }


}
