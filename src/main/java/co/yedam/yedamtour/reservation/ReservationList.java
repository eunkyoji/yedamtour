package co.yedam.yedamtour.reservation;

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

@WebServlet("/reservationlist.do")
public class ReservationList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReservationList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ReservationService dao = new ReservationServiceImpl();
		
		List<ReservationVO> startCarts = new ArrayList<ReservationVO>();
		List<ReservationVO> finishCarts = new ArrayList<ReservationVO>();
		 
		ReservationVO startvo = new ReservationVO();
		ReservationVO finishvo = new ReservationVO();
		
		String finishDate = request.getParameter("finishDate");
		String finish = request.getParameter("finish");		
		
		int person = Integer.valueOf(request.getParameter("person"));
		request.setAttribute("person", person);
		
		String startDate = request.getParameter("startDate");
		String start = request.getParameter("start");
		
		int direction = Integer.valueOf(request.getParameter("direction"));
		
		
		startvo.setReservationId(direction);		
		startvo = dao.reservationTransSelect(startvo);
		if(startvo != null) {
			request.setAttribute("startCart", startvo);
			
		}
		
		int startCartId = startvo.getReservationId();
		
		request.setAttribute("startDate", startDate);
		request.setAttribute("start", start);
		request.setAttribute("startCartId", startCartId);
		
		int n = dao.reservationTransInsert(startvo);
		
		if( finishDate != null && n != 0 ) {
		
			int direction1 = Integer.valueOf(request.getParameter("direction1"));
			
			
			finishvo.setReservationId(direction1);
			finishvo = dao.reservationTransSelect(finishvo);
			
			if(finishvo != null) {
				request.setAttribute("finishCart", finishvo);
			}
			
			int finishCartId = finishvo.getReservationId();
			
			request.setAttribute("finishDate", finishDate);
			request.setAttribute("finish", finish);
			request.setAttribute("finishCartId", finishCartId);
			
		}
		
		//startCarts = dao.reservationTransSelectList(startvo);
		//finishCarts = dao.reservationTransSelectList(finishvo);
		
		String page = "admin/reservation/reservationlist";
		ViewResolve.forward(request, response, page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
