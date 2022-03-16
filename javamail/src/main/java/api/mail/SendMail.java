package api.mail;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class SendMail {
	public static void main(String[] args) throws AddressException, MessagingException {
		
		Javamail send = new Javamail();
		send.sendMail("com32415674@naver.com");
	
	}
}
