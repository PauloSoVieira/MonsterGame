package Mindera.Swap.MonsterExercise.monsters;

import Mindera.Swap.MonsterExercise.Strikeable;

import static Mindera.Swap.MonsterExercise.monsters.MonstersEnum.WEREWOLF;

public class Werewolf extends Monster {

    // 2 constructs


    public Werewolf(int healthBar, int attackDmg , String name) {
        super(healthBar, attackDmg, name);
    }
    public Werewolf(int healthBar, int attackDmg ) {
        super(healthBar, attackDmg);

    }

    @Override
    public void attack(Strikeable monster) {
        super.attack(monster);
        System.out.println("Werewolf did " + getPower() + " of damage");
    }

   /*
    public void werewolfAttack(Monster monster) {
        attack(monster);
        System.out.println("Werewolf attacked once and did " + WEREWOLF.getAttackDamage() + " damage to enemy" + "\n");
    }

*/

}
