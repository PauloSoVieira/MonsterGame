package Mindera.Swap.MonsterExercise;

public interface Strikeable  {

     int getHealthBar();
     void setHealthBar(int healthBar);
     void takeDamage(int damage);
     boolean isFainted();
     String getName();
}
