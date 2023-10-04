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

	@Override
	public int reservationStayInsert(ReservationVO vo) {
		return map.reservationStayInsert(vo);
	}

	public int reservationTicketInsert(ReservationVO vo) {
		return map.reservationTicketInsert(vo);
	}

	@Override
	public List<ReservationVO> reservationListSelectList() {
		return map.reservationListSelectList();
	}

	@Override
	public List<ReservationVO> reservationCartSelectList(ReservationVO vo) {
		return map.reservationCartSelectList(vo);
	}

	@Override
	public int reservationCartUpdate(ReservationVO vo) {
		return map.reservationCartUpdate(vo);
	}

	@Override
	public List<ReservationVO> reservationCartFinishSelectList(ReservationVO vo) {
		return map.reservationCartFinishSelectList(vo);
	}

	@Override
	public int reservationSendCheckUpdate(ReservationVO vo) {
		return map.reservationSendCheckUpdate(vo);
	}

}
