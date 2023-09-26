package co.yedam.yedamtour.member.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.yedamtour.common.AlertControl;

@WebServlet("/memberlogout.do")
public class MemberLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberLogout() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		//String name = (String) session.getAttribute("name");
		session.invalidate();	// 세션 정보를 완전히 삭제한다.
		
		AlertControl.alertAndGo(response, "로그아웃 되었습니다.", "tour.do");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
