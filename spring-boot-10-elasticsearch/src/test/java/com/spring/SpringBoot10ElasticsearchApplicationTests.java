package com.spring;

import com.spring.bean.Article;
import com.spring.bean.Book;
import com.spring.repository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class SpringBoot10ElasticsearchApplicationTests {

    @Autowired
    JestClient jestClient;

    @Autowired
    BookRepository bookRepository;

    @Test
    public void test03() {
        Book book = new Book();
        bookRepository.index(book);

    }

    @Test
    void contextLoads() {
//		给ES中索引（保存文档）
        Article article = new Article();
        article.setId(1);
        article.setAuthor("zhangsan");
        article.setContent("hfjkasdfgjsdakghfsdjakfg");
        article.setTitle("浮生日记");
//		构建索引功能
        Index build = new Index.Builder(article).index("文章").type("news").build();
        try {
            jestClient.execute(build);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    //	测试全文搜索
    @Test
    public void test02() {
        String json = "";
//		构建搜索功能
        Search build = new Search.Builder(json).addIndex("文章").addType("news").build();

        try {
            SearchResult execute = jestClient.execute(build);
            System.out.println(execute.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
