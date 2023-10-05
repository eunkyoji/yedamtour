package co.yedam.yedamtour.ticket.web;

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
import co.yedam.yedamtour.ticket.service.TicketService;
import co.yedam.yedamtour.ticket.service.TicketVO;
import co.yedam.yedamtour.ticket.serviceImpl.TicketServiceImpl;

@WebServlet("/ticketlist.do")
public class TicketList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TicketList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<TicketVO>	list = new ArrayList<TicketVO>();
		TicketService	 dao = new TicketServiceImpl();
		TicketVO		  vo = new TicketVO();
		
		String id = request.getParameter("categoryId");
		
		System.out.println("id:::: " + id);
		
		int categoryId = 0;
		if( !"".equals(id) && id != null ) {
			categoryId = Integer.valueOf(id);
		}
		
		vo = dao.ticketTotalCount(categoryId);
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
		
		vo.setCategoryId(categoryId);
		vo.setStartPage(pageNum + 1);
		vo.setEndPage(amount);
		
		list =  dao.ticketSelectList(vo);
		System.out.println("list.get[0] :: " + list.size());
		request.setAttribute("list", list);
		request.setAttribute("pageCount", pageVO);
		
		String page = "admin/manager/ticketlist";
		ViewResolve.forward(request, response, page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
