package com.zfliu.gson.mangodb.dao;

import com.zfliu.gson.mangodb.model.MongoTestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by zfliu on 2021/5/6 11:11
 * Desc:
 */
@Component
public class MongoTestDao
{
	@Autowired
	private MongoTemplate mongoTemplate;

	/**
	 * 创建对象
	 */
	public void saveTest(MongoTestModel test)
	{
		mongoTemplate.save(test);
	}

	/**
	 * 根据用户名查询对象
	 * @return
	 */
	public MongoTestModel findTestByName(String name)
	{
		Query query = new Query(Criteria.where("name").is(name));
		MongoTestModel mgt = mongoTemplate.findOne(query, MongoTestModel.class);
		return mgt;
	}

	/**
	 * 更新对象
	 */
	public void updateTest(MongoTestModel test)
	{
		Query query = new Query(Criteria.where("id").is(test.getId()));
		Update update = new Update().set("age", test.getAge()).set("name", test.getName());
		//更新查询返回结果集的第一条
		mongoTemplate.updateFirst(query, update, MongoTestModel.class);
		//更新查询返回结果集的所有
		// mongoTemplate.updateMulti(query,update,TestEntity.class);
	}

	/**
	 * 删除对象
	 * @param id
	 */
	public void deleteTestById(Integer id)
	{
		Query query = new Query(Criteria.where("id").is(id));
		mongoTemplate.remove(query, MongoTestModel.class);
	}
}
