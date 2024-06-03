package Mindera.Swap.MonsterExercise.monsters;

import Mindera.Swap.MonsterExercise.Strikeable;
import Mindera.Swap.MonsterExercise.Supernatural;

public abstract class Monster extends Supernatural implements Strikeable {
    protected int healthBar;
  //  protected int attackDmg;

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
       // System.out.println("Monster current health: " + this.healthBar + ", taking damage: " + damage);

        this.healthBar -= damage;
        if (this.healthBar < 0) {
            this.healthBar = 0;
        }
  //      System.out.println("Monster took damage: " + damage + ", updated health: " + this.healthBar); // Debugging statement
    }
    @Override
    public int getHealthBar() {
     //   System.out.println(healthBar);
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



