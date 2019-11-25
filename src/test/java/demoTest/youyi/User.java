package demoTest.youyi;

public class User {
    private String userId;
    private String userName;
    private String passWord;
    private String tellphone;
    private String level;
    /*public static Builder newBuilder(){
        return new Builder();
    }*/
    public static final class Builder {
        private String userId;
        private String userName;
        private String passWord;
        private String tellphone;
        private String level;

        public Builder() {
        }
        public static Builder anUser(){
            return new Builder();
        }

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }
        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }
        public Builder passWord(String passWord) {
            this.passWord = passWord;
            return this;
        }
        public Builder tellphone(String tellphone) {
            this.tellphone = tellphone;
            return this;
        }
        public Builder level(String level) {
            this.level = level;
            return this;
        }
        public User build(){
            User user = new User();
            user.userId = this.userId;
            user.userName = this.userName;
            user.passWord = this.passWord;
            user.tellphone = this.tellphone;
            user.level = this.level;
            return user;
        }
    }
    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", tellphone='" + tellphone + '\'' +
                ", level='" + level + '\'' +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getTellphone() {
        return tellphone;
    }

    public String getLevel() {
        return level;
    }
}
