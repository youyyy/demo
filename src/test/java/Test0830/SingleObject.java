package Test0830;/*
          .--,       .--,
         ( (  \.---./  ) )
          '.__/o   o\__.'
             {=  ^  =}
              >  -  <
             /       \
            //       \\
           //|   .   |\\
           "'\       /'"_.-~^`'-.
              \  _  /--'         `
            ___)( )(___
           (((__) (__)))
   高山仰止,景行行止.虽不能至,心向往之。
*/

/**
 * @program: demo
 * @description:
 * @author: youyi
 * @create: 2021/9/7
 **/
public class SingleObject {
    private String a;

    public enum Singletan {
        singleObjectFanctory;

        private SingleObject singleObject;

        private Singletan() {
            singleObject = new SingleObject();
            singleObject.a = "1212";
        }

        public SingleObject getSingleObject() {
            return singleObject;
        }
    }

    @Override
    public String toString() {
        return "SingleObject{" +
                "a='" + a + '\'' +
                '}';
    }

    public static SingleObject get() {
        return Singletan.singleObjectFanctory.getSingleObject();
    }

    public static void main(String[] args) {
        System.out.println(get().toString());
    }
}
