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

@WebServlet("/qnamodifyform.do")
public class QandAModifyForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QandAModifyForm() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QandAService dao = new QandAServiceImpl();
		QandAVO vo = new QandAVO();
		HttpSession session = request.getSession();
		
		String author = (String)session.getAttribute("author");
		System.out.println("qnaId === " + request.getParameter("qnaId"));
		vo.setQnaId(Integer.valueOf(request.getParameter("qnaId")));
		
		vo = dao.qnaSelect(vo);
		System.out.println(vo.getQnaTitle());
		request.setAttribute("q", vo);
		
		if( author.equals("Admin") ) {
			String page = "admin/qna/qnamodifyform";
			ViewResolve.forward(request, response, page);
		} else {
			String page = "qna/qnamodifyform";
			ViewResolve.forward(request, response, page);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
