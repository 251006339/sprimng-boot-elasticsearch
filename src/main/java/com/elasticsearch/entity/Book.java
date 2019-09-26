package com.elasticsearch.entity;

import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author XAIOHU
 * @date 2019/9/25 --15:20
 * 需要加个document标签 elasticsearch提供的
 * indexName索引的名字  和type类型
 * 1.索引,表名,id 内容
 * put  /indexName/type/id
 *     {json:数据}  增加数据
 * get/indexName/type/_search 查询所有数据
 * http://172.20.10.7:9200/huxueman/book/_search 查询所有数据
 * 2模糊查询
 *
 *  *  *
 *     POST /_search 查询所有id为1的
 *     "query": {
 *         "match": {              匹配
 *             "id": "1"
 *         }
 *     }
 *    模糊查询  wildcard 使用通配符进行模糊查询
 *{
 *   "query": {
 *     "wildcard": {
 *       "name": "*hu"
 *       }
 *   }
 * }
 *
 *fuzzy
 *
 **/
@Document(indexName = "huxueman",type = "book")
public class Book {
    private String name;
    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
