package co.yedam.yedamtour.ticket.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.yedamtour.common.ViewResolve;
import co.yedam.yedamtour.ticket.service.AquariumService;
import co.yedam.yedamtour.ticket.service.AquariumVO;
import co.yedam.yedamtour.ticket.serviceImpl.AquariumServiceImpl;

@WebServlet("/aquariumdetail.do")
public class AquariumDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AquariumDetail() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AquariumService dao = new AquariumServiceImpl();
		AquariumVO vo = new AquariumVO();

		int id = Integer.parseInt(request.getParameter("id"));

		vo.setAquariumId(id);

		vo = dao.aquariumSelect(vo);
		request.setAttribute("vo", vo);

		String page = "ticket/aquariumdetail";
		ViewResolve.forward(request, response, page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
