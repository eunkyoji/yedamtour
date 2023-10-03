package co.yedam.yedamtour.reservation.map;

import java.util.List;

import co.yedam.yedamtour.reservation.service.ReservationVO;

public interface ReservationMapper {
	List<ReservationVO> reservationTransSelectList(ReservationVO vo);
	ReservationVO reservationTransSelect(ReservationVO vo);
	int reservationTransInsert(ReservationVO vo);
	int reservationTransUpdate(ReservationVO vo);
	int reservationTransDelete(ReservationVO vo);
	int reservationStayInsert(ReservationVO vo);
}
