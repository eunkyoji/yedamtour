package co.yedam.yedamtour.transport.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		String currNum = request.getParameter("pageNum");
		int pageNum = 0;
		if( currNum != null ) {
			pageNum = Integer.parseInt(currNum);
		}
		
		int pageN = 0;
		int countList = 10; // 한 페이지에 보여줄 글 갯수
		int countPage = 10; // 페이지 갯수 ex ) [1] [2] [3] 다음
		
		int totalCount = vo.getTotalCount();
		
		int block = totalCount / countList ;
		if(totalCount % countList != 0){
			block++;
		}
		
		if (pageNum == 0) {
			pageN = 1;
		}else {
			pageN = pageNum;
			if(pageN <= 0 ) {
				pageN = 1;
			}
			if(pageN > block) {
				pageN -= 10;
			}
		}
		
		int startPage = (pageN-1) / countPage * countPage + 1; // 시작 페이지
		int endPage = startPage + countPage - 1; // 끝 페이지
		if (endPage > block) {
			endPage = block;
		}
		
		int start = pageN*10 - 9;
		int end = pageN*10;
		
		vo.setCategoryId(categoryId);
		vo.setStartPage(start);
		vo.setEndPage(end);
		
		list = dao.transportSelectList(vo);
		System.out.println(list.get(0).getTId());
		request.setAttribute("list", list);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		String page = "admin/manager/transportlist";
		ViewResolve.forward(request, response, page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
