package com.shivetya.magiworld;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class MagusTest {

    @Test
    void Given_BasicAttack_When_DamagedOnHimself_Then_DamagesOnHimselfEqualsToIntelligence(){
        Magus test = new Magus(30,10,10,10);
        test.basicAttack(test);
        assertEquals("Les dégats doivent être égaux à l'intelligence, la vie du personnage doit descendre",140, test.getLife());
    }

    @Test
    void Given_SpecialAttack_When_MoreHealThanNecessary_Then_NegativeDamageUntilMaxLife(){
        Magus test = new Magus(30,10,10,10);
        test.basicAttack(test);
        test.specialAttack(test);
        assertEquals("La vie ne doit pas dépasser la vie max", 150, test.getLife());
    }

    @Test
    void Given_SpecialAttack_When_HealNotSuperiorMaxLife_Then_NegativeDamage2xIntelligence(){
        Magus test = new Magus(30,10,10,10);
        test.basicAttack(test);
        test.basicAttack(test);
        test.basicAttack(test);
        test.specialAttack(test);
        assertEquals("La vie doit remonter de deux fois l'intelligence",140, test.getLife());
    }

    @Test
    void Given_Dead_When_DamagedUntilDeath_Then_ReturnIsDeadTrue(){
        Magus test = new Magus(1,0,0,1);
        Warrior killer = new Warrior(50,50,0,0);
        killer.basicAttack(test);
        assertTrue(test.isDead());
    }
}