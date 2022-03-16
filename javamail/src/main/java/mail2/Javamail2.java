package mail2;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class Javamail2 {
	
	    static final String FROM = "wjdrbq@naver.com";
	    static final String FROMNAME = "wjdrbq";
	    static final String TO = "wjdrbq@naver.com";
	    static final String SMTP_USERNAME = "wjdrbq@naver.com";
	    static final String SMTP_PASSWORD = "zo7627sc!!";
	    
	    static final String HOST = "smtp.naver.com";
	    static final int PORT = 587;
	    
	    static final String SUBJECT = "메일 제목";
	    
	    static final String BODY = String.join(
	        System.getProperty("line.separator"),
	        "<h1>메일 내용</h1>",
	        "<p>이 메일은 아름다운 사람이 보낸 아름다운 메일입니다!</p>."
	    );
	    public static void main(String[] args) throws Exception {
	        Properties props = System.getProperties();
	        props.put("mail.transport.protocol", "smtp");
	        props.put("mail.smtp.port", PORT); 
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.auth", "true");
	        Session session = Session.getDefaultInstance(props);
	        MimeMessage msg = new MimeMessage(session);
	        msg.setFrom(new InternetAddress(FROM, FROMNAME));
	        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(TO));
	        msg.setSubject(SUBJECT);
	        msg.setContent(BODY, "text/html;charset=euc-kr");
	        
	        Transport transport = session.getTransport();
	        try {
	            System.out.println("Sending...");
	            
	            transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);
	            transport.sendMessage(msg, msg.getAllRecipients());
	            System.out.println("Email sent!");
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        } finally {
	            transport.close();
	        }
	    }
	}

