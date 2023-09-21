package co.yedam.yedamtour.freeboard.service;

import java.util.List;

public interface FreeBoardService {
	List<FreeBoardVO>	freeBoardSelectList();
	FreeBoardVO			freeBoardSelect(FreeBoardVO vo);
	int					freeBoardInsert(FreeBoardVO vo);
	int					freeBoardUpdate(FreeBoardVO vo);
	int					freeBoardDelete(FreeBoardVO vo);
	void 				freeBoardHitUpdate(int id);
}
