package co.yedam.yedamtour.reservation;

public interface ReservationMapper {
	ReservationVO reservationSelect(ReservationVO vo);
	int reservationInsert(ReservationVO vo);
	int reservationDelete(ReservationVO vo);
}
