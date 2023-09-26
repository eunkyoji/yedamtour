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

import co.yedam.yedamtour.hotel.service.HotelService;
import co.yedam.yedamtour.hotel.service.HotelVO;
import co.yedam.yedamtour.hotel.serviceImpl.HotelServiceImpl;

@WebServlet("/hotelsublist.do")
public class HotelSubList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HotelSubList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HotelService dao = new HotelServiceImpl();
		List<HotelVO> list = new ArrayList<HotelVO>();
		ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
		
		String hotelId = request.getParameter("hotelId");
		
		list = dao.hotelDetailSelectList(Integer.parseInt(hotelId));
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
