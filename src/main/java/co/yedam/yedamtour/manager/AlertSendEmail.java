package co.yedam.yedamtour.manager;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.yedamtour.reservation.service.ReservationService;
import co.yedam.yedamtour.reservation.service.ReservationVO;
import co.yedam.yedamtour.reservation.serviceImpl.ReservationServiceImpl;

@WebServlet("/alertsendemail.do")
public class AlertSendEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AlertSendEmail() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int reservationId = Integer.parseInt(request.getParameter("reservId"));
		ReservationVO vo = new ReservationVO();
		ReservationVO vo2 = new ReservationVO();
		ReservationService dao = new ReservationServiceImpl();
		vo.setReservationId(reservationId);
		vo = dao.reservationTransSelect(vo);
		
		
		String email = "jaegoo41@gmail.com";
		String to_email = request.getParameter("id");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email, "krce vojm lhmf memc");
			}
		});
		
		String receiver = to_email; // 메일 받을 주소
		String title = "예담투어의 주문내역입니다. 확인해주세요.";
		String content = "<h2 style='color:blue'>주문 내역은 아래와 같습니다.</h2><br>" +
		"상품명: "+vo.getProductName()+" 수량: "+vo.getReservationPersonnel()+" 가격: "+vo.getReservationPrice()+ "원";
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(email, "예담투어 관리자", "utf-8"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
			message.setSubject(title);
			message.setContent(content, "text/html; charset=utf-8");
 
			Transport.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		vo2.setSendCheck("yes");
		vo2.setReservationId(reservationId);
		int result = dao.reservationSendCheckUpdate(vo2);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
