package co.yedam.yedamtour.freeboardreplay.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.yedam.yedamtour.common.AlertControl;
import co.yedam.yedamtour.freeboardreplay.service.FreeBoardReplayService;
import co.yedam.yedamtour.freeboardreplay.service.FreeBoardReplayVO;
import co.yedam.yedamtour.freeboardreplay.serviceImpl.FreeBoardReplayServiceImpl;

@WebServlet("/freeboardreplayregist.do")
public class FreeBoardReplayRegist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FreeBoardReplayRegist() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FreeBoardReplayService dao = new FreeBoardReplayServiceImpl();
		FreeBoardReplayVO vo = new FreeBoardReplayVO();
		
		System.out.println("replayContent ::" + request.getParameter("replayContent"));
		
		vo.setFreeBoardId(Integer.valueOf(request.getParameter("freeBoardId")));
		vo.setReplayContent(request.getParameter("replayContent"));
		vo.setReplayWriter(request.getParameter("replayWriter"));
		
		Map<String, Object> resultMap = new HashMap<>();
		int n = dao.freeBoardReplayInsert(vo);
		if( n != 0 ) {
			resultMap.put("retcode", "success");
			resultMap.put("data", vo);
		} else {
			resultMap.put("retcode", "Fail");
		}
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(resultMap);
		
		response.setContentType("text/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
