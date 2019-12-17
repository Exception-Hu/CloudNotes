package cn.tedu.cloudnotes.notesmapper;


import static org.junit.Assume.assumeTrue;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.cloudnotes.entity.Message;
import cn.tedu.cloudnotes.entity.NotesMessage;
import cn.tedu.cloudnotes.mapper.NotesMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NotesMapperTests {
	
	@Autowired
	private NotesMapper mapper;
	
	@Test
	public void insertNotes() {
		Message message = new Message();
		message.setUserId(2);
		message.setAuthor("张三");
		message.setCreateTime(new Date());
		message.setContent("zzzcmadcm从哪加的你出差");
		message.setTitle("学习笔记");
		Integer row = mapper.insertNotes(message);
		System.err.println(row);
	}
	
	@Test
	public void browse() {
		List<NotesMessage> message = mapper.browseNotes(5);
		for(NotesMessage m:message) {
			System.err.println(m);
		}
	}

	
}
