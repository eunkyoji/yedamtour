package co.yedam.yedamtour.member.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.yedamtour.member.Impl.MemberServiceImpl;
import co.yedam.yedamtour.member.service.MemberService;
import co.yedam.yedamtour.member.service.MemberVO;

@WebServlet("/memberedit.do")
public class MemberEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberEdit() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberVO vo2 = new MemberVO();
		MemberService dao = new MemberServiceImpl();
		String page = null;
		vo2.setMemberId(request.getParameter("memberId"));
		int result = dao.memberUpdate(vo2);
		if (result == 1) {
			session.setAttribute("id", vo2.getMemberId());
			session.setAttribute("pw", vo2.getMemberPassword());
			page = "membermypage.do";
			response.sendRedirect(page);

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
