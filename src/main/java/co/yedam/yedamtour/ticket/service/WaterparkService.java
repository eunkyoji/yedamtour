package co.yedam.yedamtour.ticket.service;

import java.util.List;

public interface WaterparkService {
List<WaterparkVO> waterparkSelectList();
	
	WaterparkVO waterparkSelect(WaterparkVO vo);
}
