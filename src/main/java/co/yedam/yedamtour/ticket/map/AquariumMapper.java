
package co.yedam.yedamtour.ticket.map;

import java.util.List;

import co.yedam.yedamtour.ticket.service.AquariumVO;

public interface AquariumMapper {
	List<AquariumVO> aquariumSelectList();

	AquariumVO aquariumSelect(AquariumVO vo);
	
	AquariumVO aquariumCartSelect(AquariumVO vo);
}

