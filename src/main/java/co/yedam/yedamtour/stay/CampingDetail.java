package co.yedam.yedamtour.stay;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.yedamtour.camping.service.CampingService;
import co.yedam.yedamtour.camping.service.CampingVO;
import co.yedam.yedamtour.camping.serviceImpl.CampingServiceImpl;
import co.yedam.yedamtour.common.ViewResolve;

@WebServlet("/campingdetail.do")
public class CampingDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CampingDetail() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CampingService dao = new CampingServiceImpl();
		List<CampingVO> campings = new ArrayList<CampingVO>();
		CampingVO vo = new CampingVO();
		
		int id = Integer.valueOf(request.getParameter("campingId"));
		vo.setCampingId(id);
		vo = dao.campingSelect(vo);
		request.setAttribute("campings", vo);
		
		String page = "camping/campingdetail";
		ViewResolve.forward(request, response, page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
