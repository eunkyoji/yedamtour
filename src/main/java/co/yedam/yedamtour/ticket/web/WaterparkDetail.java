package co.yedam.yedamtour.ticket.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.yedamtour.common.ViewResolve;
import co.yedam.yedamtour.ticket.service.WaterparkService;
import co.yedam.yedamtour.ticket.service.WaterparkVO;
import co.yedam.yedamtour.ticket.serviceImpl.WaterparkServiceImpl;

@WebServlet("/waterparkdetail.do")
public class WaterparkDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public WaterparkDetail() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		WaterparkService dao = new WaterparkServiceImpl();
		WaterparkVO vo = new WaterparkVO();

		int id = Integer.parseInt(request.getParameter("id"));

		vo.setWaterparkId(id);

		vo = dao.waterparkSelect(vo);
		request.setAttribute("vo", vo);

		String page = "ticket/waterparkdetail";
		ViewResolve.forward(request, response, page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
