package co.yedam.yedamtour.bus;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.yedamtour.bus.service.BusService;
import co.yedam.yedamtour.bus.service.BusVO;
import co.yedam.yedamtour.bus.serviceImpl.BusServiceImpl;
import co.yedam.yedamtour.common.ViewResolve;

@WebServlet("/resultbus.do")
public class ResultBus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ResultBus() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BusService dao = new BusServiceImpl();
		BusVO startvo = new BusVO();
		BusVO finishvo = new BusVO();
		
		String startDate = request.getParameter("startDate");
		String finishDate = request.getParameter("finishDate");
		int person = Integer.valueOf(request.getParameter("person"));
		
		int direction = Integer.valueOf(request.getParameter("direction"));
		int direction1 = Integer.valueOf(request.getParameter("direction1"));
		
		startvo.setBusId(direction);
		startvo = dao.busSelect(startvo);
		if(startvo != null) {
			request.setAttribute("startBus", startvo);
		}
		
		finishvo.setBusId(direction1);
		finishvo = dao.busSelect(finishvo);
		if(finishvo != null) {
			request.setAttribute("finishBus", finishvo);
		}
		
		int startPrice = startvo.getBusPrice()*person;
		int finishPrice = finishvo.getBusPrice()*person;
		
		request.setAttribute("startDate", startDate);
		request.setAttribute("finishDate", finishDate);
		request.setAttribute("person", person);
		request.setAttribute("startPrice", startPrice);
		request.setAttribute("finishPrice", finishPrice);
		
		String totalPrice = startPrice + finishPrice + "";
		
		String page = "transportation/resultbus";
		ViewResolve.forward(request, response, page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
