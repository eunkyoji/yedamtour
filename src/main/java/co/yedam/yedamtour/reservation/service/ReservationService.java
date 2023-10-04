package co.yedam.yedamtour.reservation.service;

import java.util.List;

public interface ReservationService {
	List<ReservationVO> reservationTransSelectList(ReservationVO vo);
	List<ReservationVO> reservationListSelectList();
	
	ReservationVO reservationTransSelect(ReservationVO vo);
	List<ReservationVO> reservationCartSelectList(ReservationVO vo);
	List<ReservationVO> reservationCartFinishSelectList(ReservationVO vo);
	int reservationCartUpdate(ReservationVO vo);
	
	
	int reservationTransInsert(ReservationVO vo);
	int reservationTransUpdate(ReservationVO vo);
	int reservationTransDelete(ReservationVO vo);
	int reservationStayInsert(ReservationVO vo);
	int reservationTicketInsert(ReservationVO vo);
}
