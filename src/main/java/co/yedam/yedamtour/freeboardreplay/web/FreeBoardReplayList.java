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
		FreeBoardReplayVO vo = new FreeBoardReplayVO();
		
		int freeBoardId = Integer.valueOf(request.getParameter("freeBoardId"));
		
		vo = dao.freeBoardReplayCount(freeBoardId);
		
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
		
		replays = dao.freeBoardReplaySelectLsit(freeBoardId, startPage, endPage);
		
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
		json += objectMapper.writeValueAsString(startPage);
		json += objectMapper.writeValueAsString(endPage);
		
		response.setContentType("text/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
