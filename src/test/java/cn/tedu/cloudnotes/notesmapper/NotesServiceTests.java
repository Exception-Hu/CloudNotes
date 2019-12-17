package cn.tedu.cloudnotes.notesmapper;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.cloudnotes.entity.Message;
import cn.tedu.cloudnotes.entity.NotesMessage;
import cn.tedu.cloudnotes.entity.User;
import cn.tedu.cloudnotes.service.INotesService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NotesServiceTests {
	@Autowired
	private INotesService service;
	
	@Test
	public void insert() {
		try {
			Message message = new Message();
			message.setUserId(3);
			message.setTitle("Java");
			message.setAuthor("Java");
			message.setCreateTime(new Date());
			service.insert(3, message);
		} catch (Exception e) {
			System.err.println(e.getClass());
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void browseNotes() {
		List<NotesMessage> list = service.browseNotes(2);
		System.err.println(list);
	}
	
	
	

}
