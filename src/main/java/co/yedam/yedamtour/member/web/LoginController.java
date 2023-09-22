package co.yedam.yedamtour.member.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.yedamtour.common.SHA256;
import co.yedam.yedamtour.member.Impl.MemberServiceImpl;
import co.yedam.yedamtour.member.service.MemberService;
import co.yedam.yedamtour.member.service.MemberVO;

@WebServlet("/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 로그인
		
		HttpSession session = request.getSession();

		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();

		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberPassword(SHA256.encrypt(request.getParameter("memberPassword")));
		
		vo = dao.memberSelect(vo);
		String page = null;
		if(vo != null) {
			
			session.setAttribute("id", vo.getMemberId());
			session.setAttribute("password", vo.getMemberPassword());
			
			page = "tour.do";
			response.sendRedirect(page);
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();

			out.write("<script>alert('아이디 혹은 비밀번호가 다릅니다.');"
					+ "history.go(-1);</script>");
			
			out.flush();
			out.close();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
