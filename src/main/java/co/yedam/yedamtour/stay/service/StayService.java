package co.yedam.yedamtour.stay.service;

import java.util.List;

public interface StayService {
	List<StayVO>	staySelectList(StayVO vo);
	StayVO			staySelect(StayVO vo);
	StayVO			stayTotalCount(int categoryId);
	int				stayInsert(StayVO vo);
	int				stayUpdate(StayVO vo);
	int				stayDelete(StayVO vo);
}
