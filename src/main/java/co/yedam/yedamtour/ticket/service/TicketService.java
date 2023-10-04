package co.yedam.yedamtour.ticket.service;

import java.util.List;

public interface TicketService {
	List<TicketVO>		ticketSelectList(TicketVO vo);
	TicketVO			ticketSelect(TicketVO vo);
	TicketVO			ticketTotalCount(int categoryId);
	int					ticketInsert(TicketVO vo);
	int					ticketUpdate(TicketVO vo);
	int					ticketDelete(TicketVO vo);
}
