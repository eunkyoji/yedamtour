package co.yedam.yedamtour.member.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.yedamtour.common.AlertControl;
import co.yedam.yedamtour.common.SHA256;
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
		HttpSession session = request.getSession();
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		MemberVO vo2 = new MemberVO();

		MemberVO vo3 = new MemberVO();
		

		
		String id = session.getId();

		String pw1 = request.getParameter("memberPassword");
		String pw2 = request.getParameter("memberPasswordCheck");
		String name = request.getParameter("memberName");
		String phone = request.getParameter("memberPhone");
		String id1 = request.getParameter("memberId");
		vo2.setMemberName(name);
		vo2.setMemberPhone(phone);
		vo2 = dao.signupIdSelect(vo2);	//이름과 번호 체크
		vo3.setMemberId(id1);
		vo3 = dao.idCheckSelect(vo3);	//아이디체크
		if(vo2 != null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();

			out.write("<script>alert('이미 등록된 회원입니다.');" + "history.go(-1);</script>");

			out.flush();
			out.close();
		}
		if ( vo2 == null && vo3 == null) {
			
			

			if (pw1.equals(pw2)) {
				vo.setMemberId(request.getParameter("memberId"));
				vo.setMemberPassword(SHA256.encrypt(request.getParameter("memberPassword")));
				vo.setMemberName(request.getParameter("memberName"));
				vo.setMemberPhone(request.getParameter("memberPhone"));
				vo.setMemberNickname(request.getParameter("memberNickname"));
				if( id1 != null ) {
					vo.setMemberAuthor("Admin");
				}
			} else {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();

				out.write("<script>alert('비밀번호가 다릅니다.');" + "history.go(-1);</script>");

				out.flush();
				out.close();
			}
		}

		int result = dao.memberInsert(vo);
		System.out.println(result);
		String page = null;

		if (result == 1) {
//			page = "member/login.jsp";
//			ViewResolve.forward(request, response, page);
			AlertControl.alertAndGo(response, "가입이 완료되었습니다.", "loginform.do");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
