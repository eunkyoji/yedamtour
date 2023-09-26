package co.yedam.yedamtour.reservation.service;

import java.util.List;

public interface ReservationService {
	List<ReservationVO> reservationSelectList(ReservationVO vo);
	ReservationVO reservationSelect(ReservationVO vo);
	int reservationInsert(ReservationVO vo);
	int reservationUpdate(ReservationVO vo);
	int reservationDelete(ReservationVO vo);
}
