package co.yedam.yedamtour.reservation;

public interface ReservationService {
	ReservationVO reservationSelect(ReservationVO vo);
	int reservationInsert(ReservationVO vo);
	int reservationDelete(ReservationVO vo);
}
