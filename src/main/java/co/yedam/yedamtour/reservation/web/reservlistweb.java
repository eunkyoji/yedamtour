package co.yedam.yedamtour.reservation.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.yedamtour.common.ViewResolve;
import co.yedam.yedamtour.reservation.service.ReservationService;
import co.yedam.yedamtour.reservation.service.ReservationVO;
import co.yedam.yedamtour.reservation.serviceImpl.ReservationServiceImpl;

@WebServlet("/reserv.do")
public class reservlistweb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public reservlistweb() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReservationService dao = new ReservationServiceImpl();
		List<ReservationVO> vo = new ArrayList<>();
		
		vo = dao.reservationListSelectList();
		
		request.setAttribute("vo", vo);
		
		String page = "admin/reservation/reservationlistmain";
		ViewResolve.forward(request, response, page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
