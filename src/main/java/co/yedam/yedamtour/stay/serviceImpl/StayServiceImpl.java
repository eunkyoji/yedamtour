package co.yedam.yedamtour.stay.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.yedamtour.common.DataSource;
import co.yedam.yedamtour.stay.map.StayMapper;
import co.yedam.yedamtour.stay.service.StayService;
import co.yedam.yedamtour.stay.service.StayVO;

public class StayServiceImpl implements StayService{
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private StayMapper		  map = sqlSession.getMapper(StayMapper.class);

	@Override
	public List<StayVO> staySelectList(StayVO vo) {
		return map.staySelectList(vo);
	}

	@Override
	public StayVO staySelect(StayVO vo) {
		return map.staySelect(vo);
	}

	@Override
	public StayVO stayTotalCount(int categoryId) {
		return map.stayTotalCount(categoryId);
	}

	@Override
	public int stayInsert(StayVO vo) {
		return map.stayInsert(vo);
	}

	@Override
	public int stayUpdate(StayVO vo) {
		return map.stayUpdate(vo);
	}

	@Override
	public int stayDelete(StayVO vo) {
		return map.stayDelete(vo);
	}

}
