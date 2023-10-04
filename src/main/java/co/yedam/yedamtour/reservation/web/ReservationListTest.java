package co.yedam.yedamtour.reservation.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.yedamtour.category.Impl.CategoryServiceImpl;
import co.yedam.yedamtour.category.service.CategoryService;
import co.yedam.yedamtour.category.service.CategoryVO;
import co.yedam.yedamtour.reservation.service.ReservationService;
import co.yedam.yedamtour.reservation.service.ReservationVO;
import co.yedam.yedamtour.reservation.serviceImpl.ReservationServiceImpl;
import co.yedam.yedamtour.ticket.service.AquariumService;
import co.yedam.yedamtour.ticket.service.AquariumVO;
import co.yedam.yedamtour.ticket.service.ThemeparkService;
import co.yedam.yedamtour.ticket.service.ThemeparkVO;
import co.yedam.yedamtour.ticket.service.WaterparkService;
import co.yedam.yedamtour.ticket.service.WaterparkVO;
import co.yedam.yedamtour.ticket.serviceImpl.AquariumServiceImpl;
import co.yedam.yedamtour.ticket.serviceImpl.ThemeparkServiceImpl;
import co.yedam.yedamtour.ticket.serviceImpl.WaterparkServiceImpl;

@WebServlet("/reservationlisttest.do")
public class ReservationListTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReservationListTest() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		예약번호 티켓아이디 예약자수(티켓수) 예약자아이디 가격(총) 카테고리아이디

		// 리스트
		ReservationService reservationDao = new ReservationServiceImpl();
		ReservationVO reservationVo = new ReservationVO();
		// 카테고리
		CategoryService categoryDao = new CategoryServiceImpl();
		CategoryVO categoryVo = new CategoryVO();
		// 테마파크
		ThemeparkService themeparkDao = new ThemeparkServiceImpl();
		ThemeparkVO themeparkVo = new ThemeparkVO();
		// 아쿠아리움
		AquariumService aquariumDao = new AquariumServiceImpl();
		AquariumVO aquariumVo = new AquariumVO();
		// 워터파크
		WaterparkService waterparkDao = new WaterparkServiceImpl();
		WaterparkVO waterparkVo = new WaterparkVO();
		// 세션아이디
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("id");

		int tid = Integer.parseInt(request.getParameter("tid"));
		int cnt = Integer.parseInt(request.getParameter("cnt"));
		// 테마파크 조회 22
		themeparkVo.setThemeparkId(tid);
		themeparkVo.setThemeparkName(request.getParameter("tname"));
		themeparkVo = themeparkDao.themeparkCartSelect(themeparkVo); // 맞는 name과 id가 있으면 조회값가지고 옴
		// 아쿠아리움 조회 21
		aquariumVo.setAquariumId(tid);
		aquariumVo.setAquariumName(request.getParameter("aname"));
		aquariumVo = aquariumDao.aquariumCartSelect(aquariumVo);

		// 워터파크조회23
		waterparkVo.setWaterparkId(tid);
		waterparkVo.setWaterparkName(request.getParameter("wname"));
		waterparkVo = waterparkDao.waterparkCartSelect(waterparkVo);

		System.out.println("테마파크 = " + themeparkVo);
		System.out.println("아쿠아리움 = " + aquariumVo);
		System.out.println("아쿠아리움 = " + waterparkVo);
		//세션 아이디가 없으면 장바구니 안담기게 하기
		if(session.getId()!=null) {
		
		if (themeparkVo != null) {

			System.out.println("cnt값 =" + cnt);
			String cname = "테마파크";

			String price = (themeparkVo.getThemeparkPrice() * cnt) + "";

			categoryVo.setCategoryName(cname);

			categoryVo = categoryDao.categorySelect(categoryVo);

			String cId = categoryVo.getCategoryId();
			
			String pName = themeparkVo.getThemeparkName();
			
			String companyEmail = themeparkVo.getCompanyEmail();
			System.out.println(companyEmail);

			// db에 값입력
			reservationVo.setTicketId(tid);
			reservationVo.setReservationPersonnel(cnt);
			reservationVo.setReservationWriterId(userId);
			reservationVo.setReservationPrice(price);
			reservationVo.setCategoryId(cId);
			reservationVo.setProductName(pName);
			reservationVo.setCompanyEmail(companyEmail);

			
			int result = reservationDao.reservationTicketInsert(reservationVo);
			System.out.println("테마파크"+result);
			System.out.println(reservationVo.getReservationWriterId());
		}

		if (aquariumVo != null) {

			System.out.println("cnt값 =" + cnt);
			String cname = "아쿠아리움";

			String price = (aquariumVo.getAquariumPrice() * cnt) + "";

			categoryVo.setCategoryName(cname);

			categoryVo = categoryDao.categorySelect(categoryVo);

			String cId = categoryVo.getCategoryId();

			String pName = aquariumVo.getAquariumName();
			String companyEmail = aquariumVo.getCompanyEmail();
			
			// db에 값입력
			reservationVo.setTicketId(tid);
			reservationVo.setReservationPersonnel(cnt);
			reservationVo.setReservationWriterId(userId);
			reservationVo.setReservationPrice(price);
			reservationVo.setCategoryId(cId);
			reservationVo.setProductName(pName);
			reservationVo.setCompanyEmail(companyEmail);
			
			
			int result = reservationDao.reservationTicketInsert(reservationVo);
			System.out.println("아쿠아리움"+result);
		}

		if (waterparkVo != null) {

			System.out.println("cnt값 =" + cnt);
			String cname = "워터파크";

			String price = (waterparkVo.getWaterparkPrice() * cnt) + "";

			categoryVo.setCategoryName(cname);

			categoryVo = categoryDao.categorySelect(categoryVo);

			String cId = categoryVo.getCategoryId();
			String pName = waterparkVo.getWaterparkName();
			String companyEmail = waterparkVo.getCompanyEmail();
			// db에 값입력
			reservationVo.setTicketId(tid);
			reservationVo.setReservationPersonnel(cnt);
			reservationVo.setReservationWriterId(userId);
			reservationVo.setReservationPrice(price);
			reservationVo.setCategoryId(cId);
			reservationVo.setProductName(pName);
			reservationVo.setCompanyEmail(companyEmail);
			

			int result = reservationDao.reservationTicketInsert(reservationVo);
			System.out.println("워터파크"+result);
		}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
