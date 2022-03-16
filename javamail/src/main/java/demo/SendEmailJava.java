package demo;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class SendEmailJava {

		public static void main(String[] args) throws EmailException {
			System.out.println("=====start send=====");
			Email email = new SimpleEmail();
			email.setHostName("smtp.naver.com");
			email.setSmtpPort(587);
			email.setAuthenticator(new DefaultAuthenticator("wjdrbq", "zo7627sc!!"));
			email.setSSLOnConnect(true);
			email.setFrom("wjdrbq@naver.com");
			email.setSubject("내용");
			email.setMsg("연습");
			email.addTo("com32415674@naver.com");
			email.send();
			System.out.println("=====end send=====");
			
		}
}
