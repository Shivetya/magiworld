package com.shivetya.magiworld;

interface Character {

    /**
     * basicAttack & specialAttack are two actions possible for each character : they have the target Character in parameter.
     * damaged() allow to decrease life of the character, depend to the damages
     * isDead allow to know if the life's character equals 0
     * getBasicDamage & getSpecialDamage return the exact damages done
     */
    void basicAttack(Character attacked);
    void specialAttack(Character attacked);
    void damaged(int damage);
    boolean isDead();
    String displayBasicAttack();
    String displaySpecialAttack();

    int getLife();
    int getLevel();
    int getStrength();
    int getAgility();
    int getIntelligence();
    int getBasicDamage();
    int getSpecialDamages();

}
