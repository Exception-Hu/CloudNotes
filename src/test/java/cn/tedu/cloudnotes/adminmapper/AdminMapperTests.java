package cn.tedu.cloudnotes.adminmapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.cloudnotes.entity.NotesMessage;
import cn.tedu.cloudnotes.entity.User;
import cn.tedu.cloudnotes.mapper.AdminMapper;
import cn.tedu.cloudnotes.mapper.NotesMapper;
import cn.tedu.cloudnotes.mapper.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminMapperTests {
	
	@Autowired
	private AdminMapper mapper;
	
	@Test
	public void findByUsername() {
		User user = mapper.findByUsername("admin");
		System.err.println(user);
	}
	
	@Test
	public void findByAll() {
		List<NotesMessage> notesMappers = mapper.findByAll();
		for (NotesMessage notesMapper : notesMappers) {
			System.err.println(notesMapper);
		}
	}
	
	@Test
	public void deleteGetId() {
		Integer rowInteger = mapper.deleteGetId(6);
		System.err.println(rowInteger);
	}
	
	
}
