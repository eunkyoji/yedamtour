package co.yedam.yedamtour.airplane.map;

import java.util.List;

import co.yedam.yedamtour.airplane.service.AirplaneVO;

public interface AirplaneMapper {
	List<AirplaneVO> airplaneSelectList(AirplaneVO vo);
	List<AirplaneVO> airplaneSelectList1(AirplaneVO vo);
	AirplaneVO airplaneSelect(AirplaneVO vo);
	int airplaneInsert(AirplaneVO vo);
	int airplaneUpdate(AirplaneVO vo);
	int airplaneDelete(AirplaneVO vo);
}
