package co.yedam.yedamtour.reservation.map;

import java.util.List;

import co.yedam.yedamtour.reservation.service.ReservationVO;

public interface ReservationMapper {
	List<ReservationVO> reservationTransSelectList(ReservationVO vo);
	List<ReservationVO> reservationListSelectList();
	ReservationVO reservationTransSelect(ReservationVO vo);
	List<ReservationVO> reservationCartSelectList(ReservationVO vo);	//마이페이지에서 나의 내역불러오기
	int reservationCartUpdate(ReservationVO vo);	//결제상태 변경
	List<ReservationVO> reservationCartFinishSelectList(ReservationVO vo);
	
	int reservationTransInsert(ReservationVO vo);
	int reservationTransUpdate(ReservationVO vo);
	int reservationTransDelete(ReservationVO vo);
	int reservationStayInsert(ReservationVO vo);
	int reservationTicketInsert(ReservationVO vo);

}
