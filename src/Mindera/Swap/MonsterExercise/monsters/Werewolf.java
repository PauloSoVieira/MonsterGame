package Mindera.Swap.MonsterExercise.monsters;

public class Werewolf extends Monster {

    public Werewolf(int healthBar, int attackDmg) {
        super(healthBar, attackDmg);
    }


    public void werewolfAttack(Monster monster) {
        attackBattle(monster);
        System.out.println("Werewolf attacked once and did " + getAttackDmg() + " damage to enemy" + "\n");
    }

    @Override
    public int attackBattle(Monster monster) {
        return super.attackBattle(monster);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
