package Mindera.Swap.MonsterExercise;

import Mindera.Swap.MonsterExercise.RandomNum.RandomMonster;
import Mindera.Swap.MonsterExercise.monsters.*;

public class Game {
    Player p1 = new Player("joao", 2);
    Player p2 = new Player("Ana", 2);
    private int turn = 1;

    public void startGame() {


        p1.createPlayerHand();
        p2.createPlayerHand();


        //TODO create guessing number and check if they choose same number of cards

        if (p1.getMonsterCards().length != p2.getMonsterCards().length) {
            System.out.println("Player " + p1.getName() + " and player " + p2.getName() + " don't have the same amount of cards!");
            System.out.println("Players must have the same number of cards to start game");
            return;
        }
        p1.showPlayerHand();
        p2.showPlayerHand();

        while (true) {
            if (playRound(p1, p2)) {
                break;
            }
            if (playRound(p2, p1)) {
                break;
            }

        }
    }

    public boolean playRound(Player attacker, Player defender) {

        // Attacker's turn

        int randomAttackingMonster = findMonstersAlive(attacker);
        int randomDefendingMonster = findMonstersAlive(defender);

        //Checking if attacker and defending player have any monster alive
     /*   if (attacker.hasLost()) {
            System.out.println("Game Over! " + defender.getName() + " has won!");
            return true;
        }
        if (defender.hasLost()) {
            System.out.println("Game Over! " + attacker.getName() + " has won!");
            return true;
        }
        */
        //Checking if attacker and defending player have any monster alive
        //  all fainted monster , the player loses
        if (randomAttackingMonster == -1) {
            System.out.println("Game Over! " + attacker.getName() + " has no monsters left to attack!");
            System.out.println("Game Over! " + defender.getName() + " has won!");
            return true;
        }
        if (randomDefendingMonster == -1) {
            System.out.println("Game Over! " + defender.getName() + " has no monsters left to defend!");
            System.out.println("Game Over! " + attacker.getName() + " has won!");
            return true;
        }
        System.out.println("\n" + "Turn : " + turn + " will begin ! Its time to " + attacker.getName() + " attack" + "\n");


        MonsterCard attackingMonster = attacker.getMonsterCards()[randomAttackingMonster];
        MonsterCard defendingMonster = defender.getMonsterCards()[randomDefendingMonster];


        //Checking if monster is fainted or no

    /*    if (attackingMonster.isFainted()) {
            System.out.println(attacker.getName() + " can't attack with a fainted monster");
            turn++;
            return false;
        }
        if (defendingMonster.isFainted()) {
            System.out.println(attacker.getName() + " can't attack a fainted monster");
            turn++;
            return false;
        }

        System.out.println(attacker.getName() + " will attack with " + attackingMonster + " against " + defender.getName() + "'s monster " + defendingMonster);
 */
        if (attackingMonster.getMonsterType() == MonsterTypeEnum.VAMPIRE) {
            ((Vampire) attackingMonster.getMonster()).vampireAttack(defendingMonster.getMonster());
        } else if (attackingMonster.getMonsterType() == MonsterTypeEnum.MUMMY) {
            ((Mummy) attackingMonster.getMonster()).mummyAttack(defendingMonster.getMonster());
        } else {
            ((Werewolf) attackingMonster.getMonster()).werewolfAttack(defendingMonster.getMonster());
            // attackingMonster.getMonster().attackBattle(defendingMonster.getMonster());
        }


        // Checking if the defending monster will faint in battle

        if (defendingMonster.getMonster().getHealthBar() <= 0) {
            System.out.println(defender.getName() + "'s monster " + defendingMonster.getMonsterType() + " fainted!");
            defendingMonster.setFainted(true);  //Put this monster as fainted
        }


        System.out.println("Turn ends with " + defender.getName() + "'s monster " + defendingMonster.getMonsterName() + " with " + defendingMonster.getMonster().getHealthBar() + " HP");
        System.out.println();
        turn++;
        return false;

    }
//TODO keep choosing fainted monsters to attack or defend
    //Put all fainted to null and ignore?  xxxxxx
    // int if 0 is good if 1 is fainted?   xxxxxx
    //Array with only monsters alive?

    private int findMonstersAlive(Player player) {
        MonsterCard[] monsters = player.getMonsterCards();
        int monstersAlive = 0;
        //Create new array to iterate over ,
        int[] monstersAliveArray = new int[monsters.length];
        //Add monsters alive to index i
        for (int i = 0; i < monsters.length; i++) {
            if (!monsters[i].isFainted()) {
                monstersAliveArray[monstersAlive++] = i;
            }
        }
        //no monsters alive return -1
        if (monstersAlive == 0) {
            return -1;
        }
        int randomMonsterAlive = RandomMonster.generateRandomNumber(0, monstersAliveArray.length - 1);
        return monstersAliveArray[randomMonsterAlive];
    }

}
