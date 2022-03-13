package Demo1;

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
		attachment.setPath("C:/Users/User/Desktop/JUNK/사진/제주도/P20151020_125035000_AE822551-F5F3-4CD2-A13D-644A7957FD92.JPG");
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("picture of peter");
		attachment.setName("peter.jpg");
		
	
		MultiPartEmail email = new MultiPartEmail();
		email.setHostName("smtp.naver.com");
		email.setSmtpPort(587);
		email.setAuthenticator(new DefaultAuthenticator("dkrnq", "zo7627sc"));
		email.setSSLOnConnect(true);
		email.setFrom("dkrnq@naver.com");
		email.setSubject("내용");
		email.setMsg("연습");
		email.addTo("dkrnq@naver.com");
		
		email.attach(attachment);
		email.send();
		System.out.println("=====end send=====");
		
	}

}
