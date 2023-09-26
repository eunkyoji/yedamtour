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
import co.yedam.yedamtour.ticket.service.WaterparkService;
import co.yedam.yedamtour.ticket.service.WaterparkVO;
import co.yedam.yedamtour.ticket.serviceImpl.WaterparkServiceImpl;

@WebServlet("/waterpark.do")
public class WaterPark extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WaterPark() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WaterparkService dao = new WaterparkServiceImpl();
		List<WaterparkVO> vo = new ArrayList<>();
		
		vo = dao.waterparkSelectList();
		request.setAttribute("vo", vo);
		
		String page = "ticket/waterpark";
		ViewResolve.forward(request, response, page);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
