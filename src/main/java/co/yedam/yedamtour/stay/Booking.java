package co.yedam.yedamtour.stay;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

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
		ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
		
		String hotelId = request.getParameter("hotelId");
		String hotelSubId = request.getParameter("hotelSubId");
		String pensionId = request.getParameter("pensionId");
		String pensionSubId = request.getParameter("pensionSubId");
		String campingId = request.getParameter("campingId");
		String campingSubId = request.getParameter("campingSubId");
		String categoryId = request.getParameter("categoryId");
		
		MemberService mdao = new MemberServiceImpl();
		MemberVO mvo = new MemberVO();
		
		mvo.setMemberId(request.getParameter("memberId"));
		mvo = mdao.signupIdSelect(mvo);
		
		String json = null;
		
		if (categoryId.equals("1")) {
			HotelService hdao = new HotelServiceImpl();
			HotelVO hvo = new HotelVO();
			
			hvo.setHotelId(Integer.parseInt(hotelId));
			hvo.setHotelSubId(Integer.parseInt(hotelSubId));
			hvo = hdao.hotelRoomSelect(hvo);
			
			hvo.setMemberId(mvo.getMemberId());
			hvo.setMemberName(mvo.getMemberName());
			hvo.setMemberPhone(mvo.getMemberPhone());
			hvo.setCategoryId(categoryId);
			
			request.setAttribute("reserves", hvo);
			json = objectMapper.writeValueAsString(hvo);

			System.out.println(hvo);
			
		} else if (categoryId.equals("2")) {
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
			json = objectMapper.writeValueAsString(pvo);
			
		} else if (categoryId.equals("3")){
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
			json = objectMapper.writeValueAsString(cvo);
			
		}
		
		response.setContentType("text/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
		
		String page = "reservation/booking";
		ViewResolve.forward(request, response, page);	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
