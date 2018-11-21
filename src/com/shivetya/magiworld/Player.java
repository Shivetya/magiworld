package com.shivetya.magiworld;

import java.util.Scanner;

public class Player {

    private static Input input = new Input();

    private Character character;
    private String name;


    Player(int number){

        name = "Joueur "+number;
        character = creator();
        getPresentation();
    }

    /**
     * Constructor used to test some methods in this Class. It allow to add a Character without the constructor()
     * @param number
     * @param character
     */
    Player(int number, Character character){

        name = "Joueur "+number;
        this.character = character;
    }

    /**
     * Methods Creator() allow to create Character to the player : it use methods "askX()" to have specifications of the
     * character to create.
     * if specifications are not in the normal range, program throw BadSpecException
     * @return the character created.
     */
    private Character creator(){

        int choice = input.askCharacter();
        int level = input.askLevel();
        int strength = input.askStrength();
        int agility = input.askAgility();
        int intelligence = input.askIntelligence();
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

    /**
     * Allow to print presentation of the character created according to his class.
     * @return the presentation
     */

    String getPresentation(){
        String presentation ="";
        if (character instanceof Warrior){
            presentation = "Woarg, je suis le Guerrier " + name + " niveau " + character.getLevel() +
                    " je possède " + character.getLife() + " de vitalité, " + character.getStrength() + " de force, " +
                    character.getAgility() + " d'agilité, " + character.getIntelligence() + " d'intelligence !";
        }
        else if (character instanceof Magus){
            presentation = "Abracadabra, je suis le Mage " + name + " niveau " + character.getLevel() +
                    " je possède " + character.getLife() + " de vitalité, " + character.getStrength() + " de force, " +
                    character.getAgility() + " d'agilité, " + character.getIntelligence() + " d'intelligence !";
        }
        else if (character instanceof Ranger){
            presentation = "Chhhut, je suis le Rôdeur " + name + " niveau " + character.getLevel() +
                    " je possède " + character.getLife() + " de vitalité, " + character.getStrength() + " de force, " +
                    character.getAgility() + " d'agilité, " + character.getIntelligence() + " d'intelligence !";
        }
        return presentation;
    }

    String getName(){
        return name;
    }

    Character getCharacter(){
        return character;
    }


}
