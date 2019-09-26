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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page; //由elas包提供
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SprimngBootElasticsearchApplicationTests1 {

    @Autowired
    JestClient jestclient;  //es操作的客户端

    @Autowired
    BookRepository bookrepository;
//@Document(indexName = "huxueman",type = "book")
    @Test  //插入的是index/type    huxue/book
    public void contextLoads() {
        Book book = new Book();
        book.setName("xaiohu");
        book.setId(1);
        Book save = bookrepository.save(book);
        System.out.println(save);


    }

    @Test  //测试搜索
    public void contextLoads1() {
        //查询搜索
        Book one = bookrepository.findOne(1);
        System.out.println("查找到===== "+one);
        bookrepository.findAll();//查询所有:
        List<Book> x = bookrepository.findByNameLike("x");//模糊查询
        for (Book book : x) {
            System.out.println("查找到+++ "+book);
        }
        Page<Book> users = bookrepository.findAll(new PageRequest(0,5));
        users.forEach(System.out::println);
        int totalPages = users.getTotalPages(); //总页数
        System.out.println("数量是"+totalPages);
        System.out.println(users);

    }
}
