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

@WebServlet("/reservationInsert.do")
public class ReservationInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReservationInsert() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReservationService rdao = new ReservationServiceImpl();
		ReservationVO rvo = new ReservationVO();
		
		rvo.setCategoryId(request.getParameter("categoryId"));
		rvo.setReservationName(request.getParameter("reservationName"));
		rvo.setReservationWriterId(request.getParameter("reservationWriterId"));
		rvo.setReservationPhone(request.getParameter("reservationPhone"));
		rvo.setReservationPersonnel(Integer.valueOf(request.getParameter("reservationPersonnel")));
		rvo.setReservationPrice(request.getParameter("reservationPrice"));
		rvo.setStayId(Integer.valueOf(request.getParameter("hotelId")));
		rvo.setStaySubId(Integer.valueOf(request.getParameter("hotelSubId")));
		String date = request.getParameter("daterange");
		String startDate = date.substring(0,10);
		String endDate = date.substring(13,23);
		rvo.setReservationStartDate(startDate);
		rvo.setReservationFinishDate(endDate);
		System.out.println("date = " + date);
		System.out.println(rvo);
		System.out.println(startDate);
		System.out.println(endDate);
		
		rdao.reservationStayInsert(rvo);
		
		String page = "reservation/cart";
		ViewResolve.forward(request, response, page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
