package com.shivetya.magiworld;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;


class PlayerTest {

    @Test
    void Given_TestPlayerBasicAttack_When_RangerAttackHimself_Then_DamageEqualsAgility(){
        Ranger ranger = new Ranger(30,10,10,10);
        Player player1 = new Player(1,ranger);
        player1.basicAttack(player1);
        assertEquals("La vie doit baisser du montant de l'agilité", 140, player1.getCharacter().getLife());
    }

    @Test
    void Given_TestPlayerSpecialAttack_When_RangerSpecialAttack_Then_AgilityPlusHalfLevel(){
        Ranger ranger = new Ranger(30,10,10,10);
        Player player1 = new Player(1, ranger);
        player1.specialAttack(player1);
        assertEquals("L'agilité doit augmenter de la moitié du niveau", 25, player1.getCharacter().getAgility());
    }




}