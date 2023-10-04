package co.yedam.yedamtour.ticket.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.yedamtour.common.DataSource;
import co.yedam.yedamtour.ticket.map.TicketMapper;
import co.yedam.yedamtour.ticket.service.TicketService;
import co.yedam.yedamtour.ticket.service.TicketVO;

public class TicketServiceImpl implements TicketService{
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private TicketMapper	  map = sqlSession.getMapper(TicketMapper.class);

	@Override
	public List<TicketVO> ticketSelectList(TicketVO vo) {
		return map.ticketSelectList(vo);
	}

	@Override
	public TicketVO ticketSelect(TicketVO vo) {
		return map.ticketSelect(vo);
	}

	@Override
	public TicketVO ticketTotalCount(int categoryId) {
		return map.ticketTotalCount(categoryId);
	}

	@Override
	public int ticketInsert(TicketVO vo) {
		return map.ticketInsert(vo);
	}

	@Override
	public int ticketUpdate(TicketVO vo) {
		return map.ticketUpdate(vo);
	}

	@Override
	public int ticketDelete(TicketVO vo) {
		return map.ticketDelete(vo);
	}
	
}
