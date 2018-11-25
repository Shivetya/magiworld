package com.shivetya.magiworld;

public class Game {

    Input input = new Input();

    public Game(){

        System.out.println("Creation du Joueur 1");
        Player player1 = new Player(1);
        System.out.println("Creation du Joueur 2");
        Player player2 = new Player(2);

        while (!player1.getCharacter().isDead() || !player2.getCharacter().isDead()){

            action(player1, player2);

            if (!player1.getCharacter().isDead() || !player2.getCharacter().isDead()) {
                action(player2, player1);
            }
        }

        if (player1.getCharacter().isDead() && player2.getCharacter().isDead()) System.out.println("Les deux Joueurs sont morts, personne n'a gagné");
        else if (player1.getCharacter().isDead()) System.out.println(player1.getName() + " a perdu !");
        else if (player2.getCharacter().isDead()) System.out.println(player2.getName() + " a perdu !");

    }

    void action(Player activePlayer, Player passivePlayer){

        Integer choice = null;

        while(choice == null || choice < 1 || choice > 2){
            choice = input.askAction(activePlayer);
        }

        switch(choice){
            case 1 :
                activePlayer.basicAttack(passivePlayer); break;

            case 2 :
                activePlayer.specialAttack(passivePlayer); break;
        }
    }
}
