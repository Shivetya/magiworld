package com.shivetya.magiworld;

interface Character {

    /**
     * basicAttack & specialAttack are two actions possible for each character : the have the target Character in parameter.
     * damaged() allow to decrease life of the character, depend to the damages
     * isDead allow to know if the life's character equals 0
     */
    void basicAttack(Character attacked);
    void specialAttack(Character attacked);
    void damaged(int damage);
    boolean isDead();

    int getLife();
    int getLevel();
    int getStrength();
    int getAgility();
    int getIntelligence();

}
