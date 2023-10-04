package co.yedam.yedamtour.member.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.yedamtour.common.ViewResolve;
import co.yedam.yedamtour.member.Impl.MemberServiceImpl;
import co.yedam.yedamtour.member.service.MemberService;
import co.yedam.yedamtour.member.service.MemberVO;
import co.yedam.yedamtour.reservation.service.ReservationService;
import co.yedam.yedamtour.reservation.service.ReservationVO;
import co.yedam.yedamtour.reservation.serviceImpl.ReservationServiceImpl;

@WebServlet("/membermypage.do")
public class MemberMyPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberMyPage() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		String pw = (String) session.getAttribute("password");
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();

		ReservationService rdao = new ReservationServiceImpl();
		ReservationVO rvo = new ReservationVO();
		List<ReservationVO> rvoList = new ArrayList<>();

		rvo.setReservationWriterId(id);
		rvoList = rdao.reservationCartSelectList(rvo);

		request.setAttribute("rvo", rvoList);

		ReservationVO rvo2 = new ReservationVO();
		List<ReservationVO> rvoList2 = new ArrayList<>();

		rvo2.setReservationWriterId(id);
		rvoList2 = rdao.reservationCartFinishSelectList(rvo2);

		request.setAttribute("rvo2", rvoList2);

		vo.setMemberId(id);
		vo.setMemberPassword(pw);
		vo = dao.memberSelect(vo);

		request.setAttribute("list", vo);

		String page = "member/membermypage.jsp";
		ViewResolve.forward(request, response, page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
