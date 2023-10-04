package co.yedam.yedamtour.freeboard.map;

import java.util.List;

import co.yedam.yedamtour.freeboard.service.FreeBoardVO;

public interface FreeBoardMapper {
	List<FreeBoardVO>	freeBoardSelectList(FreeBoardVO vo);
	FreeBoardVO			freeBoardSelect(FreeBoardVO vo);
	FreeBoardVO			freeBoardTotalCount(FreeBoardVO vo);
	int					freeBoardInsert(FreeBoardVO vo);
	int					freeBoardUpdate(FreeBoardVO vo);
	int					freeBoardDelete(FreeBoardVO vo);
	void 				freeBoardHitUpdate(int id);
}
