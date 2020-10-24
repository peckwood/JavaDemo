package com.example.demo.json.fastjson_convert_NOT_RECOMMENDED;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class JsonStringToObject {
	public static void main(String[] args) {
		String domainObjectString = "{\"name\":\"hello\"}";
		String domainObjectString1 = "{\'name\':\'hello\'}";
		DomainObject a = JSON.parseObject(domainObjectString, DomainObject.class);
		DomainObject b = JSONObject.parseObject(domainObjectString, DomainObject.class);
		DomainObject a1 = JSON.parseObject(domainObjectString1, DomainObject.class);
		DomainObject b1 = JSONObject.parseObject(domainObjectString1, DomainObject.class);
		System.out.println(a);
		System.out.println(b);
		System.out.println(a1);
		System.out.println(b1);
	}
	
}
