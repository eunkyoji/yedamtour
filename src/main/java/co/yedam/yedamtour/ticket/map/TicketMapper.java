package co.yedam.yedamtour.ticket.map;

import java.util.List;

import co.yedam.yedamtour.ticket.service.TicketVO;

public interface TicketMapper {
	List<TicketVO>		ticketSelectList(TicketVO vo);
	TicketVO			ticketSelect(TicketVO vo);
	TicketVO			ticketTotalCount(int categoryId);
	int					ticketInsert(TicketVO vo);
	int					ticketUpdate(TicketVO vo);
	int					ticketDelete(TicketVO vo);
}
