package com.shivetya.magiworld;

public class Magus implements Character{

    private int level;
    private int strength;
    private int life;
    private int agility;
    private int intelligence;

    /**
     * Creator of magus : Strength + agility + intelligence must be equals to level.
     * Life must be 5*level.
     * @param level chosen by player, between 1 and 100
     * @param strength chosen by player, between 0 and 100
     * @param agility chosen by player between 0 and 100
     * @param intelligence chosen by player between 0 and 100
     */

    public Magus(int level, int strength, int agility, int intelligence){
        this.level = level;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;

        life = level * 5;
    }

    /**
     * Magus attacks the character in parameter with basic attack : damage equals to intelligence.
     * @param attacked  is the character who takes damages
     */

    @Override
    public void basicAttack(Character attacked) {
        attacked.damaged(intelligence);
    }

    /**
     * Magus heals himself : heal equals to intelligence * 2
     * @param himself
     */
    @Override
    public void specialAttack(Character himself) {
        himself.damaged(-2 * intelligence);
        if (himself.getLife() > level * 5 )
            life = level*5;
    }

    /**
     * Magus takes damages : life = life - damage
     * @param damage done
     */
    @Override
    public void damaged(int damage) {
        life -= damage;

        if (life < 0)
            life = 0;
    }

    /**
     * Methods to know if the Magus is dead, so if the life = 0
     * @return true if dead
     */

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
