package com.example.demo.controller;
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

import com.example.demo.es.Article;
import com.example.demo.es.ArticleSearchRepository;
import com.example.demo.es.Author;
import com.example.demo.es.Tutorial;
import com.example.demo.result.Results;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;

/**
 * @program: demo
 * @description: description
 * @author: youyi
 * @create: 2020-05-11 14:01
 **/
@RestController()
@RequestMapping("/myes")
public class ESController {

    @Autowired
    private ArticleSearchRepository articleSearchRepository;

    @GetMapping("/add")
    public void testSaveArticleIndex() {
        Author author = new Author();
        author.setId(1L);
        author.setName("tianshouzhi");
        author.setRemark("java developer");

        Tutorial tutorial = new Tutorial();
        tutorial.setId(1L);
        tutorial.setName("elastic search");

        Article article = new Article();
        article.setId(1L);
        article.setTitle("游移 integreate elasticsearch");
        article.setAbstracts("游移 integreate elasticsearch is very easy");
        article.setTutorial(tutorial);
        article.setAuthor(author);
        article.setContent("elasticsearch based 游移 lucene,"
                + "spring-data-elastichsearch based on elaticsearch"
                + ",this tutorial 游移 you how to integrete 游移 with spring-data-elasticsearch");
        article.setPostTime(System.currentTimeMillis()/1000);
        article.setClickCount(1L);

        articleSearchRepository.save(article);
    }
    @GetMapping("/query")
    public Results testSearch() {
        String queryString = "游移";//搜索关键字
        QueryStringQueryBuilder builder = new QueryStringQueryBuilder(queryString);
        Iterable<Article> searchResult = articleSearchRepository.search(builder);
        Iterator<Article> iterator = searchResult.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        return Results.ok(searchResult);
    }



}
