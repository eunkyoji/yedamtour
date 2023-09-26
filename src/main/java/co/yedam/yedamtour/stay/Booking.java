package co.yedam.yedamtour.stay;

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

@WebServlet("/booking.do")
public class Booking extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("categoryId");

	public Booking() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String hotelId = request.getParameter("hotelId");
		String hotelSubId = request.getParameter("hotelSubId");
		String pensionId = request.getParameter("pensionId");
		String pensionSubId = request.getParameter("pensionSubId");
		String campingId = request.getParameter("campingId");
		String campingSubId = request.getParameter("campingSubId");
		String categoryId = request.getParameter("categoryId");
		System.out.println(hotelId + "," + categoryId);
		System.out.println("memberId :: " + request.getParameter("memberId"));
		MemberService mdao = new MemberServiceImpl();
		MemberVO mvo = new MemberVO();
		mvo.setMemberId(request.getParameter("memberId"));
		mvo = mdao.memberSelect(mvo);
System.out.println("mvo :: " + mvo);
		if (categoryId == "1") {
			HotelService hdao = new HotelServiceImpl();
			HotelVO hvo = new HotelVO();
			HotelVO vvo = new HotelVO();
			hvo.setHotelId(Integer.parseInt(hotelId));

			hvo.setHotelSubId(Integer.parseInt(hotelSubId));
			vvo = hdao.hotelRoomSelect(hvo);
			System.out.println(vvo);
			
			hvo.setMemberId(mvo.getMemberId());
			hvo.setMemberName(mvo.getMemberName());
			hvo.setMemberPhone(mvo.getMemberPhone());
			hvo.setCategoryId(categoryId);
			
			request.setAttribute("reserves", hvo);

			System.out.println(hvo);
			
		} else if (categoryId == "2") {
			PensionService pdao = new PensionServiceImpl();
			PensionVO pvo = new PensionVO();
			pvo.setMemberId(mvo.getMemberId());

			pvo.setPensionSubId(Integer.parseInt(pensionSubId));
			pvo = pdao.pensionRoomSelect(pvo);
			pvo.setMemberId(mvo.getMemberId());
			pvo.setMemberName(mvo.getMemberName());
			pvo.setMemberPhone(mvo.getMemberPhone());
			pvo.setCategoryId(categoryId);
			request.setAttribute("reserves", pvo);
			
		} else if (categoryId == "3"){
			CampingService cdao = new CampingServiceImpl();
			CampingVO cvo = new CampingVO();
			cvo.setMemberId(mvo.getMemberId());

			cvo.setCampingSubId(Integer.parseInt(campingSubId));
			cvo = cdao.campingRoomSelect(cvo);
			cvo.setMemberId(mvo.getMemberId());
			cvo.setMemberName(mvo.getMemberName());
			cvo.setMemberPhone(mvo.getMemberPhone());
			cvo.setCategoryId(categoryId);
			request.setAttribute("reserves", cvo);
			
		}

		String page = "reservation/booking";
		ViewResolve.forward(request, response, page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
