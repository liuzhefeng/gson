package com.zfliu.gson.es.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * Created by zfliu on 2021/5/13 20:18
 * Desc:
 */
@Document(indexName = "book_info")
//@Document(indexName = "book_info", shards = 3, replicas = 1)
@Data
public class Book
{
	@Id
	private String id;

	@Field(type = FieldType.Text, analyzer = "standard")
	private String name;

	@Field(type = FieldType.Text, analyzer = "standard")
	private String author;

	@Field(type = FieldType.Date, format = DateFormat.basic_date)
	private Date createTime;

	@Field(type = FieldType.Date, format = DateFormat.basic_date)
	private Date updateTime;

	@Field(type = FieldType.Double)
	private Double price;
}

