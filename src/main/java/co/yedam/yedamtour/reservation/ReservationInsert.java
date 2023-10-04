package co.yedam.yedamtour.reservation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.yedamtour.camping.service.CampingService;
import co.yedam.yedamtour.camping.service.CampingVO;
import co.yedam.yedamtour.camping.serviceImpl.CampingServiceImpl;
import co.yedam.yedamtour.common.ViewResolve;
import co.yedam.yedamtour.hotel.service.HotelService;
import co.yedam.yedamtour.hotel.service.HotelVO;
import co.yedam.yedamtour.hotel.serviceImpl.HotelServiceImpl;
import co.yedam.yedamtour.pension.service.PensionService;
import co.yedam.yedamtour.pension.service.PensionVO;
import co.yedam.yedamtour.pension.serviceImpl.PensionServiceImpl;
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
		
		String categoryId = request.getParameter("categoryId");
		rvo.setCategoryId(categoryId);
		rvo.setReservationName(request.getParameter("reservationName"));
		rvo.setReservationWriterId(request.getParameter("reservationWriterId"));
		rvo.setReservationPhone(request.getParameter("reservationPhone"));
		rvo.setReservationPersonnel(Integer.valueOf(request.getParameter("reservationPersonnel")));
		rvo.setReservationPrice(request.getParameter("reservationPrice"));
		String date = request.getParameter("daterange");
		String startDate = date.substring(0,10);
		String endDate = date.substring(13,23);
		rvo.setReservationStartDate(startDate);
		rvo.setReservationFinishDate(endDate);
		
		
		if (categoryId.equals("1")) {
			rvo.setStayId(Integer.valueOf(request.getParameter("hotelId")));
			rvo.setStaySubId(Integer.valueOf(request.getParameter("hotelSubId")));			
		} else if (categoryId.equals("2")) {
			rvo.setStayId(Integer.valueOf(request.getParameter("pensionId")));
			rvo.setStaySubId(Integer.valueOf(request.getParameter("pensionSubId")));	
		} else if (categoryId.equals("3")){
			rvo.setStayId(Integer.valueOf(request.getParameter("campingId")));
			rvo.setStaySubId(Integer.valueOf(request.getParameter("campingSubId")));	
		}				
				
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
