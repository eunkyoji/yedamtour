package co.yedam.yedamtour.freeboard.web;

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
import co.yedam.yedamtour.freeboard.service.FreeBoardService;
import co.yedam.yedamtour.freeboard.service.FreeBoardVO;
import co.yedam.yedamtour.freeboard.serviceImpl.FreeBoardServiceImpl;

@WebServlet("/freeboardlist.do")
public class FreeBoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FreeBoardList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		FreeBoardService dao = new FreeBoardServiceImpl();
		List<FreeBoardVO> lists = new ArrayList<FreeBoardVO>();
		FreeBoardVO vo = new FreeBoardVO();
		
		String author = (String)session.getAttribute("author");
		
		vo = dao.freeBoardTotalCount(vo);
		
		String currNum = request.getParameter("pageNum");
		int pageNum = 0;
		if( currNum != null ) {
			pageNum = Integer.parseInt(currNum);
		}
		
		int pageN = 0;
		int countList = 10; // 한 페이지에 보여줄 글 갯수
		int countPage = 10; // 페이지 갯수 ex ) [1] [2] [3] 다음
		
		int totalCount = vo.getTotalCount();
		
		int block = totalCount / countList ;
		if(totalCount % countList != 0){
			block++;
		}
		
		System.out.println("pageNum::: " + pageNum);
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
		
		lists = dao.freeBoardSelectList(vo);
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		
		for(int i = 0; i < lists.size(); i++ ) {
			if( lists.get(i).getFreeBoardUpdateDate() != null ) {
				String update = simpleDateFormat.format(lists.get(i).getFreeBoardUpdateDate());
				lists.get(i).setFreeBoardViewDate(update);
			} else {
				String wirteDate = simpleDateFormat.format(lists.get(i).getFreeBoardWriteDate());
				lists.get(i).setFreeBoardViewDate(wirteDate);
			}
		}
		
		request.setAttribute("list", lists);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		if( "Admin".equals(author) ) {
			String pagae = "admin/freeboard/freeboardlist";
			ViewResolve.forward(request, response, pagae);
		} else {
			String pagae = "freeboard/freeboardlist";
			ViewResolve.forward(request, response, pagae);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
