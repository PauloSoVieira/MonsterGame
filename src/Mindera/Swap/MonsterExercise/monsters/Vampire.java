package Mindera.Swap.MonsterExercise.monsters;

import Mindera.Swap.MonsterExercise.RandomNum.RandomMonster;
import Mindera.Swap.MonsterExercise.Strikeable;
import Mindera.Swap.MonsterExercise.Witch;

import static Mindera.Swap.MonsterExercise.monsters.MonstersEnum.VAMPIRE;

public class Vampire extends Monster {
    private int drainLife = 2;



    public Vampire(int healthBar, int attackPower, String name) {
        super(healthBar, attackPower, name);
    }
    public Vampire(int healthBar, int attackPower) {
        super(healthBar, attackPower);
    }

    public Vampire() {
        super(VAMPIRE.getHealthBar(), VAMPIRE.getAttackDamage());
    }

    @Override
    public void attack(Strikeable monster) {
        if (RandomMonster.generateRandomNumber(1, 5) == drainLife) {
            System.out.println("Vampire bites the enemy. Health increase by " + getPower() + " hp");
            this.drainLifeFromMonster(getPower());
        } else {
            int damage = getPower();
            if (monster instanceof Witch) {
                System.out.println("Vampire attacks the Witch with half damage!");
                damage /= 2;
            }
            System.out.println("Vampire attacks with " + damage + " damage!");
            monster.takeDamage(damage);
            if (monster instanceof Witch) {
                System.out.println("Witch receives half of the damage!");
                this.drainLifeFromMonster(damage / 2);
            }
        }
        super.attack(monster);
    }

    private void drainLifeFromMonster(int increaseAmount) {
        int health = this.getHealthBar() + increaseAmount;
        System.out.println("Increasing health: " + increaseAmount + ", New health: " + health);
        this.setHealthBar(health);

    }

}