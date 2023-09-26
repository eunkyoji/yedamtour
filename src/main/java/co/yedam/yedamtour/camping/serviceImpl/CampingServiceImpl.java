package co.yedam.yedamtour.camping.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.yedamtour.camping.map.CampingMapper;
import co.yedam.yedamtour.camping.service.CampingService;
import co.yedam.yedamtour.camping.service.CampingVO;
import co.yedam.yedamtour.common.DataSource;

public class CampingServiceImpl implements CampingService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private CampingMapper map = sqlSession.getMapper(CampingMapper.class);

	@Override
	public List<CampingVO> campingSelectList() {
		return map.campingSelectList();
	}

	@Override
	public CampingVO campingSelect(CampingVO vo) {
		return map.campingSelect(vo);
	}

	@Override
	public int campingInsert(CampingVO vo) {
		return map.campingInsert(vo);
	}

	@Override
	public int campingUpdate(CampingVO vo) {
		return map.campingUpdate(vo);
	}

	@Override
	public int campingDelete(CampingVO vo) {
		return map.campingDelete(vo);
	}

	@Override
	public List<CampingVO> campingDetailSelectList(int campingId) {
		return map.campingDetailSelectList(campingId);
	}

	@Override
	public CampingVO campingRoomSelect(CampingVO vo) {
		return map.campingRoomSelect(vo);
	}

	@Override
	public List<CampingVO> campingSelectMember(CampingVO vo) {
		return map.campingSelectMember(vo);
	}

}
