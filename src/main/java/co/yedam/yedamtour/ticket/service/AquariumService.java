package co.yedam.yedamtour.ticket.service;

import java.util.List;

public interface AquariumService {
	List<AquariumVO> aquariumSelectList();
	
	AquariumVO aquariumSelect(AquariumVO vo);
}
