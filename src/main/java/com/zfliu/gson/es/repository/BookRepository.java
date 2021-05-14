package com.zfliu.gson.es.repository;

import com.zfliu.gson.es.model.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zfliu on 2021/5/14 11:08
 * Desc:
 */
public interface BookRepository extends ElasticsearchRepository<Book, String>
{
	Book findByName(String name);

	List<Book> findByAuthor(String author);

	Book findBookById(String id);
}
