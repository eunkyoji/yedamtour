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

/**
 * Servlet implementation class MemberDelete
 */
@WebServlet("/memberdelete.do")
public class MemberDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberDelete() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		String page = null;
		String id = request.getParameter("id");
		System.out.println(id);
		vo.setMemberId(id);
		System.out.println(vo);
		int result = dao.memberDelete(vo);
		if (result == 1) {
			System.out.println(result);
			session.invalidate();
			//세션찍히는지확인
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
