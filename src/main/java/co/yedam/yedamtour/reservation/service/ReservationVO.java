package co.yedam.yedamtour.reservation.service;

import lombok.Data;

@Data
public class ReservationVO {
	private int reservationId;
	private int stayId;
	private int ticketId;
	private int trafficId;
	private int reservationPersonnel;
	private String reservationWriterId;
	private String reservationPrice;
	private String reservationPaymentyn;
	private int reservationState;
	private String categoryId;
	private String reservationStartDate;
	private String reservationFinishDate;
	private String reservationStart;
	private String reservationFinish;
	private String reservationGrade;
	private String reservationDeptime;
	private String reservationArrtime;
	private String reservationName;
	private String reservationPhone;
	private int staySubId;
	private String productName;
	private String categoryName;
}
