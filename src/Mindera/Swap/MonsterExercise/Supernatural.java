package Mindera.Swap.MonsterExercise;

public abstract class Supernatural {
    private String name;
    private  int power;

    public Supernatural(int power, String name) {
        this.power = power;
        this.name=name;
    }

    public Supernatural(int power) {
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public void attack(Strikeable monster) {
       // System.out.println(monster + " did " + getPower());

        monster.takeDamage(getPower());

    }
}


