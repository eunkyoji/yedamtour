package co.yedam.yedamtour.ticket;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.yedamtour.common.ViewResolve;

@WebServlet("/detailticket.do")
public class DetailTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DetailTicket() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = "ticket/detailticket";
		ViewResolve.forward(request, response, page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
