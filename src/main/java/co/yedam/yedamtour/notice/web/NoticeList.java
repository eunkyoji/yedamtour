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

import co.yedam.yedamtour.common.Page;
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
		request.setAttribute("pageCount", pageVO);
		
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
