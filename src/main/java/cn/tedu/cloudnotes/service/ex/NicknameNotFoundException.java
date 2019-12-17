package cn.tedu.cloudnotes.service.ex;

/**
 * 用户昵称已存在异常
 */
public class NicknameNotFoundException extends ServiceException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2341687362046471358L;

	public NicknameNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NicknameNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public NicknameNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public NicknameNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public NicknameNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
