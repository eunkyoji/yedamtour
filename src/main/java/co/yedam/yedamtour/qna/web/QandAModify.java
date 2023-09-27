package co.yedam.yedamtour.qna.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.yedamtour.common.AlertControl;
import co.yedam.yedamtour.qna.service.QandAService;
import co.yedam.yedamtour.qna.service.QandAVO;
import co.yedam.yedamtour.qna.serviceImpl.QandAServiceImpl;

@WebServlet("/qnamodify.do")
public class QandAModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QandAModify() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QandAService dao = new QandAServiceImpl();
		QandAVO vo = new QandAVO();
		
		vo.setQnaTitle(request.getParameter("qnaTitle"));
		vo.setQnaContent(request.getParameter("qnaContent"));
		vo.setQnaId(Integer.valueOf(request.getParameter("qnaId")));
		
		int n = dao.qnaUpdate(vo);
		
		if( n != 0 ) {
			AlertControl.alertAndGo(response, "수정이 완료되었습니다.", "qnalist.do");
		} else {
			AlertControl.alertAndGo(response, "수정이 실패되었습니다.", "qnalist.do");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
