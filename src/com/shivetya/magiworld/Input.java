package com.shivetya.magiworld;

import java.util.Scanner;

class Input {

    private Scanner sc = new Scanner(System.in);

    Input(){

    }

    /**
     * This method allow to ask specifications to the player, using methods askCharacter and the others ask methods.
     * Every ask methods are secured with try/catch.
     * @return tabular with all caracteritics (5 in total).
     */

    Integer[] askCarac(){
        Integer[] carac = new Integer[5];

        carac[0] = askCharacter();
        carac[1] = askLevel();
        carac[2] = askStrength();
        carac[3] = askAgility();
        carac[4] = askIntelligence();
        return carac;
    }

    private Integer askCharacter(){

        Integer choice = null;

        while(choice == null){
            try {
                System.out.println("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)");
                choice = sc.nextInt();
            } catch(IllegalArgumentException e){
                choice = null;
            }
        }
        return choice;
    }

    private Integer askLevel() {

        Integer level = null;

        while(level == null){
            try{
                System.out.println("Niveau du personnage ?");
                level = sc.nextInt();

            }catch(IllegalArgumentException e){
                level = null;
                System.out.println("Le niveau doit être comprit entre 1 et 100 inclus.");
            }
        }

        return level;
    }

    private Integer askStrength(){

        Integer strength = null;

        while(strength == null){
            try{
                System.out.println("Force du personnage ?");
                strength = sc.nextInt();

            }catch(IllegalArgumentException e){
                strength = null;
                System.out.println("La force doit être comprit entre 0 et 100 inclus.");
            }
        }
        return strength;
    }

    private Integer askAgility() {

        Integer agility = null;

        while(agility == null){
            try{
                System.out.println("Agilité du personnage ?");
                agility = sc.nextInt();

            }catch(IllegalArgumentException e){
                agility = null;
                System.out.println("L'agilité doit être comprit entre 0 et 100 inclus.");
            }
        }

        return agility;
    }

    private Integer askIntelligence() {

        Integer intelligence = null;

        while(intelligence == null){
            try{
                System.out.println("Intelligence du personnage ?");
                intelligence = sc.nextInt();

            }catch(IllegalArgumentException e){
                intelligence = null;
                System.out.println("L'intelligence doit être comprit entre 0 et 100 inclus.");
            }
        }

        return intelligence;
    }

}
