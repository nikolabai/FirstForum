package cn.gavin.exceptiom;

public class UserExistsException extends Exception{
	public UserExistsException() {
		super();
		}

	public UserExistsException(String message) {
		super(message);
	}

	

}
