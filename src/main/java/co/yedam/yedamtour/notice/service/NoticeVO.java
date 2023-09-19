package co.yedam.yedamtour.notice.service;

import java.time.LocalDate;

import lombok.Data;

@Data
public class NoticeVO {
	private int notice_id;
	private String 		noticeTitle;
	private String 		noticeContent;
	private String 		noticeImg;
	private String		noticeWriter;
	private int			noticeCount;
	private LocalDate 	noticeWriteDate;
	private LocalDate 	noticeUpdateDate;
	private String		noticeThumb;
}
