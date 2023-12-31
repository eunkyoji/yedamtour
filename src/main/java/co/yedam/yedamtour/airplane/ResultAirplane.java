package co.yedam.yedamtour.airplane;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.yedamtour.airplane.service.AirplaneService;
import co.yedam.yedamtour.airplane.service.AirplaneVO;
import co.yedam.yedamtour.airplane.serviceImpl.AirplaneServiceImpl;
import co.yedam.yedamtour.common.ViewResolve;
import co.yedam.yedamtour.reservation.service.ReservationService;
import co.yedam.yedamtour.reservation.service.ReservationVO;
import co.yedam.yedamtour.reservation.serviceImpl.ReservationServiceImpl;

@WebServlet("/resultairplane.do")
public class ResultAirplane extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ResultAirplane() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		AirplaneService dao = new AirplaneServiceImpl();
		ReservationService dao2 = new ReservationServiceImpl();
		AirplaneVO startvo = new AirplaneVO();
		AirplaneVO finishvo = new AirplaneVO();	
		ReservationVO cartvo = new ReservationVO();

		String startDate = request.getParameter("startDate");
		String finishDate = request.getParameter("finishDate");
		int person = Integer.valueOf(request.getParameter("person"));
		
		int direction = Integer.valueOf(request.getParameter("direction"));
		int direction1 = Integer.valueOf(request.getParameter("direction1"));
		
		startvo.setAirplaneId(direction);		
		startvo = dao.airplaneSelect(startvo);
		if(startvo != null) {
			request.setAttribute("startAir", startvo);
		}
		
		finishvo.setAirplaneId(direction1);
		finishvo = dao.airplaneSelect(finishvo);
		if(finishvo != null) {
			request.setAttribute("finishAir", finishvo);
		}
		
		int startAirId = startvo.getAirplaneId();
		int finishAirId = finishvo.getAirplaneId();
		int startPrice = startvo.getAirplanePrice()*person;
		int finishPrice = finishvo.getAirplanePrice()*person;
		
		request.setAttribute("startDate", startDate);
		request.setAttribute("finishDate", finishDate);
		request.setAttribute("person", person);
		request.setAttribute("startPrice", startPrice);
		request.setAttribute("finishPrice", finishPrice);
		request.setAttribute("startAirId", startAirId);
		request.setAttribute("finishAirId", finishAirId);
		
		cartvo.setReservationId(direction);
		/* int n = dao2.reservationTransInsert(cartvo); */
		
		String page = "transportation/resultairplane";
		ViewResolve.forward(request, response, page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
