package com.shivetya.magiworld;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RangerTest {

    @Test
    void Given_BasicAttack_When_DamagedOnHimself_Then_DamagesOnHimselfEqualsToAgility(){
        Ranger test = new Ranger(30,10,10,10);
        test.basicAttack(test);
        assertEquals("Les dégats doivent être égaux à l'agilité, la vie du personnage doit descendre",140, test.getLife());
    }

    @Test
    void Given_SpecialAttack_When_SpecialAttack_Then_AddHalfLevelToAgility(){
        Ranger test = new Ranger(30,10,10,10);
        test.specialAttack(test);
        assertEquals("L'agilité doit doubler avec l'attaque spéciale", 25, test.getAgility());
    }
    @Test
    void Given_Dead_When_DamagedUntilDeath_Then_ReturnIsDeadTrue(){
        Ranger test = new Ranger(1,0,1,0);
        Warrior killer = new Warrior(50,50,0,0);
        killer.basicAttack(test);
        assertTrue(test.isDead());
    }
}