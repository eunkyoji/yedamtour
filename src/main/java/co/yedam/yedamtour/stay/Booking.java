package co.yedam.yedamtour.stay;

import java.io.IOException;

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

	public Booking() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = session.getId();
		String hotelId = request.getParameter("hotelId");
		String hotelSubId = request.getParameter("hotelSubId");
		String pensionId = request.getParameter("pensionId");
		String pensionSubId = request.getParameter("pensionSubId");
		String campingId = request.getParameter("campingId");
		String campingSubId = request.getParameter("campingSubId");
		String categoryId = request.getParameter("categoryId");
		System.out.println(hotelId + "," + categoryId);

		MemberService mdao = new MemberServiceImpl();
		MemberVO mvo = new MemberVO();
		mvo.setMemberId(id);
		mvo = mdao.memberSelect(mvo);

		if (categoryId == "1") {
			HotelService hdao = new HotelServiceImpl();
			HotelVO hvo = new HotelVO();
			hvo.setHotelId(Integer.parseInt(hotelId));

			hvo.setHotelSubId(Integer.parseInt(hotelSubId));
			hvo = hdao.hotelRoomSelect(hvo);
			hvo.setMemberId(id);
			hvo.setMemberName(hvo.getMemberName());
			hvo.setMemberPhone(hvo.getMemberPhone());
			hvo.setCategoryId(Integer.parseInt(categoryId));
			request.setAttribute("reserves", hvo);

			System.out.println(hvo);
			
		} else if (categoryId == "2") {
			PensionService pdao = new PensionServiceImpl();
			PensionVO pvo = new PensionVO();
			pvo.setMemberId(id);

			pvo.setPensionSubId(Integer.parseInt(pensionSubId));
			pvo = pdao.pensionRoomSelect(pvo);
			pvo.setMemberId(id);
			pvo.setMemberName(pvo.getMemberName());
			pvo.setMemberPhone(pvo.getMemberPhone());
			pvo.setCategoryId(Integer.parseInt(categoryId));
			request.setAttribute("reserves", pvo);
			
		} else if (categoryId == "3"){
			CampingService cdao = new CampingServiceImpl();
			CampingVO cvo = new CampingVO();
			cvo.setMemberId(id);

			cvo.setCampingSubId(Integer.parseInt(campingSubId));
			cvo = cdao.campingRoomSelect(cvo);
			cvo.setMemberId(id);
			cvo.setMemberName(cvo.getMemberName());
			cvo.setMemberPhone(cvo.getMemberPhone());
			cvo.setCategoryId(Integer.parseInt(categoryId));
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
