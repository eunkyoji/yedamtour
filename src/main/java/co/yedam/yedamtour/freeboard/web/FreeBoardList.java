package co.yedam.yedamtour.freeboard.web;

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
import co.yedam.yedamtour.freeboard.service.FreeBoardService;
import co.yedam.yedamtour.freeboard.service.FreeBoardVO;
import co.yedam.yedamtour.freeboard.serviceImpl.FreeBoardServiceImpl;
import co.yedam.yedamtour.notice.service.NoticeVO;

@WebServlet("/freeboardlist.do")
public class FreeBoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FreeBoardList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FreeBoardService dao = new FreeBoardServiceImpl();
		List<FreeBoardVO> lists = new ArrayList<FreeBoardVO>();
		
		lists = dao.freeBoardSelectList();
		
//		Date nowDate = new Date();
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
//		
//		for(int i = 0; i < lists.size(); i++ ) {
//			if( lists.get(i).getFreeBoardUpdateDate() != null ) {
//				String update = simpleDateFormat.format(lists.get(i).getFreeBoardUpdateDate());
//				lists.get(i).setFreeBoardViewDate(update);
//			} else {
//				String wirteDate = simpleDateFormat.format(lists.get(i).getFreeBoardWriterDate());
//				lists.get(i).setFreeBoardViewDate(wirteDate);
//			}
//		}
//		
		request.setAttribute("list", lists);
		
		String pagae = "admin/freeboard/freeboardlist";
		ViewResolve.forward(request, response, pagae);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
