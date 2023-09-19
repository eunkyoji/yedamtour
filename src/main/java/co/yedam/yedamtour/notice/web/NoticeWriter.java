package co.yedam.yedamtour.notice.web;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.yedam.yedamtour.common.ThumbNail;
import co.yedam.yedamtour.notice.service.NoticeService;
import co.yedam.yedamtour.notice.service.NoticeVO;
import co.yedam.yedamtour.notice.serviceImpl.NoticeServiceImpl;

@WebServlet("/noticewriter.do")
public class NoticeWriter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NoticeWriter() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ThumbNail thumbNail = new ThumbNail();
		NoticeService dao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		
		String saveDir = getServletContext().getRealPath("attech/notice");	// 운영 서버에 올릴때는 저장 경로만 작성
		int maxSize = 1024 * 1024 * 100; // 100Mbyte
		
		MultipartRequest multi = new MultipartRequest(request,	
													  saveDir,	// 저장할 위치
													  maxSize,	// 파일 최대 사이즈
													  "utf-8",	// encoding 타입
													  new DefaultFileRenamePolicy());	// 중복파일 리네임(ex: 파일(1))
		
		String imgFileName = multi.getOriginalFileName("imgfile");	// 원본파일명
		String realImg = multi.getFilesystemName("imgfile");	// 저장되는 파일명
		vo.setNoticeImg(realImg);	// img file명을 저장한다.
		
		//썸네일 만들기
		String fileExt = imgFileName.substring(imgFileName.lastIndexOf(".")+1); //확장자 명
		String thumb = thumbNail.makeThumbnail(saveDir + File.separator + imgFileName, imgFileName, fileExt, saveDir + File.separator); //썸네일 생성
		thumb = thumb.substring(thumb.lastIndexOf("\\")+1);	// 넘어온 결과에서 파일경로를 잘라내고 파일명만 얻음
		vo.setNoticeThumb(thumb);
		
		System.out.println("====== " + multi.getParameter("noticeWriter"));
		vo.setNoticeTitle("test");
		vo.setNoticeContent(multi.getParameter("noticeContent"));
		vo.setNoticeWriter("hong@gmail.com");
		
		int n = dao.noticeInsert(vo);
		System.out.println(n + "================================");
		if( n != 0 ) {
			response.sendRedirect("noticelist.do");
		} else {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
