package cn.tedu.cloudnotes.service.ex;

/**
 * 用户名已存在异常
 */
public class NotesNotFoundException extends ServiceException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2341687362046471358L;

	public NotesNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NotesNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public NotesNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public NotesNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public NotesNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
