package cn.tedu.cloudnotes.service.ex;

/**
 * 用户密码错误异常
 */
public class PasswordNotFoundException extends ServiceException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2341687362046471358L;

	public PasswordNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PasswordNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public PasswordNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public PasswordNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public PasswordNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
