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
	private String campingRoomImg;
	private String campingRoomName;
	private int campingRoomPrice;
	private int campingSubId;
}
