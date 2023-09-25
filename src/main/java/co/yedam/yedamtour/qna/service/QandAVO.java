package co.yedam.yedamtour.qna.service;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QandAVO {
	int 		qnaId;
	String		qnaTitle;
	String		qnaContent;
	String		qnaWriter;
	Date		qnaWriteDate;
	Date		qnaUpdateDate;
	String		qnaReplay;
	String		qnaViewDate;
	String		memberNicname;
	int			rownum;
}
