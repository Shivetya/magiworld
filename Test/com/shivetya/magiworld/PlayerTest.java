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

    @Test
    void Given_Player1GetPresentation_When_CharacIsWarrior_Then_PresentationOfWarrior(){
        Warrior warrior = new Warrior(30,10,10,10);
        Player player1 = new Player(1,warrior);
        assertEquals("","Woarg, je suis le Guerrier Joueur 1 niveau 30 je possède 150 de vitalité, 10 de force, 10 d'agilité, 10 d'intelligence !", player1.getPresentation());
    }

    @Test
    void Given_Player2GetPresentation_When_CharacIsMagus_Then_PresentationOfMagus(){
        Magus magus = new Magus(30,10,10,10);
        Player player2 = new Player(2,magus);
        assertEquals("","Abracadabra, je suis le Mage Joueur 2 niveau 30 je possède 150 de vitalité, 10 de force, 10 d'agilité, 10 d'intelligence !", player2.getPresentation());
    }

    @Test
    void Given_Player2GetPresentation_When_CharacIsRanger_Then_PresentationOfRanger(){
        Ranger ranger = new Ranger(30,10,10,10);
        Player player2 = new Player(2,ranger);
        assertEquals("","Chhhut, je suis le Rôdeur Joueur 2 niveau 30 je possède 150 de vitalité, 10 de force, 10 d'agilité, 10 d'intelligence !", player2.getPresentation());
    }


}