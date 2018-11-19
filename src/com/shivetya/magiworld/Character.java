package com.shivetya.magiworld;

interface Character {

    void basicAttack(Character attacked);
    void specialAttack(Character attacked);
    void damaged(int damage);

}
