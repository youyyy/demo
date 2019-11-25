package demoTest;

public class StaticFanctory {
    private final int min;
    private final int max;
    private StaticFanctory(int min,int max){
        this.min = min;
        this.max = max;
    }
    public static StaticFanctory berween(int min,int max){
        return new StaticFanctory(min,max);
    }
    public static StaticFanctory biggerThan(int min) {
        return new StaticFanctory(min, Integer.MAX_VALUE);
    }

    public static StaticFanctory smallerThan(int max) {
        return new StaticFanctory(Integer.MIN_VALUE, max);
    }
}
