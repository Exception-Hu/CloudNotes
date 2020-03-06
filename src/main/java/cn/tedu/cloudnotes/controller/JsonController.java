package cn.tedu.cloudnotes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.cloudnotes.entity.SelectJson;
import cn.tedu.cloudnotes.service.IJson;

@RestController
@RequestMapping("json")
public class JsonController {
	@Autowired
	private IJson json;
	
	@RequestMapping("select")
	public List<SelectJson> selectJson(){
		return json.selectJson();
	}
public void test1(){}
public void test2() {}

}
