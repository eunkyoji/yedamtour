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

@WebServlet("/detailticket.do")
public class DetailTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DetailTicket() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ThemeparkService dao = new ThemeparkServiceImpl();
		ThemeparkVO vo = new ThemeparkVO();
		System.out.println(request.getParameter("id"));
		
//		vo.setThemeparkId(id);
//		
//		vo = dao.themeparkSelect(vo);
//		request.setAttribute("vo", vo);
//		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
