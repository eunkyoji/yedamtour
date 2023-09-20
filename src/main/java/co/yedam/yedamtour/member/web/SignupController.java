package co.yedam.yedamtour.member.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.yedamtour.common.ViewResolve;
import co.yedam.yedamtour.member.Impl.MemberServiceImpl;
import co.yedam.yedamtour.member.service.MemberService;
import co.yedam.yedamtour.member.service.MemberVO;

@WebServlet("/signup.do")
public class SignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SignupController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		MemberVO vo2 = new MemberVO();
		String pw1 = request.getParameter("memberPassword");
		String pw2 = request.getParameter("memberPasswordCheck");
		vo2.setMemberId(request.getParameter("memberId"));

		if (dao.signupIdSelect(vo2) == null) {

			if (pw1.equals(pw2)) {
				vo.setMemberId(request.getParameter("memberId"));
				vo.setMemberPassword(request.getParameter("memberPassword"));
				vo.setMemberName(request.getParameter("memberName"));
				vo.setMemberEmail(request.getParameter("memberEmail"));
				vo.setMemberPhone(request.getParameter("memberPhone"));
				vo.setMemberNickname(request.getParameter("memberNickname"));
			} else {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();

				out.write("<script>alert('비밀번호가 다릅니다.');" + "history.go(-1);</script>");

				out.flush();
				out.close();
			}
		}else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();

			out.write("<script>alert('이미 존재하는 아이디입니다.');" + "history.go(-1);</script>");

			out.flush();
			out.close();
		}

		int result = dao.memberInsert(vo);
		System.out.println(result);
		String page = null;

		if (result == 1) {
			page = "member/login.jsp";
			ViewResolve.forward(request, response, page);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}