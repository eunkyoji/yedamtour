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

@WebServlet("/qnadelete.do")
public class QandADelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QandADelete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QandAService dao = new QandAServiceImpl();
		QandAVO vo = new QandAVO();
		HttpSession session = request.getSession();
		
		String qnaWriter = request.getParameter("qnaWriter");
		String qnaId	 = request.getParameter("qnaId");
		
		String author	= (String) session.getAttribute("author");
		
		vo.setQnaId(Integer.valueOf(qnaId));
		if( !"Admin".equals(author) ) {
			vo.setQnaWriter(qnaWriter);
		}
		int n = dao.qnaDelete(vo);
		
		if( n != 0 ) {
			AlertControl.alertAndGo(response, "삭제가 완료되었습니다.", "qnalist.do");
		} else {
			AlertControl.alertAndGo(response, "삭제를 실패하였습니다.", "qnalist.do");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
