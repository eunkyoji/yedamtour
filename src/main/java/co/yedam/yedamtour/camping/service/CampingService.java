package co.yedam.yedamtour.camping.service;

import java.util.List;

import co.yedam.yedamtour.hotel.service.HotelVO;

public interface CampingService {
	List<CampingVO> campingDetailSelectList(int campingId);
	List<CampingVO> campingSelectList();
	CampingVO		campingRoomSelect(CampingVO vo);
	CampingVO		campingSelect(CampingVO vo);
	List<CampingVO>	campingSelectMember(CampingVO vo);
	int 			campingInsert(CampingVO vo);
	int				campingUpdate(CampingVO vo);
	int 			campingDelete(CampingVO vo);	
}
