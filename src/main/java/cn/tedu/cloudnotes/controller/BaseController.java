package cn.tedu.cloudnotes.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.cloudnotes.service.ex.InsertException;
import cn.tedu.cloudnotes.service.ex.NicknameNotFoundException;
import cn.tedu.cloudnotes.service.ex.NotesNotFoundException;
import cn.tedu.cloudnotes.service.ex.PasswordNotFoundException;
import cn.tedu.cloudnotes.service.ex.RoleTypeMismatchException;
import cn.tedu.cloudnotes.service.ex.ServiceException;
import cn.tedu.cloudnotes.service.ex.UpdateException;
import cn.tedu.cloudnotes.service.ex.UsernameNotFoundException;
import cn.tedu.cloudnotes.util.JsonReult;

/**
 * 所有控制器的父类
 */
public class BaseController {
	
	protected final Integer SUCCESS = 0;
	
	@ExceptionHandler(ServiceException.class)
	@ResponseBody
	public JsonReult<Void> ExceptionHandler(Throwable e){
		JsonReult<Void> json = new JsonReult<>();
		if(e instanceof UsernameNotFoundException) {
			json.setState(10);
		}else if(e instanceof PasswordNotFoundException) {
			json.setState(11);
		}else if(e instanceof NicknameNotFoundException) {
			json.setState(12);
		}else if(e instanceof InsertException) {
			json.setState(13);
		}else if(e instanceof UpdateException) {
			json.setState(14);
		}else if(e instanceof RoleTypeMismatchException) {
			json.setState(15);
		}else if(e instanceof NotesNotFoundException) {
			json.setState(16);
		}
		json.setMessage(e.getMessage());
		return json;
	}
	
	protected String SessionUsername(HttpSession session) {
		return session.getAttribute("username").toString();
	}
	
	protected Integer SessionId(HttpSession session) {
		return Integer.valueOf(session.getAttribute("id").toString());
	}
}
