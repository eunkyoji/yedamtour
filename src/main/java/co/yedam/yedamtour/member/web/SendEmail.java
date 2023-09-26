package co.yedam.yedamtour.member.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
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

import co.yedam.yedamtour.common.AlertControl;
import co.yedam.yedamtour.common.SHA256;
import co.yedam.yedamtour.common.ViewResolve;
import co.yedam.yedamtour.member.Impl.MemberServiceImpl;
import co.yedam.yedamtour.member.service.MemberService;
import co.yedam.yedamtour.member.service.MemberVO;

@WebServlet("/sendemail.do")
public class SendEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SendEmail() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 먼저 아이디로 회원정보를 받아오고 가져온 데이터에서 email값을 비교하여 존재하지 않으면 인증메일 보내지 못함
		/*
		 * Member m = new MemberService().memberLogin(memberId); if(m==null ||
		 * !m.getEmail().equals(email)) { req.setAttribute("msg",
		 * "아이디나 이메일 정보가 맞지 않습니다"); req.setAttribute("loc", "/member/searchPw");
		 * req.getRequestDispatcher("/views/common/msg.jsp").forward(req, resp); return;
		 * }
		 */
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		MemberVO vo2 = new MemberVO();
		vo.setMemberName(request.getParameter("memberName"));
		vo.setMemberPhone(request.getParameter("memberPhone"));
		vo = dao.memberSearch(vo);
		if(vo != null) {
			
		
		String memberId = vo.getMemberId();

		String to_email = vo.getMemberId();

		System.out.println(vo.getMemberId());

		// mail server 설정
		String host = "smtp.naver.com";
		String user = "tabcapslock9@naver.com"; // 자신의 네이버 계정
		String password = "!qazxsw299";// 자신의 네이버 패스워드

		// 메일 받을 주소
		/* String to_email = m.getEmail(); */

		// SMTP 서버 정보를 설정한다.
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", 465);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");

		// 인증 번호 생성기
		String temp = "";
		Random rnd = new Random();
		for (int i = 0; i < 5; i++) {
			// 0-9
			temp += "" + (rnd.nextInt(10));
		}
		System.out.println("임시비밀번호: " + temp);
		
		vo2.setMemberId(memberId);
		vo2.setMemberPassword(SHA256.encrypt(temp));
		int result = dao.memberUpdate(vo2);
		if (result == 1) {

			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(user, password);
				}
			});

			// email 전송
			MimeMessage msg = new MimeMessage(session);
			try {
				msg.setFrom(new InternetAddress(user, "YedaumTour"));
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to_email));

				// 메일 제목
				msg.setSubject("[YedamTour] 안녕하세요. 요청하신 아이디와 비밀번호입니다.");
				// 메일 내용

				msg.setText("아이디: "+memberId+" 임시비밀번호 :" + temp +"로그인후 반드시 비밀번호를 변경해주세요.");

				Transport.send(msg);
				System.out.println("이메일 전송");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (MessagingException e) {
				e.printStackTrace();
			}
			
			AlertControl.alertAndGo(response, to_email + " 이메일을 확인해주세요.", "loginform.do");
		}
	}else {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.write("<script>alert('일치하는 정보가 없습니다.');" + "history.go(-1);</script>");

		out.flush();
		out.close();
	}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
