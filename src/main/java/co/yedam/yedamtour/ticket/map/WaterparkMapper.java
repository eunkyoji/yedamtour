package co.yedam.yedamtour.ticket.map;

import java.util.List;

import co.yedam.yedamtour.ticket.service.WaterparkVO;

public interface WaterparkMapper {
	List<WaterparkVO> waterparkSelectList();

	WaterparkVO waterparkSelect(WaterparkVO vo);
}
