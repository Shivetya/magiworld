package com.shivetya.magiworld;

interface Character {

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
