package com.elasticsearch;

import com.elasticsearch.entity.Book;
import io.searchbox.client.JestClient;
import io.searchbox.core.DocumentResult;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.xml.bind.SchemaOutputResolver;
import java.io.IOException;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SprimngBootElasticsearchApplicationTests {

    @Autowired
    JestClient jestclient;  //es操作的客户端

 //根据jest客户端修改插入数据
   @Autowired
   BookRepository bookrepository;
    @Test
    public void contextLoads() {
        Book book = new Book();
        book.setName("xaiohu");
        book.setId(1);
        //构建索引:
        Index index = new Index.Builder(book).index("database").type("table").build();

        try {
            DocumentResult execute = jestclient.execute(index);
            System.out.println(execute);
        } catch (IOException e) {


        }
    }

    @Test  //测试搜索
    public void contextLoads1() {
        //查询表达式
        //根据json条件搜索        通过模糊查询到json对象--
        String json = "{\n" +
                "  \"query\": {\n" +
                "    \"wildcard\": {\n" +
                "      \"name\": \"*hu\"\n" +
                "       \n" +
                "    }}}";


        //使用搜索类构建 通过index,type搜索; Index type 类型   构建搜索功能;
        Search builder = new Search.Builder(json).addIndex("database").addType("table").build();//构建-
        try {
            SearchResult execute = jestclient.execute(builder);
            String jsonString = execute.getJsonString();//获得json字符串
            System.out.println(jsonString);

        } catch (IOException e) {


        }
    }
}
