
package co.yedam.yedamtour.ticket.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.yedamtour.common.DataSource;
import co.yedam.yedamtour.ticket.map.AquariumMapper;
import co.yedam.yedamtour.ticket.service.AquariumService;
import co.yedam.yedamtour.ticket.service.AquariumVO;

public class AquariumServiceImpl implements AquariumService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private AquariumMapper map = sqlSession.getMapper(AquariumMapper.class);

	@Override
	public List<AquariumVO> aquariumSelectList() {
		return map.aquariumSelectList();
	}

	@Override
	public AquariumVO aquariumSelect(AquariumVO vo) {
		return map.aquariumSelect(vo);
	}

	@Override
	public AquariumVO aquariumCartSelect(AquariumVO vo) {
		return map.aquariumCartSelect(vo);
	}

}
