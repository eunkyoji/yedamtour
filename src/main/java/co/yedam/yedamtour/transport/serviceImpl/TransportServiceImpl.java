package co.yedam.yedamtour.transport.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.yedamtour.common.DataSource;
import co.yedam.yedamtour.transport.map.TransportMapper;
import co.yedam.yedamtour.transport.service.TransportService;
import co.yedam.yedamtour.transport.service.TransportVO;

public class TransportServiceImpl implements TransportService{
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private	TransportMapper map = sqlSession.getMapper(TransportMapper.class);

	@Override
	public List<TransportVO> transportSelectList(TransportVO vo) {
		return map.transportSelectList(vo);
	}

	@Override
	public TransportVO transportSelect(TransportVO vo) {
		return map.transportSelect(vo);
	}

	@Override
	public TransportVO transportTotalCount(TransportVO vo) {
		return map.transportTotalCount(vo);
	}

	@Override
	public int transportInsert(TransportVO vo) {
		return map.transportInsert(vo);
	}

	@Override
	public int transportUpdate(TransportVO vo) {
		return map.transportUpdate(vo);
	}

	@Override
	public int transportDelete(TransportVO vo) {
		return map.transportDelete(vo);
	}

}
