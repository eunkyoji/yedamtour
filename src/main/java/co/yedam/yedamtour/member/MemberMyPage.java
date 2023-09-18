package co.yedam.yedamtour.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.yedamtour.common.ViewResolve;

@WebServlet("/membermypage.do")
public class MemberMyPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberMyPage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = "member/membermypage.jsp";
		ViewResolve.forward(request, response, page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
