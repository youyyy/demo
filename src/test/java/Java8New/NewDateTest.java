package Java8New;

import org.apache.tomcat.jni.Time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @Description
 * @Author youyi
 * @Date 2019/7/3020:26
 **/
public class NewDateTest {
    public static void main(String[] args){
        LocalDateTime time = LocalDateTime.now();
        System.out.println(time);
        LocalDate date = time.toLocalDate();
        System.out.println(date);

        LocalTime date4 = LocalTime.of(22, 15);
        System.out.println("date4: " + date4);
    }
}
