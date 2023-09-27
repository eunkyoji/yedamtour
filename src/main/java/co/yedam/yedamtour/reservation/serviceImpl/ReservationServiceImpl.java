package co.yedam.yedamtour.reservation.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.yedamtour.common.DataSource;
import co.yedam.yedamtour.reservation.map.ReservationMapper;
import co.yedam.yedamtour.reservation.service.ReservationService;
import co.yedam.yedamtour.reservation.service.ReservationVO;

public class ReservationServiceImpl implements ReservationService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private ReservationMapper map = sqlSession.getMapper(ReservationMapper.class);
	
	@Override
	public List<ReservationVO> reservationTransSelectList(ReservationVO vo) {
		return map.reservationTransSelectList(vo);
	}

	@Override
	public ReservationVO reservationTransSelect(ReservationVO vo) {
		return map.reservationTransSelect(vo);
	}

	@Override
	public int reservationTransInsert(ReservationVO vo) {
		return map.reservationTransInsert(vo);
	}

	@Override
	public int reservationTransUpdate(ReservationVO vo) {
		return map.reservationTransUpdate(vo);
	}

	@Override
	public int reservationTransDelete(ReservationVO vo) {
		return map.reservationTransDelete(vo);
	}

}
