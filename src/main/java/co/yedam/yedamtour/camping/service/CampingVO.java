package co.yedam.yedamtour.camping.service;

import lombok.Data;

@Data
public class CampingVO {
	private int campingId;
	private String campingName;
	private String campingDetail;
	private int campingPrice;
	private int campingSale;
	private String campingGrade;
	private int campingCount;
	private String campingImg;
	private String campingService;
	private String campingAddress;
	private String campingRoomImg1;
	private String campingRoomImg2;
	private String campingRoomImg3;
	private String campingRoomName1;
	private String campingRoomName2;
	private String campingRoomName3;
	private int campingRoomPrice1;
	private int campingRoomPrice2;
	private int campingRoomPrice3;
}
