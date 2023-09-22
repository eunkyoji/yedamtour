package co.yedam.yedamtour.bus.service;

import java.sql.Date;

import lombok.Data;

@Data
public class BusVO {
	private int busId;
	private String busStart;
	private String busFinish;
	private Date busGoday;
	private Date busComeday;
	private String busGrade;
	private String busPrice;
	private String busPerson;
	private String busDeptime;
	private String busArrtime;
	private String busSeats;
}
