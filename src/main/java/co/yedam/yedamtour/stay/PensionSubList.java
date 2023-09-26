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

import co.yedam.yedamtour.pension.service.PensionService;
import co.yedam.yedamtour.pension.service.PensionVO;
import co.yedam.yedamtour.pension.serviceImpl.PensionServiceImpl;

@WebServlet("/pensionsublist.do")
public class PensionSubList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PensionSubList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PensionService dao = new PensionServiceImpl();
		List<PensionVO> list = new ArrayList<PensionVO>();
		ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
		
		String pensionId = request.getParameter("pensionId");
		
		list = dao.pensionDetailSelectList(Integer.parseInt(pensionId));
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
