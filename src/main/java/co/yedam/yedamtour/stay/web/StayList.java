package co.yedam.yedamtour.stay.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		String cid = request.getParameter("categoryId");
		int categoryId = 0;
		if( cid != null ) {
			categoryId = Integer.valueOf(cid);
		}
		
		vo = dao.stayTotalCount(categoryId);
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
		
		System.out.println("pageNum::: " + pageNum);
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
		
		vo.setStartPage(start);
		vo.setEndPage(end);
		
		list = dao.staySelectList(categoryId);
		
		request.setAttribute("list", list);
		
		String page = "admin/manager/staylist";
		ViewResolve.forward(request, response, page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
