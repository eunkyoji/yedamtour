package co.yedam.yedamtour.hotel.service;

import lombok.Data;

@Data
public class HotelVO {
	private int hotelId;
	private String hotelName;
	private String hotelDetail;
	private int hotelPrice;
	private int hotelSale;
	private String hotelGrade;
	private int hotelCount;
	private String hotelImg;
	private String hotelBedtype;
	private String hotelService;
	private String hotelAddress;
	private String hotelRoomImg;
	private String hotelRoomName;
	private int hotelRoomPrice;
	private int hotelSubId;
	private String memberId;
	private String memberPhone;
	private String memberName;
	private String categoryId;
}
