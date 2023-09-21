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

@WebServlet("/freeboardlist.do")
public class FreeBoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FreeBoardList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FreeBoardService dao = new FreeBoardServiceImpl();
		List<FreeBoardVO> list = new ArrayList<FreeBoardVO>();
		
		list = dao.freeBoardSelectList();
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		
		for( int i = 0; i < list.size(); i++ ) {
			if( list.get(i).getFreeBoardUpdateDate() != null ) {
				String updateDate = simpleDateFormat.format(list.get(i).getFreeBoardUpdateDate());
				list.get(i).setFreeBoardViewDate(updateDate);
			} else {
				String writerDate = simpleDateFormat.format(list.get(i).getFreeBoardWriterDate());
				list.get(i).setFreeBoardViewDate(writerDate);
			}
		}
		
		request.setAttribute("list", list);
		
		String pagae = "admin/freeboard/freeboardlist";
		ViewResolve.forward(request, response, pagae);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
