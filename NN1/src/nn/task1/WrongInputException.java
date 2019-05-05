package nn.task1;

public class WrongInputException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String retCd ;  
	private String msgDes;  
	
	public WrongInputException() {
		super();
	}
 
	public WrongInputException(String message) {
		super(message);
		msgDes = message;
	}
 
	public WrongInputException(String retCd, String msgDes) {
		super();
		this.retCd = retCd;
		this.msgDes = msgDes;
	}
 
	public String getRetCd() {
		return retCd;
	}
 
	public String getMsgDes() {
		return msgDes;
	}


}
