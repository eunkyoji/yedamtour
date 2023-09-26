package co.yedam.yedamtour.freeboard.web;

import java.io.IOException;
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

@WebServlet("/freeboardmodifyform.do")
public class FreeBoardModifyForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FreeBoardModifyForm() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FreeBoardService dao = new FreeBoardServiceImpl();
		FreeBoardVO vo = new FreeBoardVO();
		HttpSession session = request.getSession();
		
		String author = (String)session.getAttribute("author");
		
		vo.setFreeBoardId(Integer.valueOf(request.getParameter("freeBoardId")));
		
		vo = dao.freeBoardSelect(vo);
		
		request.setAttribute("f", vo);
		
		if( "Admin".equals(author) ) {
			String page = "admin/freeboard/freeboardmodifyform";
			ViewResolve.forward(request, response, page);
		} else {
			String page = "freeboard/freeboardmodifyform";
			ViewResolve.forward(request, response, page);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
