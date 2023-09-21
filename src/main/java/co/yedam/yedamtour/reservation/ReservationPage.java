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
import co.yedam.yedamtour.reservation.ReservationService;
import co.yedam.yedamtour.reservation.ReservationServiceImpl;
import co.yedam.yedamtour.reservation.ReservationVO;


@WebServlet("/reservationpage.do")
public class ReservationPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    public ReservationPage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReservationService dao = new ReservationServiceImpl();
		List<ReservationVO> reservations = new ArrayList<ReservationVO>();
		ReservationVO vo = new ReservationVO();		
		
		int hotelId = Integer.valueOf(request.getParameter("hotelId"));
		vo.setReservationId(hotelId);
		dao.reservationInsert(vo);
		request.setAttribute("reservations", reservations);
				
		String page = "reservation/reservationpage";
		ViewResolve.forward(request, response, page);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
