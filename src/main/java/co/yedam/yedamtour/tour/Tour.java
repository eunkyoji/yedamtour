package co.yedam.yedamtour.tour;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.yedamtour.camping.service.CampingService;
import co.yedam.yedamtour.camping.service.CampingVO;
import co.yedam.yedamtour.camping.serviceImpl.CampingServiceImpl;
import co.yedam.yedamtour.common.ViewResolve;
import co.yedam.yedamtour.hotel.service.HotelService;
import co.yedam.yedamtour.hotel.service.HotelVO;
import co.yedam.yedamtour.hotel.serviceImpl.HotelServiceImpl;
import co.yedam.yedamtour.pension.service.PensionService;
import co.yedam.yedamtour.pension.service.PensionVO;
import co.yedam.yedamtour.pension.serviceImpl.PensionServiceImpl;

@WebServlet("/tour.do")
public class Tour extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Tour() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HotelService hdao = new HotelServiceImpl();
		HotelVO hvo = new HotelVO();
		hvo.setHotelId(6);
		hvo = hdao.hotelSelect(hvo);		
		request.setAttribute("hotels", hvo);		
		
		PensionService pdao = new PensionServiceImpl();
		PensionVO pvo = new PensionVO();
		pvo.setPensionId(3);
		pvo = pdao.pensionSelect(pvo);		
		request.setAttribute("pensions", pvo);
		
		CampingService cdao = new CampingServiceImpl();
		CampingVO cvo = new CampingVO();
		cvo.setCampingId(2);
		cvo = cdao.campingSelect(cvo);		
		request.setAttribute("campings", cvo);		
		
		String page = "tour/tour";
		ViewResolve.forward(request, response, page);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
