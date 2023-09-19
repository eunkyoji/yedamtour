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

@WebServlet("/staymain.do")
public class StayMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StayMain() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HotelService dao = new HotelServiceImpl();
		List<HotelVO> hotels = new ArrayList<HotelVO>();
		
		hotels = dao.hotelSelectList();
		request.setAttribute("hotels", hotels);
		
		String page = "staymain/staymain";
		ViewResolve.forward(request, response, page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
