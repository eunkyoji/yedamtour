package co.yedam.yedamtour.stay.web;

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
import co.yedam.yedamtour.stay.service.StayService;
import co.yedam.yedamtour.stay.service.StayVO;
import co.yedam.yedamtour.stay.serviceImpl.StayServiceImpl;

@WebServlet("/staylist.do")
public class StayList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StayList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<StayVO>	list = new ArrayList<StayVO>();
		StayService		 dao = new StayServiceImpl();
		StayVO			  vo = new StayVO();
		System.out.println("1111111111111111111");
		
		String id = request.getParameter("categoryId");
		
		System.out.println("id:::: " + id);
		
		int categoryId = 0;
		if( !"".equals(id) && id != null ) {
			categoryId = Integer.valueOf(id);
		}
		
		vo = dao.stayTotalCount(categoryId);
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
		
		list = dao.staySelectList(vo);
		System.out.println(list.get(0).getStayImg());
		request.setAttribute("list", list);
		request.setAttribute("pageCount", pageVO);
		request.setAttribute("categoryId", id);
		
		String page = "admin/manager/staylist";
		ViewResolve.forward(request, response, page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
