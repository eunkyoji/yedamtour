package co.yedam.yedamtour.airplane;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.yedamtour.common.ViewResolve;

@WebServlet("/bookairplane.do")
public class BookAirplane extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BookAirplane() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터로 받아오고
		//String categoryId = "13";//request.getParameter("categoryId");
		
		// 어트리뷰트로 넘겨주고
		
		String page = "transportation/bookairplane";
		ViewResolve.forward(request, response, page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
