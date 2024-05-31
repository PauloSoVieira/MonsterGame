package Mindera.Swap.MonsterExercise;


import Mindera.Swap.MonsterExercise.RandomNum.RandomMonster;
import Mindera.Swap.MonsterExercise.monsters.*;

import java.util.Arrays;

public class Player {


    private String name;
    private MonsterCard[] monsterCards;

    public Player(String name, int monsterCards) {
        this.name = name;
        this.monsterCards = new MonsterCard[monsterCards];
    }

    public MonsterCard[] getMonsterCards() {
        return monsterCards;
    }

    public String getName() {
        return name;
    }

    //TODO Change createcards to game

    public void createPlayerHand() {
        MonstersEnum[] totalMonsters = MonstersEnum.values();
        for (int i = 0; i < monsterCards.length; i++) {
            int random = RandomMonster.generateRandomNumber(0, totalMonsters.length - 1);
            MonstersEnum monsterEnum = totalMonsters[random];
            //start null
            //TODO to set monsters null / fainted
            Monster monster = null;

            switch (monsterEnum.getMonsterType()) {
                case VAMPIRE:
                    monster = new Vampire(monsterEnum.getHealthBar(), monsterEnum.getAttackDamage());
                    break;
                case MUMMY:
                    monster = new Mummy(monsterEnum.getHealthBar(), monsterEnum.getAttackDamage());
                    break;
                case WEREWOLF:
                    monster = new Werewolf(monsterEnum.getHealthBar(), monsterEnum.getAttackDamage());
                    break;
            }

            if (monster != null) {
                monsterCards[i] = new MonsterCard(monsterEnum.name(), monsterEnum.getMonsterType(), monster);
            }
        }
    }

    /*
    public boolean hasLost() {
        for (MonsterCard card : monsterCards) {
            if (!card.isFainted()) {
                return false; //Theres monsters alive
            }

        }
        return true;
    }*/

    public void showPlayerHand() {
        System.out.print("\n" + name + " has these monsters: ");
        for (MonsterCard card : monsterCards) {
            System.out.print(card);
        }
        System.out.println();
    }


    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", monsterCards=" + Arrays.toString(monsterCards) +
                '}';
    }
}
