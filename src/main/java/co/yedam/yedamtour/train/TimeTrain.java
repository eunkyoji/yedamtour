package co.yedam.yedamtour.train;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.yedamtour.common.ViewResolve;
import co.yedam.yedamtour.train.service.TrainService;
import co.yedam.yedamtour.train.service.TrainVO;
import co.yedam.yedamtour.train.serviceImpl.TrainServiceImpl;

@WebServlet("/timetrain.do")
public class TimeTrain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TimeTrain() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TrainService dao = new TrainServiceImpl();
		List<TrainVO> trains = new ArrayList<TrainVO>();
		String start = request.getParameter("start");
		String finish = request.getParameter("finish");
		String startDate = request.getParameter("startDate");
		String finishDate = request.getParameter("finishDate");
		String person = request.getParameter("person");
		
		TrainVO vo = new TrainVO();
		vo.setTrainStart(start);
		vo.setTrainFinish(finish);
		
		trains = dao.trainSelectList(vo);
		
		if(trains != null) {
			request.setAttribute("person", person);
			request.setAttribute("trains", trains);
			request.setAttribute("startDate", startDate);
			request.setAttribute("finishDate", finishDate);
		}
		
		String page = "transportation/timetrain";
		ViewResolve.forward(request, response, page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
