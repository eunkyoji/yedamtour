package co.yedam.yedamtour.stay.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StayVO {
	private int		stayId;
	private String	stayName;
	private String	detail;
	private int		price;
	private int		sale;
	private String	grade;
	private int		stayCount;
	private String	stayImg;
	private String	stayService;
	private String	stayAddress;
	private String	rImg;
	private String	rName;
	private int		rPrice;
	private int		subId;
	private int		categoryId;
	private String	categoryName;
	private String	bedType;
	private int		totalCount;
	private int		startPage;
	private int		endPage;
	private int		currNum;
	private int		rowN;
	private int		start;
	private int		end;
}
