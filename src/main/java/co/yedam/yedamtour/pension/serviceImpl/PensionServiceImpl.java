package co.yedam.yedamtour.pension.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.yedamtour.common.DataSource;
import co.yedam.yedamtour.pension.map.PensionMapper;
import co.yedam.yedamtour.pension.service.PensionService;
import co.yedam.yedamtour.pension.service.PensionVO;

public class PensionServiceImpl implements PensionService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private PensionMapper map = sqlSession.getMapper(PensionMapper.class);

	@Override
	public List<PensionVO> pensionSelectList() {
		return map.pensionSelectList();
	}

	@Override
	public PensionVO pensionSelect(PensionVO vo) {
		return map.pensionSelect(vo);
	}

	@Override
	public int pensionInsert(PensionVO vo) {
		return map.pensionInsert(vo);
	}

	@Override
	public int pensionUpdate(PensionVO vo) {
		return map.pensionUpdate(vo);
	}

	@Override
	public int pensionDelete(PensionVO vo) {
		return map.pensionDelete(vo);
	}

}
