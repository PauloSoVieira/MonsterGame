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
       // System.out.println(healthBar);
        return healthBar;
    }

    public void setHealthBar(int health) {
        this.healthBar = health;
    }

   /* public void attack(Strikeable p1Monster, Strikeable p2Monster) {

        System.out.println(this.getName() + " starts to attack both players!");
        super.attack(p1Monster);
        super.attack(p2Monster);

    }*/
    @Override
    public String toString() {
        if (this.getName() != null) {
            return this.getName();
        }
        return "Witch";
    }

    @Override
    public void takeDamage(int decreaseAmount) {

      //  System.out.println(this.getName() + " was hit with " + decreaseAmount + " of damage");
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