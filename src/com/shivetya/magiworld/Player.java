package com.shivetya.magiworld;

class Player {

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
     * @param number : number of the player
     * @param character : character of the player
     */
    Player(int number, Character character){

        name = "Joueur "+number;
        this.character = character;
    }

    /**
     * Methods Creator() allow to create Character to the player : it use methods "askX()" to have specifications of the
     * character to create.
     * if specifications are not in the normal range, defined by the rules, program will ask again specifications.
     * @return the character created.
     */
    private Character creator(){

        CharacterInput characterInput = input.askCharacter();
        Integer[] carac = input.askCarac();
        Character character = null;

        while(carac[1] + carac[2] + carac[3] != carac[0] || carac[0] < 1 || carac[0] > 100 || carac[1] < 0 || carac[1] > 100
        || carac[2] < 0 || carac[2] > 100 || carac[3] < 0 || carac[3] > 100) {

            System.out.println("Niveau entre 1 et 100, force, agilité et intelligence entre 0 et 100.\n" +
                    "La somme de la force, de l'agilité et de l'intelligence doit être égale au niveau.\n");

            carac = input.askCarac();
        }

        switch(characterInput){
            case WARRIOR:
                character = new Warrior(carac[0], carac[1], carac[2], carac[3]);
                break;

            case RANGER:
                character = new Ranger(carac[0], carac[1], carac[2], carac[3]);
                break;

            case MAGUS:
                character = new Magus(carac[0], carac[1], carac[2], carac[3]);
                break;
        }

        return character;
    }

    /**
     * method created from creator only for test of condition in playerTest.
     * @param carac int[5] with class, level, strength, agility, intelligence.
     */
    void creator(int[] carac){

        Character character;

        if (carac[2] + carac[3] + carac[4] != carac[1] || carac[1] < 1 || carac[1] > 100 || carac[2] < 0 || carac[2] > 100
                || carac[3] < 0 || carac[3] > 100 || carac[4] < 0 || carac[4] > 100) {
            this.character = null;
        }
        else{

            switch(carac[0]) {
                case 1:
                    character = new Warrior(carac[1], carac[2], carac[3], carac[4]);
                    break;

                case 2:
                    character = new Ranger(carac[1], carac[2], carac[3], carac[4]);
                    break;

                case 3:
                    character = new Magus(carac[1], carac[2], carac[3], carac[4]);
                    break;

                default:
                    character = null;
            }
            this.character = character;
        }
    }

    /**
     * Performs basic attack from the character to the character attacked. Display texts with actions done and damages done
     * @param attacked : character attacked
     */
    void basicAttack(Player attacked){
        character.basicAttack(attacked.getCharacter());
        System.out.println(name + character.displayBasicAttack());
        System.out.println(attacked.getName() + " perd " + character.getBasicDamage() + " points de vie.");
        if (attacked.getCharacter().isDead()){
            System.out.println(attacked.getName() + " est mort");
        }
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

            if(attacked.getCharacter().isDead()){
                System.out.println(attacked.getName() + " est mort");
            }

            System.out.println(name + " perd " + character.getBasicDamage()/2 + " points de vie.");

            if(character.isDead()){
                System.out.println(getName() + " est mort");
            }
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
