package co.yedam.yedamtour.reservation.map;

import java.util.List;

import co.yedam.yedamtour.reservation.service.ReservationVO;

public interface ReservationMapper {
	List<ReservationVO> reservationSelectList(ReservationVO vo);
	ReservationVO reservationSelect(ReservationVO vo);
	int reservationInsert(ReservationVO vo);
	int reservationUpdate(ReservationVO vo);
	int reservationDelete(ReservationVO vo);
}
