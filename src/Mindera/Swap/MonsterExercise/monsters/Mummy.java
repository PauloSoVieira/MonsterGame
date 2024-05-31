package Mindera.Swap.MonsterExercise.monsters;

public class Mummy extends Monster {
    private int numberOfAttacks;

    public Mummy(int healthBar, int attackDmg) {
        super(healthBar, attackDmg);
        this.numberOfAttacks = 0;
    }


    //TODO change 5 to %

    public void mummyAttack(Monster monster) {

        if (monster.getHealthBar() <= 0) {
            System.out.println("Monster is fainted you cant attack");
            return;
        }
        if (numberOfAttacks < 2) {
            attackBattle(monster);

            System.out.println("mummy attacked once and did " + getAttackDmg() + " damage to enemy");
            numberOfAttacks++;
        } else {
            System.out.println("Mummy failed the attack! And lost 5 of Hp");
            setHealthBar(getHealthBar() - getAttackDmg());
            numberOfAttacks = 0;
        }
    }

    @Override
    public int attackBattle(Monster monster) {
        int newHealth = super.attackBattle(monster);
        //  System.out.println("Number of mummy attacks: " + ++numberOfAttacks);
        return newHealth;
    }
}
