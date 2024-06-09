package Mindera.Swap.MonsterExercise.monsters;

import Mindera.Swap.MonsterExercise.Strikeable;
import Mindera.Swap.MonsterExercise.Supernatural;

public abstract class Monster extends Supernatural implements Strikeable {
    protected int healthBar;

    public Monster(int healthBar, int attackDmg) {
        super(attackDmg);
        this.healthBar = healthBar;

    }
    public Monster(int healthBar, int attackDmg, String name) {
        super(attackDmg,name);
        this.healthBar = healthBar;

    }

    @Override
    public void takeDamage(int damage) {

        this.healthBar -= damage;
        if (this.healthBar < 0) {
            this.healthBar = 0;
        }
    }
    @Override
    public int getHealthBar() {
        return healthBar;
    }

    @Override
    public void setHealthBar(int healthBar) {
        this.healthBar = healthBar;
    }

    @Override
    public boolean isFainted() {
        return this.healthBar <= 0;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "healthBar=" + healthBar +
                ", attackDmg=" + getPower() +
                '}';
    }
    }



