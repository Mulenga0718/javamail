package demo;

import javax.swing.plaf.multi.MultiToolTipUI;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

public class FileEmail {

	public static void main(String[] args) throws EmailException {
		// TODO Auto-generated method stub
		System.out.println("=====start send=====");
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath("D:/file.txt");
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("song of peter");
		attachment.setName("peter.txt");
		
		MultiPartEmail email = new MultiPartEmail();
		
		email.setDebug(true);
		email.setHostName("smtp.naver.com");
		email.setSmtpPort(587);
		email.setAuthenticator(new DefaultAuthenticator("wjdrbq", "zo7627sc!!"));
		email.setSSLOnConnect(true);
		email.setFrom("wjdrbq@naver.com");
		email.setSubject("내용");
		email.setMsg("연습");
		email.addTo("com32415674@naver.com");
		
		email.attach(attachment);
		email.send();
		System.out.println("=====end send=====");
		
	}

}
