package co.yedam.yedamtour.qna.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.yedamtour.common.AlertControl;
import co.yedam.yedamtour.qna.service.QandAService;
import co.yedam.yedamtour.qna.service.QandAVO;
import co.yedam.yedamtour.qna.serviceImpl.QandAServiceImpl;

@WebServlet("/qnawrite.do")
public class QandAWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QandAWrite() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QandAService dao = new QandAServiceImpl();
		QandAVO vo = new QandAVO();
		HttpSession session = request.getSession();
		
		vo.setQnaTitle(request.getParameter("qnaTitle"));
		vo.setQnaContent(request.getParameter("qnaContent"));
		vo.setQnaWriter(request.getParameter("qnaWriter"));
		
		int n = dao.qnaInsert(vo);
		if( n != 0 ) {
			AlertControl.alertAndGo(response, "Q&A가 등록되었습니다.", "qnalist.do");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

