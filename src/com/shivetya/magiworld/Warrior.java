package com.shivetya.magiworld;

public class Warrior implements Character {

    private int level;
    private int strength;
    private int life;
    private int agility;
    private int intelligence;

    public Warrior(int level, int strength, int agility, int intelligence)
    {
        this.level = level;
        this.strength = strength;
        this. agility = agility;
        this.intelligence = intelligence;

        life = level * 5;

    }

    @Override
    public int basicAttack(Character attacked) {

        return 0;
    }

    @Override
    public int specialAttack(Character attacked) {
        return 0;
    }

    public void attacked(int damage) {
        this.life -= damage;
    }

    @Override
    public int getLife() {
        return life;
    }
}
