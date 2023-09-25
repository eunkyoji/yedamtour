package co.yedam.yedamtour.stay;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.yedamtour.common.ViewResolve;
import co.yedam.yedamtour.hotel.service.HotelService;
import co.yedam.yedamtour.hotel.service.HotelVO;
import co.yedam.yedamtour.hotel.serviceImpl.HotelServiceImpl;
import co.yedam.yedamtour.member.Impl.MemberServiceImpl;
import co.yedam.yedamtour.member.service.MemberService;
import co.yedam.yedamtour.member.service.MemberVO;

@WebServlet("/booking.do")
public class Booking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Booking() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = session.getId();
		int hotelId = Integer.parseInt(request.getParameter("hotelId"));
		int hotelSubId = Integer.parseInt(request.getParameter("hotelSubId"));
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		System.out.println(hotelId + "," + categoryId);
		
		MemberService mdao = new MemberServiceImpl();
		MemberVO mvo = new MemberVO();
		mvo.setMemberId(id);
		mvo = mdao.memberSelect(mvo);
		
		HotelService hdao = new HotelServiceImpl();
		HotelVO hvo = new HotelVO();
		hvo.setHotelId(hotelId);
		
		hvo.setHotelSubId(hotelSubId);
		hvo = hdao.hotelRoomSelect(hvo);
		hvo.setMemberId(id);
		hvo.setMemberName(hvo.getMemberName());
		hvo.setMemberPhone(hvo.getMemberPhone());
		hvo.setCategoryId(categoryId);
		request.setAttribute("reserves", hvo);
		
		String page = "reservation/booking";
		ViewResolve.forward(request, response, page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
