package co.yedam.yedamtour.camping.map;

import java.util.List;

import co.yedam.yedamtour.camping.service.CampingVO;
import co.yedam.yedamtour.pension.service.PensionVO;

public interface CampingMapper {
	List<CampingVO> campingSelectList();
	List<CampingVO> campingDetailSelectList(int campingId);	
	CampingVO		campingSelect(CampingVO vo);
	CampingVO		campingRoomSelect(CampingVO vo);
	int 			campingInsert(CampingVO vo);
	int 			campingUpdate(CampingVO vo);
	int 			campingDelete(CampingVO vo);
}
