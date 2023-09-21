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
	private int			rownum;
	private String		noticeViewDate;
}
