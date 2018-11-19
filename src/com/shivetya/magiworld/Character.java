package com.shivetya.magiworld;

interface Character {

    int basicAttack(Character attacked);
    int specialAttack(Character attacked);
    void attacked(int damage);

    int getLife();

}
