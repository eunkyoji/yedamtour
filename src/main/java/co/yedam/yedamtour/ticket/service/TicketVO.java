package co.yedam.yedamtour.ticket.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketVO {
	private int		ticketId;
	private String	ticketName;
	private String	detail;
	private	int		price;
	private String	brif;
	private String	img;
	private int		categoryId;
	private String	categoryName;
	private String	campanyEmail;
	private int		totalCount;
	private int		startPage;
	private int		endPage;
	private int		currNum;
	private int		rowN;
}
