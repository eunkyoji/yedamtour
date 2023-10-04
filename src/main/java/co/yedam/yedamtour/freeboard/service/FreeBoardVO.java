package co.yedam.yedamtour.freeboard.service;

import java.util.Date;

import lombok.Data;

@Data
public class FreeBoardVO {
	private int		freeBoardId;
	private String	freeBoardTitle;
	private String	freeBoardContent;
	private String 	freeBoardImg;
	private String	freeBoardWriter;
	private Date	freeBoardWriteDate;
	private Date	freeBoardUpdateDate;
	private int		freeBoardHit;
	private String	freeBoardThumb;
	private int		num;
	private String	freeBoardViewDate;
	private String	freeBoardNicname;
	private int		totalCount;
	private String	freeBoardSearch;
	private int		startPage;
	private int		endPage;
	private int		currNum;
}
