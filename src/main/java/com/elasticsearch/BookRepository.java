package com.elasticsearch;

import com.elasticsearch.entity.Book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import java.util.List;
import java.util.Optional;


/**
 * @author XAIOHU
 * @date 2019/9/25 --15:17
 * ElasticsearchCrudRepository 是一个泛型需要<javaentity,id></>
 **/
public interface BookRepository extends ElasticsearchCrudRepository<Book, Integer> {
    //模糊查询  --需要规则和document说明一致;
    //List<Book> findByNameLike(String x);  根据书名模糊查询
    public List<Book> findByNameLike(String bookName);
    //发送 {    }
    //也可以添加注解@query 定义json查询内容 field
     @Query("{\"bool\":{\"must\":{\"field\":{\"name\":\"?\"}}}")//根据定义json模糊查询 ?0
    Page<Book> findByName(String name,Pageable pageable);


}
