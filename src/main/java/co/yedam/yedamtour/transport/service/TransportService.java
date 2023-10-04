package co.yedam.yedamtour.transport.service;

import java.util.List;

public interface TransportService {
	List<TransportVO>	transportSelectList(TransportVO vo);
	TransportVO			transportSelect(TransportVO vo);
	TransportVO			transportTotalCount(TransportVO vo);
	int					transportInsert(TransportVO vo);
	int					transportUpdate(TransportVO vo);
	int					transportDelete(TransportVO vo);
}
