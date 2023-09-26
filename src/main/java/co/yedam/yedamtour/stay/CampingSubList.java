package co.yedam.yedamtour.stay;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import co.yedam.yedamtour.camping.service.CampingService;
import co.yedam.yedamtour.camping.service.CampingVO;
import co.yedam.yedamtour.camping.serviceImpl.CampingServiceImpl;

@WebServlet("/campingsublist.do")
public class CampingSubList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CampingSubList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CampingService dao = new CampingServiceImpl();
		List<CampingVO> list = new ArrayList<CampingVO>();
		ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
		
		String campingId = request.getParameter("campingId");
		
		list = dao.campingDetailSelectList(Integer.parseInt(campingId));
		System.out.println(list.size() + "==========");
		String json = objectMapper.writeValueAsString(list);
		
		response.setContentType("text/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
