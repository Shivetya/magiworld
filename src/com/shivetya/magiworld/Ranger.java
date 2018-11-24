package com.shivetya.magiworld;

public class Ranger implements Character {

    private int level;
    private int strength;
    private int life;
    private int agility;
    private int intelligence;

    /**
     * Creator of Ranger : Strength + agility + intelligence must be equals to level.
     * Life must be 5*level.
     * @param level chosen by player, between 1 and 100
     * @param strength chosen by player, between 0 and 100
     * @param agility chosen by player between 0 and 100
     * @param intelligence chosen by player between 0 and 100
     */

    public Ranger(int level, int strength, int agility, int intelligence){

        this.level = level;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;

        life = level * 5;
    }

    /**
     * Ranger attacks the character in parameter with basic attack : damage equals to Agility.
     * @param attacked is the character who takes damages
     */

    @Override
    public void basicAttack(Character attacked) {

        attacked.damaged(agility);
    }

    /**
     * Ranger performs his special skill. the param is not used, it is here for more facilities in Game.
     * @param himself : useless here, but usefull for others Characters specials attacks
     */

    @Override
    public void specialAttack(Character himself) {

        agility += level/2;
    }

    /**
     * Ranger takes damages : life = life - damage
     * @param damage done
     */

    @Override
    public void damaged(int damage) {

        life -= damage;

        if (life < 0)
            life = 0;

    }

    /**
     * Methods to know if the Ranger is dead, so if the life = 0
     * @return true if dead
     */

    @Override
    public boolean isDead(){
        return life <= 0;
    }

    @Override
    public String displayBasicAttack() {
        return " utilise Tir à l'Arc et inflige " + agility + " dommages.";
    }

    @Override
    public String displaySpecialAttack() {
        return " utilise Concentration et gagne " + level/2 + " en agilité.";
    }

    @Override
    public int getBasicDamage() {
        return agility;
    }

    @Override
    public int getSpecialDamages() {
        return level/2;
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
    public int getLife() {
        return life;
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
