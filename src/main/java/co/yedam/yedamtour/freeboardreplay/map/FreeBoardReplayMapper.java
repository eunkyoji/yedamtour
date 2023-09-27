package co.yedam.yedamtour.freeboardreplay.map;

import java.util.List;

import co.yedam.yedamtour.freeboardreplay.service.FreeBoardReplayVO;

public interface FreeBoardReplayMapper {
		List<FreeBoardReplayVO>	freeBoardReplaySelectLsit(int freeBoardId);
		FreeBoardReplayVO		freeBoardReplaySelect(FreeBoardReplayVO vo);
		int						freeBoardReplayInsert(FreeBoardReplayVO vo);
		int						freeBoardReplayUpdate(FreeBoardReplayVO vo);
		int						freeBoardReplayDelete(FreeBoardReplayVO vo);
}
