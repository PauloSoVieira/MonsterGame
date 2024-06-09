package Mindera.Swap.MonsterExercise;

public class Fairy extends Supernatural {

    // 2 constructs

    public Fairy(int attackPower) {
        super(attackPower);
    }

    public Fairy(int attackPower, String name) {
        super(attackPower, name);
    }

    @Override
    public String toString() {
        if (this.getName() != null) {
            return this.getName();
        }
        return "Fairy";
    }




    }
