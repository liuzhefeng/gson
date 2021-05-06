package com.zfliu.gson.mangodb.controller;

import com.zfliu.gson.mangodb.dao.MongoTestDao;
import com.zfliu.gson.mangodb.model.MongoTestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zfliu on 2021/5/6 11:10
 * Desc:
 */
@RestController
public class MongoTestC
{
	@Autowired
	private MongoTestDao mtdao;

	@GetMapping("/tt")
	public String hello()
	{
		return "hello!";
	}

	@GetMapping(value = "/test1")
	public void saveTest() throws Exception
	{
		MongoTestModel mgtest = new MongoTestModel();
		mgtest.setId(11);
		mgtest.setAge(33);
		mgtest.setName("ceshi");
		mtdao.saveTest(mgtest);
	}

	@GetMapping(value = "/test2")
	public MongoTestModel findTestByName()
	{
		MongoTestModel mgtest = mtdao.findTestByName("ceshi");
		System.out.println("mgtest is " + mgtest);
		return mgtest;
	}

	@GetMapping(value = "/test3")
	public void updateTest()
	{
		MongoTestModel mgtest = new MongoTestModel();
		mgtest.setId(11);
		mgtest.setAge(44);
		mgtest.setName("ceshi2");
		mtdao.updateTest(mgtest);
	}

	@GetMapping(value = "/test4")
	public void deleteTestById()
	{
		mtdao.deleteTestById(11);
	}

}
