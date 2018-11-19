package com.shivetya.magiworld;

public class Ranger implements Character {

    private int level;
    private int strength;
    private int life;
    private int agility;
    private int intelligence;

    public Ranger(int level, int strength, int agility, int intelligence){

        this.level = level;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;

        life = level * 5;
    }

    @Override
    public void basicAttack(Character attacked) {

        attacked.damaged(agility);
    }

    @Override
    public void specialAttack(Character attacked) {

        agility += level/2;
    }

    @Override
    public void damaged(int damage) {

        life -= damage;
    }

    public int getLevel() {
        return level;
    }

    public int getStrength() {
        return strength;
    }

    public int getLife() {
        return life;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntelligence() {
        return intelligence;
    }
}
