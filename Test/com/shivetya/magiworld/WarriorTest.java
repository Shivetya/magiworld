package com.shivetya.magiworld;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WarriorTest {

    @Test
    void Given_BasicAttack_When_DamagedOnHimself_Tehn_DamagesOnHimselfEqualsToStrength(){
        Warrior test = new Warrior(30,10,10,10);
        test.basicAttack(test);
        assertEquals("Les dégats doivent être égaux à l'agilité, la vie du personnage doit descendre", 140, test.getLife());
    }

    @Test
    void Given_SpecialAttack_When_SpecialAttack_Then_DamagedOfHitAndExtraDamages(){
        Warrior test = new Warrior(30,10,10,10);
        test.specialAttack(test);
        assertEquals("Le personnage doit subir en dégat la force *2 + la force / 2", 125, test.getLife());
    }
    @Test
    void Given_Dead_When_DamagedUntilDeath_Then_ReturnIsDeadTrue(){
        Warrior test = new Warrior(1,0,0,1);
        Warrior killer = new Warrior(50,50,0,0);
        killer.basicAttack(test);
        assertTrue(test.isDead());
    }
}