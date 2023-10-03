package co.yedam.yedamtour.ticket.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.yedamtour.common.DataSource;
import co.yedam.yedamtour.ticket.map.WaterparkMapper;
import co.yedam.yedamtour.ticket.service.WaterparkService;
import co.yedam.yedamtour.ticket.service.WaterparkVO;

public class WaterparkServiceImpl implements WaterparkService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private WaterparkMapper map = sqlSession.getMapper(WaterparkMapper.class);

	@Override
	public List<WaterparkVO> waterparkSelectList() {
		return map.waterparkSelectList();
	}

	@Override
	public WaterparkVO waterparkSelect(WaterparkVO vo) {
		return map.waterparkSelect(vo);
	}

	@Override
	public WaterparkVO waterparkCartSelect(WaterparkVO vo) {
		return map.waterparkCartSelect(vo);
	}

}
