package com.shivetya.magiworld;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

class RangerTest {

    @Test
    void Given_BasicAttack_When_DamagedOnHimself_Then_DamagesOnHimselfequalsToAgility(){
        Ranger test = new Ranger(30,10,10,10);
        test.basicAttack(test);
        assertEquals("Les dégats doivent être égaux à l'agilité, la vie du personnage doit descendre",140, test.getLife());
    }

    @Test
    void Given_SpecialAttack_When_SpecialAttack_Then_DoubleAgility(){
        Ranger test = new Ranger(30,10,10,10);
        test.specialAttack(test);
        assertEquals("L'agilité doit doubler avec l'attaque spéciale", 25, test.getAgility());
    }
}