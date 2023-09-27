package co.yedam.yedamtour.stay;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.yedamtour.common.ViewResolve;
import co.yedam.yedamtour.hotel.service.HotelService;
import co.yedam.yedamtour.hotel.service.HotelVO;
import co.yedam.yedamtour.hotel.serviceImpl.HotelServiceImpl;

@WebServlet("/hoteldetail.do")
public class HotelDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HotelDetail() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HotelService dao = new HotelServiceImpl();
		HotelVO vo = new HotelVO();
		
		int id = Integer.valueOf(request.getParameter("hotelId"));
		
		vo.setHotelId(id);
		vo = dao.hotelSelect(vo);
		
		request.setAttribute("hotels", vo);
		
		String page = "hotel/hoteldetail";
		ViewResolve.forward(request, response, page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
