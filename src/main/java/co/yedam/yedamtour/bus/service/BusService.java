package co.yedam.yedamtour.bus.service;

import java.util.List;

public interface BusService {
	List<BusVO> busSelectList(BusVO vo);
	BusVO busSelect(BusVO vo);
	int busInsert(BusVO vo);
	int busUpdate(BusVO vo);
	int busDelete(BusVO vo);
}
