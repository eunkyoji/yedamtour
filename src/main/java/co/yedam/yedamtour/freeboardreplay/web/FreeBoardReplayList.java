package co.yedam.yedamtour.freeboardreplay.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import co.yedam.yedamtour.freeboardreplay.service.FreeBoardReplayService;
import co.yedam.yedamtour.freeboardreplay.service.FreeBoardReplayVO;
import co.yedam.yedamtour.freeboardreplay.serviceImpl.FreeBoardReplayServiceImpl;

@WebServlet("/freeboardreplaylist.do")
public class FreeBoardReplayList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FreeBoardReplayList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FreeBoardReplayService dao = new FreeBoardReplayServiceImpl();
		List<FreeBoardReplayVO> replays = new ArrayList<FreeBoardReplayVO>();
		ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
		
		int freeBoardId = Integer.valueOf(request.getParameter("freeBoardId"));
		
		replays = dao.freeBoardReplaySelectLsit(freeBoardId);
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		for(int i = 0; i < replays.size(); i++ ) {
			if( replays.get(i).getReplayUpdateDate() != null ) {
				String update = simpleDateFormat.format(replays.get(i).getReplayUpdateDate());
				replays.get(i).setReplayViewDate(update);
			} else {
				String wirteDate = simpleDateFormat.format(replays.get(i).getReplayWriteDate());
				replays.get(i).setReplayViewDate(wirteDate);
			}
		}
		
		String json = objectMapper.writeValueAsString(replays);
		
		response.setContentType("text/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
