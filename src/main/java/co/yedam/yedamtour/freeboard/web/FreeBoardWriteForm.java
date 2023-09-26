package co.yedam.yedamtour.freeboard.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.yedamtour.common.ViewResolve;

@WebServlet("/freeboardwriteform.do")
public class FreeBoardWriteForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FreeBoardWriteForm() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String author = (String)session.getAttribute("author");
		
		if( "Admin".equals(author) ) {
			String page = "admin/freeboard/freeboardwriteform";
			ViewResolve.forward(request, response, page);
		} else {
			String page = "freeboard/freeboardwriteform";
			ViewResolve.forward(request, response, page);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
