package demoTest.youyi;

/**
 * Created by yi.you on 2018/8/3.
 */
public class BuilderTest {
    private int  level;
    private String reason;

    @Override
    public String toString() {
        return "BuilderTest{" +
                "level=" + level +
                ", reason='" + reason + '\'' +
                '}';
    }

    public static Builder newBuilder(){
        return new Builder();
    }
    public BuilderTest(int level, String reason) {
        this.level = level;
        this.reason = reason;
    }
    //构造函数
    private BuilderTest(Builder builder) {
        setLevel(builder.level);
        setReason(builder.reason);
    }
    public String getReason() {
        return reason;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public static final class Builder {
        private int level;
        private String reason;

        private Builder() {
        }

        public Builder withLevel(int level) {
            this.level = level;
            return this;
        }

        public Builder withReason(String reason) {
            this.reason = reason;
            return this;
        }

        public BuilderTest build() {
            return new BuilderTest(this);
        }
    }
}

class btest{//builder模式
    public static void main(String[] args){
        BuilderTest builderTest = BuilderTest.newBuilder().withLevel(1).withReason("k").build();
        System.out.print(builderTest);
    }
}
