package Java8New.OptionalTest;

import java.util.Optional;

/**
 * @Description
 * @Author youyi
 * @Date 2019/7/3020:04
 **/
public class OptionTodo {
    public static void main(String[] args){
        System.out.println("Option.of()不能传null");
        System.out.println(getUser(1).isPresent());
        System.out.println(getUser(2).isPresent());
    }

    public static Optional<User> getUser(int a){
        User user = new User();
        user.setId(1);
        user.setName("youyi");
        if (a==1){
            return Optional.of(user);
        }
        return Optional.ofNullable(null);
    }
}
