package co.yedam.yedamtour.bus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.yedamtour.bus.service.BusService;
import co.yedam.yedamtour.bus.service.BusVO;
import co.yedam.yedamtour.bus.serviceImpl.BusServiceImpl;
import co.yedam.yedamtour.common.ViewResolve;

@WebServlet("/timebus.do")
public class TimeBus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TimeBus() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// service
		BusService dao = new BusServiceImpl();
		List<BusVO> buses = new ArrayList<BusVO>();
		String start = request.getParameter("start");
		String finish = request.getParameter("finish");
		String startDate = request.getParameter("startDate");
		String finishDate = request.getParameter("finishDate");
		String person = request.getParameter("person");

		BusVO vo = new BusVO();
		vo.setBusStart(start);
		vo.setBusFinish(finish);
		
		buses = dao.busSelectList(vo);
		
		if(buses != null) {
			request.setAttribute("person", person);
			request.setAttribute("buses", buses);	
			request.setAttribute("startDate", startDate);
			request.setAttribute("finishDate", finishDate);
		}
		
		String page = "transportation/timebus";
		ViewResolve.forward(request, response, page);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
