package co.yedam.yedamtour.qna.service;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QandAVO {
	private int 		qnaId;
	private String		qnaTitle;
	private String		qnaContent;
	private String		qnaWriter;
	private Date		qnaWriteDate;
	private Date		qnaUpdateDate;
	private String		qnaReplay;
	private String		qnaViewDate;
	private String		memberNickname;
	private int			num;
	private String		qnaReplayWriter;
	private int			totalCount;
	private String		qnaSearch;
	private int			startPage;
	private int			endPage;
	private int			currNum;
}
