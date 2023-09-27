package co.yedam.yedamtour.reservation.service;

import java.util.List;

public interface ReservationService {
	List<ReservationVO> reservationTransSelectList(ReservationVO vo);
	ReservationVO reservationTransSelect(ReservationVO vo);
	int reservationTransInsert(ReservationVO vo);
	int reservationTransUpdate(ReservationVO vo);
	int reservationTransDelete(ReservationVO vo);
}
