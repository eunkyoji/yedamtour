package co.yedam.yedamtour.reservation.service;

import lombok.Data;

@Data
public class ReservationVO {
	private int reservationId;
	private int stayId;
	private int ticketId;
	private int trafficId;
	private int reservationPersonnel;
	private String reservationWriteId;
	private String reservationPrice;
	private String reservationPaymentyn;
	private int reservationState;
	private String categoryId;
}
