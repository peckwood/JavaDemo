package com.example.demo.json.fastjson_convert_NOT_RECOMMENDED;

public class DomainObject {
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String name;

	@Override
	public String toString() {
		return "DomainObject [name=" + name + "]";
	}
}
