package cn.tedu.cloudnotes.adminmapper.copy;

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
import cn.tedu.cloudnotes.service.IAdminService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminServiceTests {
	
	@Autowired
	private IAdminService service;
	
	@Test
	public void login() {
		try {
			User user = service.adminLogin("admin", "123456");
			System.err.println(user);
		} catch (Exception e) {
			System.err.println(e.getClass());
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void seel() {
		try {
			List<NotesMessage> notesMessages = service.seekNotesMessages();
			for (NotesMessage notesMessage : notesMessages) {
				System.err.println(notesMessage);
			}
			
		} catch (Exception e) {
			System.err.println(e.getClass());
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void remove() {
		try {
			service.removeByid(8);
		} catch (Exception e) {
			System.err.println(e.getClass());
			System.err.println(e.getMessage());
		}
	}
}
