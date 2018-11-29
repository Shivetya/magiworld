package com.shivetya.magiworld;

import java.util.InputMismatchException;
import java.util.Scanner;

class Input {

    private Scanner sc = new Scanner(System.in);

    Input() {

    }

    /**
     * This method allow to ask specifications to the player, using methods askCharacter and the others ask methods.
     * Every ask methods are secured with try/catch.
     *
     * @return tabular with all caracteritics (5 in total).
     */

    Integer[] askCarac() {
        Integer[] carac = new Integer[4];

        carac[0] = askLevel();
        carac[1] = askStrength();
        carac[2] = askAgility();
        carac[3] = askIntelligence();
        return carac;
    }

    CharacterInput askCharacter() {

        CharacterInput choice = null;
        Integer inputPlayer;

        String message = "Veuillez choisir la classe de votre personnage (";

        for (CharacterInput ci : CharacterInput.values()){
            message += ci.getNumber() + " : " + ci.getDescription() + " ";
        }
        message += ")";

        while (choice == null) {

            System.out.println(message);

            try {

                inputPlayer = sc.nextInt();

            } catch (InputMismatchException e) {

                inputPlayer = null;
                String emptyScan = sc.nextLine();
            }
            if(inputPlayer != null){
                choice = CharacterInput.fromValues(inputPlayer);
            }
        }
        return choice;
    }

    private Integer askLevel() {

        Integer level = null;

        while (level == null) {
            try {
                System.out.println("Niveau du personnage ?");
                level = sc.nextInt();

            } catch (InputMismatchException e) {
                level = null;
                System.out.println("Le niveau doit être comprit entre 1 et 100 inclus.");
                String emptyScan = sc.nextLine();
            }
        }

        return level;
    }

    private Integer askStrength() {

        Integer strength = null;

        while (strength == null) {
            try {
                System.out.println("Force du personnage ?");
                strength = sc.nextInt();

            } catch (InputMismatchException e) {
                strength = null;
                System.out.println("La force doit être comprit entre 0 et 100 inclus.");
                String emptyScan = sc.nextLine();
            }
        }
        return strength;
    }

    private Integer askAgility() {

        Integer agility = null;

        while (agility == null) {
            try {
                System.out.println("Agilité du personnage ?");
                agility = sc.nextInt();

            } catch (InputMismatchException e) {
                agility = null;
                System.out.println("L'agilité doit être comprit entre 0 et 100 inclus.");
                String emptyScan = sc.nextLine();
            }
        }

        return agility;
    }

    private Integer askIntelligence() {

        Integer intelligence = null;

        while (intelligence == null) {
            try {
                System.out.println("Intelligence du personnage ?");
                intelligence = sc.nextInt();

            } catch (InputMismatchException e) {
                intelligence = null;
                System.out.println("L'intelligence doit être comprit entre 0 et 100 inclus.");
                String emptyScan = sc.nextLine();
            }
        }

        return intelligence;
    }

    public ActionInput askAction(Player player) {

        ActionInput action = null;
        Integer inputPlayer;
        String message = player.getName() + " (" + player.getCharacter().getLife() + ") veuillez choisir votre action (";

        for (ActionInput ai : ActionInput.values()){
            message += ai.getNumber() + " : " + ai.getDescription() + " ";
        }

        message += " )";

        while(action == null){

            System.out.println(message);

            try{

                inputPlayer = sc.nextInt();

            }catch(InputMismatchException e) {

                inputPlayer = null;
                String emptyScan = sc.nextLine();
	    }

            if (inputPlayer != null) {
                action = ActionInput.fromValues(inputPlayer);
            }
        }
        return action;
    }
}
