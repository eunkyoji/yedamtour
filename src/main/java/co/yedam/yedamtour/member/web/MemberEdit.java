package co.yedam.yedamtour.member.web;

import java.io.IOException;

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

@WebServlet("/memberedit.do")
public class MemberEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberEdit() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		String pw = SHA256.encrypt(request.getParameter("password"));
		String id = request.getParameter("useId");
		
		vo.setMemberId(request.getParameter("id"));
		vo.setMemberName(request.getParameter("name"));
		vo.setMemberNickname(request.getParameter("nickname"));
		vo.setMemberPassword(SHA256.encrypt(request.getParameter("password")));
		vo.setMemberPhone(request.getParameter("phone"));
	
		int result = dao.memberUpdate(vo);
		System.out.println(result);
		if(result ==1) {
			HttpSession session = request.getSession();
			session.setAttribute("id", vo.getMemberId());
			session.setAttribute("password", vo.getMemberPassword());
			session.setAttribute("author", vo.getMemberAuthor());
		}
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
