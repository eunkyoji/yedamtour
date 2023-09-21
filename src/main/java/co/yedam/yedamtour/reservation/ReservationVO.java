package co.yedam.yedamtour.reservation;

import lombok.Data;

@Data
public class ReservationVO {
	private int reservationId;
	private int stayId;
	private int ticketId;
	private int traffic_id;
	private int reservationPersonnel;
	private String reservationWriterId;
	private String reservationPrice;
	private String reservationPaymentyn;
	private int reservationState;
}
