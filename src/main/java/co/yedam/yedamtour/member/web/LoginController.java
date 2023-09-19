package co.yedam.yedamtour.member.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.yedamtour.common.ViewResolve;
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
		vo.setMemberPassword(request.getParameter("memberPassword"));
		
		vo = dao.memberSelect(vo);
		System.out.println(vo);
		String page = null;
		if(vo != null) {
			
			session.setAttribute("id", vo.getMemberId());
			
			page = "tour.do";
			response.sendRedirect(page);
		} else {
			
			request.setAttribute("message", "아이디 패스워드가 틀림");
			String path = "member/membermessage.jsp";
			ViewResolve.forward(request, response, path);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
