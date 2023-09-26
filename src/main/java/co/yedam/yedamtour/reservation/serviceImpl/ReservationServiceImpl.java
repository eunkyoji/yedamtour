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
	public List<ReservationVO> reservationSelectList(ReservationVO vo) {
		return map.reservationSelectList(vo);
	}

	@Override
	public ReservationVO reservationSelect(ReservationVO vo) {
		return map.reservationSelect(vo);
	}

	@Override
	public int reservationInsert(ReservationVO vo) {
		return map.reservationInsert(vo);
	}

	@Override
	public int reservationUpdate(ReservationVO vo) {
		return map.reservationUpdate(vo);
	}

	@Override
	public int reservationDelete(ReservationVO vo) {
		return map.reservationDelete(vo);
	}

}
