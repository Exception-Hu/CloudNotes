package cn.tedu.cloudnotes.util;

public class JsonReult<T> {
	private Integer state;
	private String message;
	private T data;
	
	public JsonReult() {
		super();
	}
	
	public JsonReult(Integer state) {
		super();
		this.state = state;
	}
	
	public JsonReult(Integer state, T data) {
		super();
		this.state = state;
		this.data = data;
	}

	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
}
