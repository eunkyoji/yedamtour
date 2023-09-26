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
		String person = request.getParameter("person");
		
		int direction = Integer.valueOf(request.getParameter("direction"));
		int direction1 = Integer.valueOf(request.getParameter("direction1"));
		
		startvo.setReservationId(direction);		
		startvo = dao.reservationSelect(startvo);
		if(startvo != null) {
			request.setAttribute("startCart", startvo);
			
		}
		finishvo.setReservationId(direction1);
		finishvo = dao.reservationSelect(finishvo);
		if(finishvo != null) {
			request.setAttribute("finishCart", finishvo);
		}
		
		int startCartId = startvo.getReservationId();
		int finishCartId = startvo.getReservationId();
		
		request.setAttribute("startDate", startDate);
		request.setAttribute("finishDate", finishDate);
		request.setAttribute("person", person);
		request.setAttribute("startCartId", startCartId);
		request.setAttribute("finishCartId", finishCartId);
		
		String page = "admin/reservation/reservationlist";
		ViewResolve.forward(request, response, page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
