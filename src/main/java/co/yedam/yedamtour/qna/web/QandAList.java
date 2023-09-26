package co.yedam.yedamtour.qna.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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

@WebServlet("/qnalist.do")
public class QandAList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QandAList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QandAService dao = new QandAServiceImpl();
		List<QandAVO> qnalists = new ArrayList<QandAVO>();
		HttpSession session = request.getSession();
		
		String author = (String)session.getAttribute("author");
		
		qnalists = dao.qnaSelectList();
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		
		for( int i = 0; i < qnalists.size(); i++ ) {
			if( qnalists.get(i).getQnaUpdateDate() != null ) {
				String updateDate = simpleDateFormat.format(qnalists.get(i).getQnaUpdateDate());
				qnalists.get(i).setQnaViewDate(updateDate);;
			} else {
				String writerDate = simpleDateFormat.format(qnalists.get(i).getQnaWriteDate());
				qnalists.get(i).setQnaViewDate(writerDate);
			}
		}
		
		request.setAttribute("qnalists", qnalists);
		
		if( "Admin".equals(author) ) {
			String page = "admin/qna/qnalist";
			ViewResolve.forward(request, response, page);
		} else {
			String page = "qna/qnalist";
			ViewResolve.forward(request, response, page);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
