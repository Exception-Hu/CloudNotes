package cn.tedu.cloudnotes.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.cloudnotes.entity.NotesMessage;
import cn.tedu.cloudnotes.entity.User;
import cn.tedu.cloudnotes.service.IAdminService;
import cn.tedu.cloudnotes.util.JsonReult;

/**
 * 管理员控制器层
 */
@RestController
@RequestMapping("admin")
public class AdminController extends BaseController{
	@Autowired
	private IAdminService service;
	
	@PostMapping("login")
	public JsonReult<User> adminLogin(String adminname,String password,HttpSession session){
		System.err.println(adminname+":"+password);
		User user = service.adminLogin(adminname, password);
		session.setAttribute("id", user.getId());
		return new JsonReult<User>(SUCCESS,user);
	}
	
	@GetMapping("browse-message")
	public JsonReult<List<NotesMessage>> seekNotesMessage(){
		List<NotesMessage> notesMessages = service.seekNotesMessages();
		return new JsonReult<List<NotesMessage>>(SUCCESS,notesMessages);
	}
	
	@RequestMapping("{id}/remove")
	public JsonReult<Void> removeByid(@PathVariable("id")Integer id){
		System.err.println(id);
		service.removeByid(id);
		return new JsonReult<Void>(SUCCESS);
	}
	
	@RequestMapping("out")
	public JsonReult<User> getOutId(HttpSession session){
		session.removeAttribute("id");
		return new JsonReult<User>(SUCCESS);
	}
}
