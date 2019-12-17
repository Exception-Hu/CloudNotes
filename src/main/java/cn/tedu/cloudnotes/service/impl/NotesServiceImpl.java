package cn.tedu.cloudnotes.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.cloudnotes.entity.Message;
import cn.tedu.cloudnotes.entity.NotesMessage;
import cn.tedu.cloudnotes.mapper.NotesMapper;
import cn.tedu.cloudnotes.service.INotesService;
import cn.tedu.cloudnotes.service.ex.DeleteException;
import cn.tedu.cloudnotes.service.ex.InsertException;
import cn.tedu.cloudnotes.service.ex.NotesNotFoundException;
/**
 * 用户笔记业务层实现类
 * @author Administrator
 *
 */
@Service
public class NotesServiceImpl implements  INotesService{

	@Autowired
	private NotesMapper mapper;
	
	/**
	 * 用户添加笔记
	 */
	@Override
	public void insert(Integer userId, Message message) throws InsertException {

		//把userId存入Message中
		message.setUserId(userId);
		//把创建时间存入Message中
		message.setCreateTime(new Date());
		//调用insertNotes
		System.err.println(message);
		Integer row = mapper.insertNotes(message);
		//查看返回值是否为1，不为1 InsertException
		if(!row.equals(1)) {
			throw new InsertException("添加笔记错误！请联系管理员");
		}
	}
	
	/**
	 * 根据用户id获取用户笔记
	 */
	@Override
	public List<NotesMessage> browseNotes(Integer id) throws NotesNotFoundException {
		//根据id查询用户笔记
		List<NotesMessage> notesMessages = mapper.browseNotes(id);
		//如果返回值为null，NotesNotFoundException
		if(notesMessages==null) {
			throw new NotesNotFoundException("没有用户笔记");
		}
		return notesMessages;
	}

	

	

}
