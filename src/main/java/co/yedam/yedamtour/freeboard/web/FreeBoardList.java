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
		
		String author = (String)session.getAttribute("author");
		
		lists = dao.freeBoardSelectList();
		
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
