package DTO;

import java.util.ArrayList;
import java.util.List;

public class DTOTest {

    public static void main(String[] args){
        List<Long> list = new ArrayList<Long>();
//        List<Long> indexTypeIdList = list.stream().map(t -> t.getIndexTypeId()).collect(Collectors.toList());
        new DTOTest().sou();
    }
    public void sou(){
        ResultObjectResDTO<List<String>> roVo = new ResultObjectResDTO<>();
        List<String> list1 = new ArrayList<>();
        list1.add("youyi");
        list1.add("lix");
        roVo.setData(list1);
        for (String s: roVo.getData()) {
            System.out.println(s);
        }
    }

}
