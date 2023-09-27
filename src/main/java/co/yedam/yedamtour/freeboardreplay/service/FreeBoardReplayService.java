package co.yedam.yedamtour.freeboardreplay.service;

import java.util.List;

public interface FreeBoardReplayService {
	List<FreeBoardReplayVO>	freeBoardReplaySelectLsit(int freeBoardId);
	FreeBoardReplayVO		freeBoardReplaySelect(FreeBoardReplayVO vo);
	int						freeBoardReplayInsert(FreeBoardReplayVO vo);
	int						freeBoardReplayUpdate(FreeBoardReplayVO vo);
	int						freeBoardReplayDelete(FreeBoardReplayVO vo);
}
