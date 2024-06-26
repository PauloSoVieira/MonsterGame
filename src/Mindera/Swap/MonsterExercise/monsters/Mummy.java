package Mindera.Swap.MonsterExercise.monsters;

import Mindera.Swap.MonsterExercise.Strikeable;

public class Mummy extends Monster {
    private int numberOfAttacks;


    public Mummy(int healthBar, int attackDmg , String name) {
        super(healthBar, attackDmg, name);
        this.numberOfAttacks = 0;
    }

    public Mummy(int healthBar, int attackDmg ) {
        super(healthBar, attackDmg);
        this.numberOfAttacks = 0;
    }

    @Override
    public void attack(Strikeable monster) {
        if (monster.getHealthBar() <= 0) {
            System.out.println("Monster is fainted, you can't attack");
            return;
        }
        if (numberOfAttacks < 2) {
            super.attack(monster);
            System.out.println("Mummy attacked once and did " + getPower() + " damage to the enemy");
            numberOfAttacks++;
        } else {
            System.out.println("Mummy failed the attack and lost 5 HP");
            setHealthBar(getHealthBar() - 5);
            numberOfAttacks = 0;
        }
    }
}