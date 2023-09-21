package co.yedam.yedamtour.member.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.yedamtour.common.ViewResolve;
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
		String pw = request.getParameter("password");
		vo.setMemberId(request.getParameter("id"));
		vo.setMemberName(request.getParameter("name"));
		vo.setMemberNickname(request.getParameter("nickname"));
		vo.setMemberPhone(request.getParameter("phone"));
		vo.setMemberEmail(request.getParameter("email"));
		System.out.println(request.getParameter("id"));
		System.out.println(vo);

		if (pw != null) {
			vo.setMemberPassword(request.getParameter("password"));
		}
		int result = dao.memberUpdate(vo);
		System.out.println(result);
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
