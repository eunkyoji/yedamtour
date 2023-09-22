package co.yedam.yedamtour.camping.service;

import java.util.List;

public interface CampingService {
	List<CampingVO> campingSelectList();
	List<CampingVO> campingDetailSelectList(CampingVO vo);
	CampingVO campingSelect(CampingVO vo);
	int campingInsert(CampingVO vo);
	int campingUpdate(CampingVO vo);
	int campingDelete(CampingVO vo);	
}
