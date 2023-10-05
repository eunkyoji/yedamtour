package co.yedam.yedamtour.transport.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.yedamtour.common.Page;
import co.yedam.yedamtour.common.ViewResolve;
import co.yedam.yedamtour.transport.service.TransportService;
import co.yedam.yedamtour.transport.service.TransportVO;
import co.yedam.yedamtour.transport.serviceImpl.TransportServiceImpl;

@WebServlet("/transportlist.do")
public class TransportList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TransportList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<TransportVO>	list = new ArrayList<TransportVO>();
		TransportService	 dao = new TransportServiceImpl();
		TransportVO			  vo = new TransportVO();
		
		String id = request.getParameter("categoryId");
		int categoryId = 0;
		if( !"".equals(id) && id != null ) {
			categoryId = Integer.parseInt(id);
		}
		
		vo.setCategoryId(categoryId);
		vo = dao.transportTotalCount(vo);
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
		System.out.println("pageNum::: " + pageNum);
		pageNum = (pageNum-1)*10;
		amount = pageNum + 10;
		
		vo.setCategoryId(categoryId);
		vo.setStartPage(pageNum);
		vo.setEndPage(amount);
		
		list = dao.transportSelectList(vo);
		
		request.setAttribute("list", list);
		request.setAttribute("pageCount", pageVO);
		
		String page = "admin/manager/transportlist";
		ViewResolve.forward(request, response, page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
