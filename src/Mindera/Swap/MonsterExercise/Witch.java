package Mindera.Swap.MonsterExercise;

public class Witch extends Supernatural implements Strikeable {

    private int healthBar;

    public Witch(int health, int attackPower) {
        super(attackPower);
        this.healthBar = health;
    }

    public Witch(int health, int attackPower, String name) {
        super(attackPower, name);
        this.healthBar = health;
    }


    public int getHealthBar() {
        return healthBar;
    }

    public void setHealthBar(int health) {
        this.healthBar = health;
    }


    @Override
    public String toString() {
        if (this.getName() != null) {
            return this.getName();
        }
        return "Witch";
    }

    @Override
    public void takeDamage(int decreaseAmount) {

        this.setHealthBar(this.getHealthBar() - (decreaseAmount / 2));
        if (this.getHealthBar() <= 0) {
            System.out.println("Can she die?");
            this.setHealthBar(0);
        }
    }

    public boolean isFainted() {
        return this.getHealthBar() <= 0;
    }
}