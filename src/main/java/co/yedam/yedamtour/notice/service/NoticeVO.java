package co.yedam.yedamtour.notice.service;

import java.util.Date;

import lombok.Data;

@Data
public class NoticeVO {
	private int 		noticeId;
	private String 		noticeTitle;
	private String 		noticeContent;
	private String 		noticeImg;
	private String		noticeWriter;
	private int			noticeCount;
	private Date 		noticeWriteDate;
	private Date 		noticeUpdateDate;
	private String		noticeThumb;
	private int			num;
	private String		noticeViewDate;
	private int			totalCount;
	private String		noticeSearch;
	private int			startPage;
	private int			endPage;
	private int			currNum;
}
