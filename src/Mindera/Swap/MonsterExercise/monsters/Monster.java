package Mindera.Swap.MonsterExercise.monsters;

public abstract class Monster {
    private int healthBar;
    private int attackDmg;

    public Monster(int healthBar, int attackDmg) {
        this.healthBar = healthBar;
        this.attackDmg = attackDmg;
    }

    public int attackBattle(Monster monster) {

        int currentHp = monster.getHealthBar();
        int newHealthbar = currentHp - attackDmg;

        if (currentHp <= 0) {
            //System.out.println(monster + " is fainted you cant attack");
            return newHealthbar;
        }
        //  System.out.println("This attack did " + this.attackDmg + " damage to " + monster.getClass().getSimpleName());
        monster.setHealthBar(newHealthbar);
        return newHealthbar;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "healthBar=" + healthBar +
                ", attackDmg=" + attackDmg +
                '}';
    }

    public int getHealthBar() {
        if (healthBar <= 0) {
            //  System.out.println("Monster has fainted");
            return healthBar;
        }
        //System.out.println(healthBar);
        return healthBar;
    }

    public void setHealthBar(int healthBar) {
        this.healthBar = healthBar;
    }

    public int getAttackDmg() {
        return attackDmg;
    }


}
