package co.yedam.yedamtour.freeboardreplay.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.yedamtour.common.DataSource;
import co.yedam.yedamtour.freeboardreplay.map.FreeBoardReplayMapper;
import co.yedam.yedamtour.freeboardreplay.service.FreeBoardReplayService;
import co.yedam.yedamtour.freeboardreplay.service.FreeBoardReplayVO;

public class FreeBoardReplayServiceImpl implements FreeBoardReplayService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private FreeBoardReplayMapper map = sqlSession.getMapper(FreeBoardReplayMapper.class);
	
	@Override
	public List<FreeBoardReplayVO> freeBoardReplaySelectLsit(int freeBoardId) {
		return map.freeBoardReplaySelectLsit(freeBoardId);
	}
	
	@Override
	public FreeBoardReplayVO freeBoardReplaySelect(FreeBoardReplayVO vo) {
		return map.freeBoardReplaySelect(vo);
	}
	
	@Override
	public int freeBoardReplayInsert(FreeBoardReplayVO vo) {
		return map.freeBoardReplayInsert(vo);
	}
	
	@Override
	public int freeBoardReplayUpdate(FreeBoardReplayVO vo) {
		return map.freeBoardReplayUpdate(vo);
	}
	
	@Override
	public int freeBoardReplayDelete(FreeBoardReplayVO vo) {
		return map.freeBoardReplayDelete(vo);
	}
}
