package co.yedam.yedamtour.train;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.yedamtour.common.ViewResolve;
import co.yedam.yedamtour.train.service.TrainService;
import co.yedam.yedamtour.train.service.TrainVO;
import co.yedam.yedamtour.train.serviceImpl.TrainServiceImpl;

@WebServlet("/resulttrain.do")
public class ResultTrain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ResultTrain() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TrainService dao = new TrainServiceImpl();
		TrainVO startvo = new TrainVO();
		TrainVO finishvo = new TrainVO();
		
		String startDate = request.getParameter("startDate");
		String finishDate = request.getParameter("finishDate");
		int person = Integer.valueOf(request.getParameter("person"));
		
		int direction = Integer.valueOf(request.getParameter("direction"));
		int direction1 = Integer.valueOf(request.getParameter("direction1"));
		
		startvo.setTrainId(direction);
		startvo = dao.trainSelect(startvo);
		if(startvo != null) {
			request.setAttribute("startTrain", startvo);
		}
		
		finishvo.setTrainId(direction1);
		finishvo = dao.trainSelect(finishvo);
		if(finishvo != null) {
			request.setAttribute("finishTrain", finishvo);
		}
		
		int startPrice = startvo.getTrainPrice()*person;
		int finishPrice = finishvo.getTrainPrice()*person;
		
		request.setAttribute("startDate", startDate);
		request.setAttribute("finishDate", finishDate);
		request.setAttribute("person", person);
		request.setAttribute("startPrice", startPrice);
		request.setAttribute("finishPrice", finishPrice);
		
		String page = "transportation/resulttrain";
		ViewResolve.forward(request, response, page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
