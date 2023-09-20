package co.yedam.yedamtour.notice.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.yedamtour.common.ViewResolve;
import co.yedam.yedamtour.notice.service.NoticeService;
import co.yedam.yedamtour.notice.service.NoticeVO;
import co.yedam.yedamtour.notice.serviceImpl.NoticeServiceImpl;

@WebServlet("/noticedetail.do")
public class NoticeDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeDetails() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeService dao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		
		vo.setNoticeId(Integer.valueOf(request.getParameter("noticeId")));
		vo = dao.noticeSelect(vo);
		
		Date nowDate = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		
		if( vo.getNoticeUpdateDate() != null ) {
			String updateDate = simpleDateFormat.format(vo.getNoticeUpdateDate());
			vo.setNoticeViewDate(updateDate);
		} else {
			String writerDate = simpleDateFormat.format(vo.getNoticeWriteDate());
			vo.setNoticeViewDate(writerDate);
		}
		
		request.setAttribute("n", vo);
		
		String page = "admin/notice/noticedetail";
		ViewResolve.forward(request, response, page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
