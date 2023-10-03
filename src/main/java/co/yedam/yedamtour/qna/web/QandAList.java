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
		QandAVO vo = new QandAVO();
		
		String author = (String)session.getAttribute("author");
		System.out.println("111111111111111111111111");
		vo = dao.qnaTotalCount(vo);
		System.out.println(vo);
		String currNum = request.getParameter("pageNum");
		int pageNum = 0;
		if( currNum != null ) {
			pageNum = Integer.parseInt(currNum);
		}
		
		int pageN = 0;
		int countList = 10; // 한 페이지에 보여줄 글 갯수
		int countPage = 10; // 페이지 갯수 ex ) [1] [2] [3] 다음
		
		int totalCount = vo.getTotalCount();
		System.out.println("totalCount :: " + totalCount);
		int block = totalCount / countList ;
		if(totalCount % countList != 0){
			block++;
		}
		
		if (pageNum == 0) {
			pageN = 1;
		}else {
			pageN = pageNum;
			if(pageN <= 0 ) {
				pageN = 1;
			}
			if(pageN > block) {
				pageN -= 10;
			}
		}
		
		int startPage = (pageN-1) / countPage * countPage + 1; // 시작 페이지
		int endPage = startPage + countPage - 1; // 끝 페이지
		if (endPage > block) {
			endPage = block;
		}
		
		int start = pageN*10 - 9;
		int end = pageN*10;
		
		vo.setStartPage(start);
		vo.setEndPage(end);
		
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
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
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
