package co.yedam.yedamtour.reservation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.yedamtour.common.ViewResolve;
import co.yedam.yedamtour.reservation.service.ReservationService;
import co.yedam.yedamtour.reservation.service.ReservationVO;
import co.yedam.yedamtour.reservation.serviceImpl.ReservationServiceImpl;

@WebServlet("/reservationlist2.do")
public class ReservationList2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReservationList2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReservationService dao = new ReservationServiceImpl();
		ReservationVO startvo = new ReservationVO();
		ReservationVO finishvo = new ReservationVO();
		
		String startDate = request.getParameter("startDate");
		String finishDate = request.getParameter("finishDate");
		String start = request.getParameter("start");
		String finish = request.getParameter("finish");
		String startGrade = request.getParameter("startGrade");
		String person = request.getParameter("person");
		String startPrice = request.getParameter("startPrice");
		String finishGrade = request.getParameter("finishGrade");
		String finishPrice = request.getParameter("finishPrice");
		
		int direction = Integer.valueOf(request.getParameter("direction"));
		int direction1 = Integer.valueOf(request.getParameter("direction1"));
		
		startvo.setReservationId(direction);;
		finishvo.setReservationId(direction1);
		
		
		
		
		String page = "admin/reservation/reservationlist";
		ViewResolve.forward(request, response, page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
