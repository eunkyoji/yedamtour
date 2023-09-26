package co.yedam.yedamtour.qna.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.yedamtour.common.DataSource;
import co.yedam.yedamtour.qna.map.QandAMapper;
import co.yedam.yedamtour.qna.service.QandAService;
import co.yedam.yedamtour.qna.service.QandAVO;

public class QandAServiceImpl implements QandAService{
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private QandAMapper map = sqlSession.getMapper(QandAMapper.class);
	
	@Override
	public List<QandAVO> qnaSelectList() {
		return map.qnaSelectList();
	}

	@Override
	public QandAVO qnaSelect(QandAVO vo) {
		return map.qnaSelect(vo);
	}

	@Override
	public int qnaInsert(QandAVO vo) {
		return map.qnaInsert(vo);
	}

	@Override
	public int qnaUpdate(QandAVO vo) {
		return map.qnaUpdate(vo);
	}

	@Override
	public int qnaDelete(QandAVO vo) {
		return map.qnaDelete(vo);
	}

}
