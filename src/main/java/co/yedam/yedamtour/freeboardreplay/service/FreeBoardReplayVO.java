package co.yedam.yedamtour.freeboardreplay.service;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FreeBoardReplayVO {
	private int 	replayId;
	private int		freeBoardId;
	private String	replayContent;
	private String	replayWriter;
	private Date	replayWriteDate;
	private Date	replayUpdateDate;
	private String	memberNickname;
	private String	replayViewDate;
	private int		totalCount;
	private int		startPage;
	private int		endPage;
	private int		currNum;
}
