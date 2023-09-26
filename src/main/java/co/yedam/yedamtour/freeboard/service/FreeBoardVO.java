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
	private int		rownum;
	private String	freeBoardViewDate;
	private String	freeBoardNicname;
}
