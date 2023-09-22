package co.yedam.yedamtour.ticket.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.yedamtour.common.DataSource;
import co.yedam.yedamtour.ticket.map.ThemeparkMapper;
import co.yedam.yedamtour.ticket.service.ThemeparkService;
import co.yedam.yedamtour.ticket.service.ThemeparkVO;

public class ThemeparkServiceImpl implements ThemeparkService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private ThemeparkMapper map = sqlSession.getMapper(ThemeparkMapper.class);
	
	@Override
	public List<ThemeparkVO> themeparkSelectList() {
		return map.themeparkSelectList();
	}

	@Override
	public ThemeparkVO themeparkSelect(ThemeparkVO vo) {
		return map.themeparkSelect(vo);
	}

	@Override
	public int themeparkInsert(ThemeparkVO vo) {
		return 0;
	}

	@Override
	public int themeparkUpdate(ThemeparkVO vo) {
		return 0;
	}

	@Override
	public int themeparkDelete(ThemeparkVO vo) {
		return 0;
	}

}
