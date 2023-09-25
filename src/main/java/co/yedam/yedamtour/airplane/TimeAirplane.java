package co.yedam.yedamtour.airplane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.yedamtour.airplane.service.AirplaneService;
import co.yedam.yedamtour.airplane.service.AirplaneVO;
import co.yedam.yedamtour.airplane.serviceImpl.AirplaneServiceImpl;
import co.yedam.yedamtour.common.ViewResolve;

@WebServlet("/timeairplane.do")
public class TimeAirplane extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TimeAirplane() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AirplaneService dao = new AirplaneServiceImpl();
		List<AirplaneVO> airplanes = new ArrayList<AirplaneVO>();
		String start = request.getParameter("start");  //출발지
		String finish = request.getParameter("finish");  //도착지
		String startDate = request.getParameter("startDate");  //출발일자
		String finishDate = request.getParameter("finishDate"); //도착일자
		String person = request.getParameter("person");

		AirplaneVO vo = new AirplaneVO();
		vo.setAirplaneStart(start);
		vo.setAirplaneFinish(finish);
		
		airplanes = dao.airplaneSelectList(vo);
		
		if(airplanes != null) {
			request.setAttribute("person", person);
			request.setAttribute("airplanes", airplanes);
			request.setAttribute("startDate", startDate);
			request.setAttribute("finishDate", finishDate);
		}
		
		String page = "transportation/timeairplane";
		ViewResolve.forward(request, response, page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
