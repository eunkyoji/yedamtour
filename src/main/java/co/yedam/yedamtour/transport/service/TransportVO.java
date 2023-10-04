package co.yedam.yedamtour.transport.service;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransportVO {
	private int		tId;
	private String	tStart;
	private String	tFinish;
	private Date	goDay;
	private Date	comeDay;
	private String	grade;
	private String	person;
	private	String	depTime;
	private	String	arrTime;
	private	String	seats;
	private int		price;
	private int		totalCount;
	private int		startPage;
	private int		endPage;
	private int		currNum;
	private int		rowN;
	private int		start;
	private int		end;
	private	int		categoryId;
	private String	categoryName;
}
