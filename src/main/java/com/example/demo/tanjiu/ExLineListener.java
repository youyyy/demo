package com.example.demo.tanjiu;/*
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

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @author youyi
 * @program demo
 * @description
 * @date 2022-11-07 15:15
 **/
public class ExLineListener extends AnalysisEventListener<ExLine> {
    public List<ExLine> list = new ArrayList<>();
    @Override
    public void invoke(ExLine exLine, AnalysisContext analysisContext) {
        list.add(exLine);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println("解析完成");
    }
}
