package demoTest;

import org.apache.commons.lang3.StringUtils;

/**
 * 枚举
 * Created by yi.you on 2018/8/9.
 */
public enum AntiLevel {

    UNANTI(-1, "UNANTI"),

    NORMAL(0, "NORMAL"),

    WARNING(1, "WARNING"),

    CRITICAL(2, "CRITICAL"),

    ATTACK(3, "ATTACK");

    private int level;

    private String desc;

    AntiLevel(int level, String desc) {
        this.level = level;
        this.desc = desc;
    }

    public int getLevel() {
        return level;
    }

    public String getDesc() {
        return desc;
    }

    public static final AntiLevel MAX = maxLevel();

    public static AntiLevel parseById(int level) {
        for (AntiLevel antiLevelEnum : AntiLevel.values()) {
            if (level == antiLevelEnum.getLevel()) {
                return antiLevelEnum;
            }
        }
        return AntiLevel.UNANTI;
    }

    public static AntiLevel parseByDesc(String desc) {
        for (AntiLevel antiLevelEnum : AntiLevel.values()) {
            if (StringUtils.equals(antiLevelEnum.desc, desc)) {
                return antiLevelEnum;
            }
        }
        return AntiLevel.UNANTI;
    }

    private static AntiLevel maxLevel() {
        AntiLevel max = AntiLevel.NORMAL;
        for (AntiLevel antiLevel : values()) {
            if (max.level < antiLevel.level) {
                max = antiLevel;
            }
        }
        return max;
    }

    @Override
    public String toString() {
        return "AntiLevel{" +
                "level=" + level +
                ", desc='" + desc + '\'' +
                '}';
    }
}
