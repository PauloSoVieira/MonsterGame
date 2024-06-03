package Mindera.Swap.MonsterExercise;

import Mindera.Swap.MonsterExercise.monsters.Mummy;
import Mindera.Swap.MonsterExercise.monsters.Vampire;
import Mindera.Swap.MonsterExercise.monsters.Werewolf;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.


        Game game = new Game();

        game.startGame();

Witch witch = new Witch(100,10);


     Vampire vampire = new Vampire(100, 60);
        Werewolf werewolf = new Werewolf(100, 5);
        Mummy mummy = new Mummy(100,10);

//vampire.attack(werewolf);vampire.attack(werewolf);vampire.attack(werewolf);
int a =werewolf.getHealthBar();
        //System.out.println(a);
    /*  vampire.attack(witch);
        witch.getHealthBar();
        Fairy fairy = new Fairy(10,"fairy");

        vampire.attack(fairy);

        mummy.attack(werewolf);mummy.attack(werewolf);mummy.attack(werewolf);
        System.out.println("werewolf left with : ");
        werewolf.getHealthBar();*/
     //   System.out.println("Werewolf initial health: " + werewolf.getHealthBar());
     //   vampire.attack(werewolf);
    //    System.out.println("Werewolf health after attack: " + werewolf.getHealthBar());

        //  vampire.vampireAttack(werewolf);
        //  werewolf.getHealthBar();
       /* Werewolf werewolf = new Werewolf(100, 10);
        Mummy mummy = new Mummy(100, 10);

        werewolf.werewolfAttack(mummy);

        mummy.getHealthBar(); */
 /*       Mummy mummy = new Mummy(100, 5);
        Werewolf werewolf = new Werewolf(100, 10);


        mummy.mummyAttack(werewolf);
        mummy.mummyAttack(werewolf);
        mummy.mummyAttack(werewolf); */


        //  Player p1 = new Player("joao", 2);
        //  p1.createPlayerHand();
        // p1.showPlayerHand();


        // werewolf.attackBattle(vampire);
        //  vampire.getHealthBar();

        // werewolf.getHealthBar();
    }
}