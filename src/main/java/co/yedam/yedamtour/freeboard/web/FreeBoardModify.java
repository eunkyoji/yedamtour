package co.yedam.yedamtour.freeboard.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.yedamtour.common.ViewResolve;
import co.yedam.yedamtour.freeboard.service.FreeBoardService;
import co.yedam.yedamtour.freeboard.service.FreeBoardVO;
import co.yedam.yedamtour.freeboard.serviceImpl.FreeBoardServiceImpl;

@WebServlet("/freeboardmodify.do")
public class FreeBoardModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FreeBoardModify() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FreeBoardService dao = new FreeBoardServiceImpl();
		FreeBoardVO vo = new FreeBoardVO();
		
		vo.setFreeBoardId(Integer.valueOf(request.getParameter("freeBoardId")));
		
		vo = dao.freeBoardSelect(vo);
		
		request.setAttribute("f", vo);
		
		String page = "admin/freeboard/freeboardmodify";
		ViewResolve.forward(request, response, page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
