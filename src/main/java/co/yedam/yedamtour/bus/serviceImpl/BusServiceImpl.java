package co.yedam.yedamtour.bus.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.yedamtour.bus.map.BusMapper;
import co.yedam.yedamtour.bus.service.BusService;
import co.yedam.yedamtour.bus.service.BusVO;
import co.yedam.yedamtour.common.DataSource;

public class BusServiceImpl implements BusService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private BusMapper map = sqlSession.getMapper(BusMapper.class);
	
	@Override
	public List<BusVO> busSelectList(BusVO vo) {
		return map.busSelectList(vo);
	}

	@Override
	public BusVO busSelect(BusVO vo) {
		return map.busSelect(vo);
	}

	@Override
	public int busInsert(BusVO vo) {
		return map.busInsert(vo);
	}

	@Override
	public int busUpdate(BusVO vo) {
		return map.busUpdate(vo);
	}

	@Override
	public int busDelete(BusVO vo) {
		return map.busDelete(vo);
	}

}
