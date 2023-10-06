package co.yedam.yedamtour.reservation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.yedamtour.camping.service.CampingService;
import co.yedam.yedamtour.camping.service.CampingVO;
import co.yedam.yedamtour.camping.serviceImpl.CampingServiceImpl;
import co.yedam.yedamtour.common.ViewResolve;
import co.yedam.yedamtour.hotel.service.HotelService;
import co.yedam.yedamtour.hotel.service.HotelVO;
import co.yedam.yedamtour.hotel.serviceImpl.HotelServiceImpl;
import co.yedam.yedamtour.member.Impl.MemberServiceImpl;
import co.yedam.yedamtour.member.service.MemberService;
import co.yedam.yedamtour.member.service.MemberVO;
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
		System.out.println("인서트확인");
		String categoryId = request.getParameter("categoryId");
		rvo.setCategoryId(categoryId);
		rvo.setReservationName(request.getParameter("reservationName"));
		rvo.setReservationWriterId(request.getParameter("reservationWriterId"));
		rvo.setReservationPhone(request.getParameter("reservationPhone"));
		rvo.setReservationPersonnel(Integer.valueOf(request.getParameter("reservationPersonnel")));
		rvo.setReservationPrice(request.getParameter("reservationPrice"));
		rvo.setProductName(request.getParameter("hotelName"));
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
		
		
		//
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		String pw = (String) session.getAttribute("password");
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();

		ReservationService rdao2 = new ReservationServiceImpl();
		ReservationVO rvo2 = new ReservationVO();
		List<ReservationVO> rvoList = new ArrayList<>();

		rvo2.setReservationWriterId(id);
		rvoList = rdao2.reservationCartSelectList(rvo2);

		request.setAttribute("rvo2", rvoList);

		ReservationVO rvo3 = new ReservationVO();
		List<ReservationVO> rvoList2 = new ArrayList<>();

		rvo3.setReservationWriterId(id);
		rvoList2 = rdao2.reservationCartFinishSelectList(rvo3);

		request.setAttribute("rvo2", rvoList2);

		vo.setMemberId(id);
		vo.setMemberPassword(pw);
		vo = dao.memberSelect(vo);

		request.setAttribute("list", vo);
		
		response.sendRedirect("membermypage.do");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
