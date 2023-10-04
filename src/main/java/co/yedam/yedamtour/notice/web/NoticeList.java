package co.yedam.yedamtour.notice.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.yedamtour.common.ViewResolve;
import co.yedam.yedamtour.member.service.MemberService;
import co.yedam.yedamtour.member.service.MemberVO;
import co.yedam.yedamtour.notice.service.NoticeService;
import co.yedam.yedamtour.notice.service.NoticeVO;
import co.yedam.yedamtour.notice.serviceImpl.NoticeServiceImpl;

@WebServlet("/noticelist.do")
public class NoticeList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		NoticeService dao = new NoticeServiceImpl();
		List<NoticeVO> notices = new ArrayList<NoticeVO>();
		NoticeVO vo = new NoticeVO();
		
		String author = (String)session.getAttribute("author");
		//vo.setNoticeSearch("noticeSearch");
		vo = dao.noticeTotalCount(vo);
		
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
		
		notices = dao.noticeSelectList(vo);
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		
		for( int i = 0; i < notices.size(); i++ ) {
			if( notices.get(i).getNoticeUpdateDate() != null ) {
				String updateDate = simpleDateFormat.format(notices.get(i).getNoticeUpdateDate());
				notices.get(i).setNoticeViewDate(updateDate);
			} else {
				String writerDate = simpleDateFormat.format(notices.get(i).getNoticeWriteDate());
				notices.get(i).setNoticeViewDate(writerDate);
			}
		}
		
		request.setAttribute("notices", notices);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		if( "Admin".equals(author) ) {
			String page = "admin/notice/noticelist";
			ViewResolve.forward(request, response, page);
		} else {
			String page = "notice/noticelist";
			ViewResolve.forward(request, response, page);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
