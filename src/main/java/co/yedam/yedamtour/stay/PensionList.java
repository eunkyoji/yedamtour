package co.yedam.yedamtour.stay;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.yedamtour.common.ViewResolve;
import co.yedam.yedamtour.pension.service.PensionService;
import co.yedam.yedamtour.pension.service.PensionVO;
import co.yedam.yedamtour.pension.serviceImpl.PensionServiceImpl;

@WebServlet("/pensionlist.do")
public class PensionList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PensionList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PensionService dao = new PensionServiceImpl();
		List<PensionVO> pensions = new ArrayList<PensionVO>();
		
		pensions = dao.pensionSelectList();
		request.setAttribute("pensions", pensions);		
		
		String page = "pension/pensionlist";
		ViewResolve.forward(request, response, page);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
