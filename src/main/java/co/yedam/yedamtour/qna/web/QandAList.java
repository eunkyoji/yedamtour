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

import co.yedam.yedamtour.common.Page;
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
		QandAVO vo = new QandAVO();
		
		String author = (String)session.getAttribute("author");
		
		vo = dao.qnaTotalCount(vo);
		int totalCount = vo.getTotalCount();
		
		int pageNum = 1;
		int amount = 10;
		
		String pNum = request.getParameter("pageNum");
		String aNum = request.getParameter("amount");
		System.out.println("pNum ::: " + pNum);
		if( pNum != null ) {
			pageNum = Integer.parseInt(pNum);
		}
		System.out.println("pageNum ::: " + pageNum);
		if( aNum != null ) {
			amount = Integer.parseInt(aNum);
		}
		
		Page pageVO = new Page(totalCount, pageNum, 10, 10);
		
		pageNum = (pageNum-1)*10;
		amount = pageNum + 10;
		
		vo.setStartPage(pageNum);
		vo.setEndPage(amount);
		
		qnalists = dao.qnaSelectList(vo);
		
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
		request.setAttribute("pageCount", pageVO);
		
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
