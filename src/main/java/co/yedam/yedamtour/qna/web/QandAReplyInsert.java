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

@WebServlet("/qnareplayinsert.do")
public class QandAReplyInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QandAReplyInsert() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QandAService dao = new QandAServiceImpl();
		QandAVO vo = new QandAVO();
		
		System.out.println("qnaId ::: " + request.getParameter("qnaReplay"));
		
		vo.setQnaId(Integer.valueOf(request.getParameter("qnaId")));
		vo.setQnaReplay(request.getParameter("qnaReplay"));
		vo.setQnaReplayWriter(request.getParameter("qnaReplayWriter"));
		
//		int n = dao.qnaReplayWrite(vo);
//		
//		if( n != 0 ) {
//			AlertControl.alertAndGo(response, "답변이 정상 등록 되었습니다.", "qnalist.do");
//		} else {
//			AlertControl.alertAndGo(response, "답변 등록이 실패 되었습니다.", "qnalist.do");
//		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
