package Mindera.Swap.MonsterExercise;

import Mindera.Swap.MonsterExercise.RandomNum.RandomMonster;
import Mindera.Swap.MonsterExercise.monsters.*;

public class Game {
    Player p1 = new Player("joao", 2);
    Player p2 = new Player("Ana", 2);
    private int turn = 1;
    private Supernatural obstacle = null;

    public void startGame() {
        p1.createPlayerHand();
        p2.createPlayerHand();

        if (p1.getMonsterCards().length != p2.getMonsterCards().length) {
            System.out.println("Player " + p1.getName() + " and player " + p2.getName() + " don't have the same amount of cards!");
            System.out.println("Players must have the same number of cards to start game");
            return;
        }
        p1.showPlayerHand();
        p2.showPlayerHand();

        while (true) {
            if (obstacle == null) {
                obstacle = createObstacle();
            }

            if (playRound(p1, p2)) {
                break;
            }
            if (playRound(p2, p1)) {
                break;
            }
        }
    }

    //TODO monsters attack Witch and fairy ( fairy cant be attacked)
    //Random numbers to create obstacle , null = no obstacles in that turn
    public Supernatural createObstacle() {
        int random = RandomMonster.generateRandomNumber(0, 10);
        if (random == 2) {
            Fairy fairy = new Fairy(20, "Wild Fairy");
            System.out.println("A Wild Fairy has appeared!");
            return fairy;
        }
        if (random == 3) {
            Witch witch = new Witch(100, 20, "Wild Witch");
            System.out.println("A Wild Witch has appeared!");
            return witch;
        }
        return null;
    }


    // game logic
    public boolean playRound(Player attacker, Player defender) {


        int randomAttackingMonster = findMonstersAlive(attacker);
        int randomDefendingMonster = findMonstersAlive(defender);

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

        System.out.println("\nTurn : " + turn + " will begin! It's time for " + attacker.getName() + " to attack\n");

        MonsterCard attackingMonster = attacker.getMonsterCards()[randomAttackingMonster];
        MonsterCard defendingMonster = defender.getMonsterCards()[randomDefendingMonster];

     /*   if (attackingMonster.isFainted()) {
            System.out.println(attacker.getName() + " can't attack with a fainted monster");
            turn++;
            return false;
        }
        if (defendingMonster.isFainted()) {
            System.out.println(attacker.getName() + " can't attack a fainted monster");
            turn++;
            return false;
        }*/


        // Verify if exist one obstacle first , attack and leave / null
        if (obstacle != null) {
            if (obstacle instanceof Fairy) {
                System.out.println("The obstacle " + obstacle.getName() + " attacks a random monster from both players!");
                attackRandomMonster(p1, obstacle);
                attackRandomMonster(p2, obstacle);
                obstacle = null;
            } else if (obstacle instanceof Witch) {
                System.out.println("The obstacle " + obstacle.getName() + " attacks a random monster from both players!");
                attackRandomMonster(p1, obstacle);
                attackRandomMonster(p2, obstacle);
                attackingMonster.getMonster().attack((Strikeable) obstacle);
                defendingMonster.getMonster().attack((Strikeable) obstacle);

                obstacle = null;
            }
            turn++;
            return false;
        }

        //Starts normal turn player vs player

        System.out.println(attacker.getName() + " will attack with " + attackingMonster + " against " + defender.getName() + "'s monster " + defendingMonster);

        if (attackingMonster.getMonsterType() == MonsterTypeEnum.VAMPIRE) {
            attackingMonster.getMonster().attack(defendingMonster.getMonster());
        } else if (attackingMonster.getMonsterType() == MonsterTypeEnum.MUMMY) {
            attackingMonster.getMonster().attack(defendingMonster.getMonster());
        } else {
            ((Werewolf) attackingMonster.getMonster()).attack(defendingMonster.getMonster());
        }

        if (defendingMonster.getMonster().getHealthBar() <= 0) {
            System.out.println(defender.getName() + "'s monster " + defendingMonster.getMonsterType() + " fainted!");
            defendingMonster.setFainted(true);
        }

        System.out.println("Turn ends with " + defender.getName() + "'s monster " + defendingMonster.getMonsterName() + " with " + defendingMonster.getMonster().getHealthBar() + " HP");
        System.out.println();
        turn++;
        return false;
    }


    // Same as finding monster alive from player hand but now to obstacle attack
    private void attackRandomMonster(Player player, Supernatural obstacle) {
        int randomMonsterIndex = findMonstersAlive(player);
        if (randomMonsterIndex != -1) {
            MonsterCard monsterCard = player.getMonsterCards()[randomMonsterIndex];
            obstacle.attack(monsterCard.getMonster());
            if (monsterCard.getMonster().getHealthBar() <= 0) {
                System.out.println(player.getName() + "'s monster " + monsterCard.getMonsterType() + " fainted!");
                monsterCard.setFainted(true);
            }
            System.out.println(player.getName() + "'s monster " + monsterCard.getMonsterName() + " now has " + monsterCard.getMonster().getHealthBar() + " HP");
        }
    }



    //Cehck monsters from player hand fining one alive
    private int findMonstersAlive(Player player) {
        MonsterCard[] monsters = player.getMonsterCards();
        int monstersAlive = 0;
        int[] monstersAliveArray = new int[monsters.length];
        for (int i = 0; i < monsters.length; i++) {
            if (!monsters[i].isFainted()) {
                monstersAliveArray[monstersAlive++] = i;
            }
        }
        if (monstersAlive == 0) {
            return -1;
        }
        int randomMonsterAlive = RandomMonster.generateRandomNumber(0, monstersAlive - 1);
        return monstersAliveArray[randomMonsterAlive];
    }
}
