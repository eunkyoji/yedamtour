package co.yedam.yedamtour.freeboard.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.yedamtour.common.DataSource;
import co.yedam.yedamtour.freeboard.map.FreeBoardMapper;
import co.yedam.yedamtour.freeboard.service.FreeBoardService;
import co.yedam.yedamtour.freeboard.service.FreeBoardVO;

public class FreeBoardServiceImpl implements FreeBoardService{
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private FreeBoardMapper map = sqlSession.getMapper(FreeBoardMapper.class);
	
	@Override
	public List<FreeBoardVO> freeBoardSelectList(FreeBoardVO vo) {
		return map.freeBoardSelectList(vo);
	}

	@Override
	public FreeBoardVO freeBoardSelect(FreeBoardVO vo) {
		map.freeBoardHitUpdate(vo.getFreeBoardId());	//조회수를 증가 시킨다.
		return map.freeBoardSelect(vo);
	}

	@Override
	public int freeBoardInsert(FreeBoardVO vo) {
		return map.freeBoardInsert(vo);
	}

	@Override
	public int freeBoardUpdate(FreeBoardVO vo) {
		return map.freeBoardUpdate(vo);
	}

	@Override
	public int freeBoardDelete(FreeBoardVO vo) {
		return map.freeBoardDelete(vo);
	}

	@Override
	public void freeBoardHitUpdate(int id) {
		
	}

	@Override
	public FreeBoardVO freeBoardTotalCount(FreeBoardVO vo) {
		return map.freeBoardTotalCount(vo);
	}

}
