package co.yedam.yedamtour.qna.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.yedamtour.common.ViewResolve;
import co.yedam.yedamtour.qna.service.QandAService;
import co.yedam.yedamtour.qna.service.QandAVO;
import co.yedam.yedamtour.qna.serviceImpl.QandAServiceImpl;

@WebServlet("/qnadetail.do")
public class QnaDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QnaDetail() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QandAService dao = new QandAServiceImpl();
		QandAVO vo = new QandAVO();
		HttpSession session = request.getSession();
		String author = (String) session.getAttribute("author");
		
		vo.setQnaId(Integer.valueOf(request.getParameter("qnaId")));
		
		vo = dao.qnaSelect(vo);
		
		request.setAttribute("q", vo);
		
		if( "Admin".equals(author) ) {
			String page = "admin/qna/qnadetail";
			ViewResolve.forward(request, response, page);
		} else {
			String page = "qna/qnadetail";
			ViewResolve.forward(request, response, page);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
