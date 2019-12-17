package cn.tedu.cloudnotes.Json;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.cloudnotes.entity.SelectJson;
import cn.tedu.cloudnotes.mapper.Json;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JsonTests {
	
	@Autowired
	private Json json;
	
	@Test
	public void JsonTest() {
		List<SelectJson> selectJson = json.selectJson();
		for (SelectJson s :selectJson) {
			System.err.println(s);
		}
	}
}
