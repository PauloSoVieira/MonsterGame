package Mindera.Swap.MonsterExercise;

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


        Vampire vampire = new Vampire(100, 5);
        Werewolf werewolf = new Werewolf(100, 5);


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