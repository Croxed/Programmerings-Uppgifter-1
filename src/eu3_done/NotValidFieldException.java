package eu3_done;

public class NotValidFieldException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1548046469107677914L;

	public NotValidFieldException() {}

	public NotValidFieldException(String message)
	{
		super(message);
	}
}