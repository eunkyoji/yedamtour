package co.yedam.yedamtour.reservation.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.yedamtour.reservation.service.ReservationService;
import co.yedam.yedamtour.reservation.service.ReservationVO;
import co.yedam.yedamtour.reservation.serviceImpl.ReservationServiceImpl;

@WebServlet("/kakaopay.do")
public class KakaoPay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public KakaoPay() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ReservationService dao = new ReservationServiceImpl();
		ReservationVO vo = new ReservationVO();
		System.out.println(request.getParameter("productId"));
		vo.setReservationId(Integer.parseInt(request.getParameter("productId")));
		/* vo.setreservationticketName(); */
		vo.setReservationState(1);
		
		int result = dao.reservationCartUpdate(vo);
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
