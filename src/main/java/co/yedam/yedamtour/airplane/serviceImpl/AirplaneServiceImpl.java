package co.yedam.yedamtour.airplane.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.yedamtour.airplane.map.AirplaneMapper;
import co.yedam.yedamtour.airplane.service.AirplaneService;
import co.yedam.yedamtour.airplane.service.AirplaneVO;
import co.yedam.yedamtour.common.DataSource;

public class AirplaneServiceImpl implements AirplaneService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private AirplaneMapper map = sqlSession.getMapper(AirplaneMapper.class);
	
	@Override
	public List<AirplaneVO> airplaneSelectList(AirplaneVO vo) {
		return map.airplaneSelectList(vo);
	}

	@Override
	public AirplaneVO airplaneSelect(AirplaneVO vo) {
		return map.airplaneSelect(vo);
	}

	@Override
	public int airplaneInsert(AirplaneVO vo) {
		return map.airplaneInsert(vo);
	}

	@Override
	public int airplaneUpdate(AirplaneVO vo) {
		return map.airplaneUpdate(vo);
	}

	@Override
	public int airplaneDelete(AirplaneVO vo) {
		return map.airplaneDelete(vo);
	}

}
