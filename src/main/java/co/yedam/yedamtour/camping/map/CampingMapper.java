package co.yedam.yedamtour.camping.map;

import java.util.List;

import co.yedam.yedamtour.camping.service.CampingVO;

public interface CampingMapper {
	List<CampingVO> campingSelectList();
	List<CampingVO> campingDetailSelectList(int campingId);	
	CampingVO campingSelect(CampingVO vo);
	int campingInsert(CampingVO vo);
	int campingUpdate(CampingVO vo);
	int campingDelete(CampingVO vo);
}
