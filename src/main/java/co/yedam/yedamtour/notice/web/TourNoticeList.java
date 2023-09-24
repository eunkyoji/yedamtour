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

import co.yedam.yedamtour.common.ViewResolve;
import co.yedam.yedamtour.notice.service.NoticeService;
import co.yedam.yedamtour.notice.service.NoticeVO;
import co.yedam.yedamtour.notice.serviceImpl.NoticeServiceImpl;

@WebServlet("/tournoticelist.do")
public class TourNoticeList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TourNoticeList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeService dao = new NoticeServiceImpl();
		List<NoticeVO> notices = new ArrayList<NoticeVO>();
		
		notices = dao.noticeSelectList();
		
		Date nowDate = new Date();
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
		
		String page = "notice/noticelist";
		ViewResolve.forward(request, response, page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
