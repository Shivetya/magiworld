package com.shivetya.magiworld;

public class Magus implements Character{

    private int level;
    private int strength;
    private int life;
    private int agility;
    private int intelligence;

    public Magus(int level, int strength, int agility, int intelligence){
        this.level = level;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;

        life = level * 5;
    }

    @Override
    public void basicAttack(Character attacked) {
        attacked.damaged(intelligence);

    }

    @Override
    public void specialAttack(Character attacked) {
        attacked.damaged(-2 * intelligence);
        if (attacked.getLife() > level * 5 )
            life = level*5;
    }

    @Override
    public void damaged(int damage) {
        life -= damage;

        if (life < 0)
            life = 0;
    }

    @Override
    public boolean isDead(){
        return life <= 0;
    }

    @Override
    public int getLife() {
        return life;
    }

    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public int getLevel() {
        return level;
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
