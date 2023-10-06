package co.yedam.yedamtour.reservation;

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

@WebServlet("/reservationregister.do")
public class ReservationRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReservationRegister() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("busStartGo"));
		ReservationVO vo = new ReservationVO();
		ReservationService dao = new ReservationServiceImpl();
		HttpSession session = request.getSession();
		
		String id = (String) session.getAttribute("id");
		
		vo.setCategoryId(request.getParameter("categoryId"));
		vo.setReservationPrice(request.getParameter("totalPrice"));
		vo.setReservationPersonnel(Integer.parseInt(request.getParameter("busPerson")));
		vo.setReservationFinish(request.getParameter("busStartEnd"));
		vo.setReservationStart(request.getParameter("busStartGo"));		
		vo.setReservationWriterId(id);
		String productName = vo.getReservationStart() + "->" + vo.getReservationFinish();
		vo.setProductName(productName);
		
		System.out.println(productName);
		int n = dao.reservationTransInsert(vo);
		String page = null;
		if(n != 0) {
			page = "membermypage.do";
		} else {
			page = "resultbus.do";
			
		}
		response.sendRedirect(page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
