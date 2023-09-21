package co.yedam.yedamtour.reservation;

import org.apache.ibatis.session.SqlSession;

import co.yedam.yedamtour.common.DataSource;

public class ReservationServiceImpl implements ReservationService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private ReservationMapper map = sqlSession.getMapper(ReservationMapper.class);
	@Override
	public ReservationVO reservationSelect(ReservationVO vo) {
		return map.reservationSelect(vo);
	}
	@Override
	public int reservationInsert(ReservationVO vo) {
		return map.reservationInsert(vo);
	}
	@Override
	public int reservationDelete(ReservationVO vo) {
		return map.reservationDelete(vo);
	}
}
