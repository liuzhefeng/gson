package com.zfliu.gson.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.zfliu.gson.model.PersonJson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zfliu on 2021/5/6 9:15
 * Desc:gson测试
 */
public class GsonTest
{
	public static void main(String[] args)
	{
		PersonJson personJson = new PersonJson("栗霖", 18, "篮球");
		Gson gson = new Gson();
		System.out.println(gson.toJson(personJson));
		System.out.println("-------------------");
		Gson gson1 = new GsonBuilder().create();
		System.out.println(gson1.toJson(personJson));
		System.out.println("-------------------");
		Map<String, PersonJson> map = new HashMap<>();
		map.put(personJson.getName(), personJson);
		System.out.println(gson.toJson(map));
		System.out.println("-------------------");
		List<PersonJson> list = new ArrayList<>();
		list.add(personJson);
		System.out.println(gson.toJson(list));
		System.out.println("-------------------");
		String str1 = gson.toJson(personJson);
		PersonJson personJson1 = gson.fromJson(str1, PersonJson.class);
		System.out.println(personJson1);
		System.out.println("-------------------");
		String listStr = gson.toJson(list);
		List<PersonJson> parselist = gson.fromJson(listStr, new TypeToken<ArrayList<PersonJson>>()
		{
		}.getType());
		List list1 = gson.fromJson(listStr, List.class);
		System.out.println(parselist);
		System.out.println(list1);
		System.out.println("-------------------");
		String mapStr = gson.toJson(map);
		Map parseMap = gson.fromJson(mapStr, Map.class);
		System.out.println(parseMap);
		Map<String, PersonJson> parseMap2 = gson.fromJson(mapStr, new TypeToken<HashMap<String, PersonJson>>()
		{
		}.getType());
		System.out.println(parseMap2);
	}
}
