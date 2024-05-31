package Mindera.Swap.MonsterExercise.monsters;

public class MonsterCard {
    private int attackDamage;
    private int healtBar;
    private String monsterName;
    private Monster monster;
    private MonsterTypeEnum monsterType;
    private boolean fainted;

    public MonsterCard(String monsterName, MonsterTypeEnum monsterType) {
        this.monsterName = monsterName;
        this.monsterType = monsterType;

    }

    public MonsterCard(int healthBar, int attackDamage) {
        this.healtBar = healthBar;
        this.attackDamage = attackDamage;
    }

    public MonsterCard(String name, MonsterTypeEnum monsterType, Monster monster) {
        this.monsterName = name;
        this.monsterType = monsterType;
        this.monster = monster;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public MonsterTypeEnum getMonsterType() {
        return monsterType;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public boolean isFainted() {
        return monster == null || monster.getHealthBar() <= 0;
    }

    public void setFainted(boolean fainted) {
        this.fainted = isFainted();
    }

    @Override
    public String toString() {
        return monsterName + " ";
    }
}

