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

import co.yedam.yedamtour.freeboardreplay.service.FreeBoardReplayService;
import co.yedam.yedamtour.freeboardreplay.service.FreeBoardReplayVO;
import co.yedam.yedamtour.freeboardreplay.serviceImpl.FreeBoardReplayServiceImpl;

@WebServlet("/freeboardreplaydelete.do")
public class FreeBoardReplayDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FreeBoardReplayDelete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FreeBoardReplayService dao = new FreeBoardReplayServiceImpl();
		FreeBoardReplayVO vo = new FreeBoardReplayVO();
		
		vo.setFreeBoardId(Integer.valueOf(request.getParameter("freeBoardId")));
		vo.setReplayId(Integer.valueOf(request.getParameter("replayId")));
		
		int n = dao.freeBoardReplayDelete(vo);
		
		Map<String, Object> resultMap = new HashMap<>();
		if( n != 0 ) {
			resultMap.put("retcode", "success");
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
