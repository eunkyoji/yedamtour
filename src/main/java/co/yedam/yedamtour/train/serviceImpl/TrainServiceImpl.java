package co.yedam.yedamtour.train.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.yedamtour.common.DataSource;
import co.yedam.yedamtour.train.map.TrainMapper;
import co.yedam.yedamtour.train.service.TrainService;
import co.yedam.yedamtour.train.service.TrainVO;

public class TrainServiceImpl implements TrainService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private TrainMapper map = sqlSession.getMapper(TrainMapper.class);

	@Override
	public List<TrainVO> trainSelectList() {
		// TODO Auto-generated method stub
		return map.trainSelectList();
	}

	@Override
	public TrainVO trainSelect(TrainVO vo) {
		// TODO Auto-generated method stub
		return map.trainSelect(vo);
	}

	@Override
	public int trainInsert(TrainVO vo) {
		// TODO Auto-generated method stub
		return map.trainInsert(vo);
	}

	@Override
	public int trainUpdate(TrainVO vo) {
		// TODO Auto-generated method stub
		return map.trainUpdate(vo);
	}

	@Override
	public int trainDelete(TrainVO vo) {
		// TODO Auto-generated method stub
		return map.trainDelete(vo);
	}

}
