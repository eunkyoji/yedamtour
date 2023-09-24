package co.yedam.yedamtour.qna.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.yedamtour.common.ViewResolve;
import co.yedam.yedamtour.qna.service.QandAService;
import co.yedam.yedamtour.qna.service.QandAVO;
import co.yedam.yedamtour.qna.serviceImpl.QandAServiceImpl;

@WebServlet("/tourqnalist.do")
public class TourQandAList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TourQandAList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QandAService dao = new QandAServiceImpl();
		List<QandAVO> qnalists = new ArrayList<QandAVO>();
		
		qnalists = dao.qnaSelectList();
		System.out.println(qnalists.get(0).getQnaTitle());
		
		request.setAttribute("qnalists", qnalists);
		
		String page = "qna/qnalist";
		ViewResolve.forward(request, response, page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
