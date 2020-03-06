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
	public void test(){
	}
	public void test2(){
	}
	public void test3(){
	}
	
	public void test4() {
		
	}
	public void test5(){
	}
	public void test8(){
	}
public void test7(){
}

public void test11(){}

}
