package api.mail;


import java.util.Properties;


import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Javamail {
	
	public static void sendMail(String recepient) throws MessagingException {
		
		System.out.println("prepareing");
		Properties properties = new Properties();
		String host = "smtp.naver.com";
	
		// SMTP 서버 정보 설정
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "localhost");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.ssl.trust", host);

		
		//   
		final String un= "wjdrbq@naver.com";
		final String pw= "zo7627sc!!";
		
		//Session 생성 
		Session session = Session.getDefaultInstance(properties, new Authenticator() {
		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(un, pw);
		}
		});
		session.setDebug(true);

		Message message = prepareMessage(session, un, recepient);
		Transport.send(message);
		System.out.println("Messge sent successfully");
	}
	
	private static Message prepareMessage(Session session, String un, String recepient) {
		
		try {
		Message mimemessage = new MimeMessage(session); 
		
		// 발신자 메일주소
		mimemessage.setFrom(new InternetAddress(un));
	
		//수신자 메일주소 
		mimemessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
		
		//제목 
		mimemessage.setSubject("연습");
		//내용
		mimemessage.setText("내용");
	
		return mimemessage;
		
		}catch(Exception e) {
			
		}
		
		return null;
	}
	
}
