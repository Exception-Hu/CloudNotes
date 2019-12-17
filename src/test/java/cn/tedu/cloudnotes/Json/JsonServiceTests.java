package cn.tedu.cloudnotes.Json;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.cloudnotes.entity.NotesMessage;
import cn.tedu.cloudnotes.entity.SelectJson;
import cn.tedu.cloudnotes.entity.User;
import cn.tedu.cloudnotes.mapper.AdminMapper;
import cn.tedu.cloudnotes.mapper.NotesMapper;
import cn.tedu.cloudnotes.mapper.UserMapper;
import cn.tedu.cloudnotes.service.IAdminService;
import cn.tedu.cloudnotes.service.IJson;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JsonServiceTests {
	
	@Autowired
	private IJson json;
	
	@Test
	public void selectJson() {
		List<SelectJson> selectJson = json.selectJson();
		for (SelectJson selectJson2 : selectJson) {
			System.err.println(selectJson2);
		}
	}
}
