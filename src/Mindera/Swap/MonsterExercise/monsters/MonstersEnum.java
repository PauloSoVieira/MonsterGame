package Mindera.Swap.MonsterExercise.monsters;

public enum MonstersEnum {
    WEREWOLF(15, 100, MonsterTypeEnum.WEREWOLF),
    VAMPIRE(10, 100, MonsterTypeEnum.VAMPIRE),
    MUMMY(5, 100, MonsterTypeEnum.MUMMY);

    private final int attackDamage;
    private final int HealthBar;
    private final MonsterTypeEnum monsterTypeEnum;
    private String name ;

    public String getName() {
        return name;
    }

    MonstersEnum(int attackDamage, int healthBar, MonsterTypeEnum monsterTypeEnum) {
        this.attackDamage = attackDamage;
        HealthBar = healthBar;
        this.monsterTypeEnum = monsterTypeEnum;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public int getHealthBar() {
        return HealthBar;
    }

    public MonsterTypeEnum getMonsterTypeEnum() {
        return monsterTypeEnum;
    }

    public MonsterTypeEnum getMonsterType() {
        return monsterTypeEnum;
    }

    @Override
    public String toString() {
        return "+monsterTypeEnum=" + monsterTypeEnum;

    }


}
