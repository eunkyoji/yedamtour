package co.yedam.yedamtour.qna.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.yedamtour.common.ViewResolve;

/**
 * Servlet implementation class QandAWrite
 */
@WebServlet("/qnawriteform.do")
public class QandAWriteForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QandAWriteForm() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String author = (String)session.getAttribute("author");
		
		if( "Admin".equals(author) ) {
			String page = "admin/qna/qnawriteform";
			ViewResolve.forward(request, response, page);
		} else {
			String page = "qna/qnawriteform";
			ViewResolve.forward(request, response, page);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
