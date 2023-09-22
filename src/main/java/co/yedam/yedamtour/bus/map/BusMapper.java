package co.yedam.yedamtour.bus.map;

import java.util.List;

import co.yedam.yedamtour.bus.service.BusVO;

public interface BusMapper {
	List<BusVO> busSelectList(BusVO vo);
	BusVO busSelect(BusVO vo);
	int busInsert(BusVO vo);
	int busUpdate(BusVO vo);
	int busDelete(BusVO vo);
}
