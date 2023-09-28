package co.yedam.yedamtour.freeboard.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.yedamtour.common.AlertControl;
import co.yedam.yedamtour.freeboard.service.FreeBoardService;
import co.yedam.yedamtour.freeboard.service.FreeBoardVO;
import co.yedam.yedamtour.freeboard.serviceImpl.FreeBoardServiceImpl;

@WebServlet("/freeboarddelete.do")
public class FreeBoardDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FreeBoardDelete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FreeBoardService dao = new FreeBoardServiceImpl();
		FreeBoardVO vo = new FreeBoardVO();
		HttpSession session = request.getSession();
		
		String author = (String)session.getAttribute("author");
		
		vo.setFreeBoardId(Integer.valueOf(request.getParameter("freeBoardId")));
		
		if( author == "user" ) {
			vo.setFreeBoardWriter(session.getId());
		}
		int n = dao.freeBoardDelete(vo);
		
		if( n != 0 ) {
			AlertControl.alertAndGo(response, "삭제되었습니다.", "freeboardlist.do");
		} else {
			AlertControl.alertAndGo(response, "삭제가 실패 되었습니다.", "freeboardlist.do");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
