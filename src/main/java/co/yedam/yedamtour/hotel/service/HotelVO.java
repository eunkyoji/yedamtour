package co.yedam.yedamtour.hotel.service;

import lombok.Data;

@Data
public class HotelVO {
	private int HotelId;
	private String HotelName;
	private String HotelDetail;
	private int hotelPrice;
	private int hotelSale;
	private String hotelGrade;
	private int hotelCount;
	private String hotelImg;
	private String hotelBedtype;
	private String hotelService;
}
