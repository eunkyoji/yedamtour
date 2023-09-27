package co.yedam.yedamtour.ticket.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.yedamtour.common.ViewResolve;
import co.yedam.yedamtour.ticket.service.AquariumService;
import co.yedam.yedamtour.ticket.service.AquariumVO;
import co.yedam.yedamtour.ticket.serviceImpl.AquariumServiceImpl;

@WebServlet("/aquarium.do")
public class Aquarium extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Aquarium() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		System.out.println(session.getId()); 
		
		AquariumService dao = new AquariumServiceImpl();
		List<AquariumVO> vo = new ArrayList<>();
		
		vo = dao.aquariumSelectList();
		request.setAttribute("vo", vo);
		
		String page = "ticket/aquarium";
		ViewResolve.forward(request, response, page);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
