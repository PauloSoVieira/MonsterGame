package Mindera.Swap.MonsterExercise.monsters;

import Mindera.Swap.MonsterExercise.RandomNum.RandomMonster;

public class Vampire extends Monster {
    public Vampire(int healthBar, int attackDmg) {
        super(healthBar, attackDmg);
    }

    public void vampireAttack(Monster monster) {
        int random = RandomMonster.generateRandomNumber(0, 1);
        if (monster.getHealthBar() <= 0) {
            System.out.println("Monster is fainted you cant attack");
            return;
        }

        //TODO change 10 to %

        if (random == 0) {
            attackBattle(monster);
            attackBattle(monster);
            setHealthBar(getHealthBar() + getAttackDmg());
            System.out.println("Vampire attacked twice! Did " + getAttackDmg() * 2 + " damage to enemy and recovered 10 of life");

        } else {
            attackBattle(monster);
            setHealthBar(getHealthBar() + 5);
            System.out.println("Vampire attacked once and did " + getAttackDmg() + " damage to enemy and recovered 5 of life");
        }
    }

}
