package co.yedam.yedamtour.airplane.service;

import java.util.List;

public interface AirplaneService {
	List<AirplaneVO> airplaneSelectList(AirplaneVO vo);
	AirplaneVO airplaneSelect(AirplaneVO vo);
	int airplaneInsert(AirplaneVO vo);
	int airplaneUpdate(AirplaneVO vo);
	int airplaneDelete(AirplaneVO vo);
}
