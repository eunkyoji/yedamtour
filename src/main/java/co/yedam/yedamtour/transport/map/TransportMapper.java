package co.yedam.yedamtour.transport.map;

import java.util.List;

import co.yedam.yedamtour.transport.service.TransportVO;

public interface TransportMapper {
	List<TransportVO>	transportSelectList(TransportVO vo);
	TransportVO			transportSelect(TransportVO vo);
	TransportVO			transportTotalCount(TransportVO vo);
	int					transportInsert(TransportVO vo);
	int					transportUpdate(TransportVO vo);
	int					transportDelete(TransportVO vo);
}
