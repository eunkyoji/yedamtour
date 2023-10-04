package co.yedam.yedamtour.stay.map;

import java.util.List;

import co.yedam.yedamtour.stay.service.StayVO;

public interface StayMapper {
	List<StayVO>	staySelectList(int categoryId);
	StayVO			staySelect(StayVO vo);
	StayVO			stayTotalCount(int categoryId);
	int				stayInsert(StayVO vo);
	int				stayUpdate(StayVO vo);
	int				stayDelete(StayVO vo);
}
