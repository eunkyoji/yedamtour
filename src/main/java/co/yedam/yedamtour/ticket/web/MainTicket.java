package co.yedam.yedamtour.ticket.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.yedamtour.common.ViewResolve;
import co.yedam.yedamtour.ticket.service.ThemeparkService;
import co.yedam.yedamtour.ticket.service.ThemeparkVO;
import co.yedam.yedamtour.ticket.serviceImpl.ThemeparkServiceImpl;

@WebServlet("/mainticket.do")
public class MainTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MainTicket() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ThemeparkService dao = new ThemeparkServiceImpl();
		List<ThemeparkVO> vo = new ArrayList<>();
		
		vo = dao.themeparkSelectList();
		request.setAttribute("vo", vo);
		
		
		
		String page = "ticket/mainticket";
		ViewResolve.forward(request, response, page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
