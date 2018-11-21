package com.shivetya.magiworld;

public class Warrior implements Character {

    private int level;
    private int strength;
    private int life;
    private int agility;
    private int intelligence;

    /**
     * Creator of Warrior : Strength + agility + intelligence must be equals to level.
     * Life must be 5*level.
     * @param level chosen by player, between 1 and 100
     * @param strength chosen by player, between 0 and 100
     * @param agility chosen by player between 0 and 100
     * @param intelligence chosen by player between 0 and 100
     */

    public Warrior(int level, int strength, int agility, int intelligence) {
        this.level = level;
        this.strength = strength;
        this. agility = agility;
        this.intelligence = intelligence;

        life = level * 5;
    }

    /**
     * Warrior attacks the character in parameter with basic attack : damage equals to strength.
     * @param attacked is the character who takes damages
     */

    @Override
    public void basicAttack(Character attacked) {

        attacked.damaged(strength);
    }

    /**
     * Warrior performs his special skill : damages are equals to 2 times the warrior strength
     * Warrior takes damages too, equals to the half of his strength
     * @param attacked : the damage are done to the character attacked
     */

    @Override
    public void specialAttack(Character attacked) {

        attacked.damaged(strength * 2);
        this.damaged(strength / 2);
    }

    /**
     * Warrior takes damages : life = life - damage
     * @param damage done
     */


    @Override
    public void damaged(int damage) {

        life -= damage;
        if (life < 0)
            life = 0;

    }

    /**
     * Methods to know if the Warrior is dead, so if the life = 0
     * @return true if dead
     */

    @Override
    public boolean isDead(){
        return life <= 0;
    }

    @Override
    public String displayBasicAttack() {
        return " utilise Coup d'Épée et inflige " + strength + " dommages.";
    }

    @Override
    public String displaySpecialAttack() {
        return " utilise Coup de Rage et inflige " + strength*2 + " dommages.";
    }

    @Override
    public int getBasicDamage() {
        return strength;
    }

    @Override
    public int getSpecialDamages() {
        return strength*2;
    }

    @Override
    public int getLife() {
        return life;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public int getAgility() {
        return agility;
    }

    @Override
    public int getIntelligence() {
        return intelligence;
    }

}
