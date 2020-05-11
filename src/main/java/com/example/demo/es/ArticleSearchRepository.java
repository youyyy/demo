package com.example.demo.es;
/*
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

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2020-05-11 12:08
 **/
public interface ArticleSearchRepository extends ElasticsearchRepository<Article, Long> {

}
