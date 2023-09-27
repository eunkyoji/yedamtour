package co.yedam.yedamtour.member.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.yedamtour.member.Impl.MemberServiceImpl;
import co.yedam.yedamtour.member.service.MemberService;
import co.yedam.yedamtour.member.service.MemberVO;

@WebServlet("/check.do")
public class IdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public IdCheck() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setMemberId(request.getParameter("memberId"));
		vo = dao.idCheckSelect(vo);
		System.out.println(vo);
		
		String str = "Yes"; //사용 가능한 아이디
		
		//null이면 아이디 생성가능aa
		if (vo != null) {
			str = "No";  //이미 존재하는 아이디 입니다.
		} 
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().append(str);
		return;
//		if(vo!=null) {
//			response.setContentType("text/html; charset=UTF-8");
//			PrintWriter out = response.getWriter();
//			out.write("'이미 존재하는 아이디입니다.'");
//			
//			out.flush();
//			out.close();
//		}else {
//			response.setContentType("text/html; charset=UTF-8");
//			PrintWriter out = response.getWriter();
//			out.write("'사용가능한 아이디입니다.'");
//			
//			out.flush();
//			out.close();
//		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
