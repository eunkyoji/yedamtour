package co.yedam.yedamtour.airplane.service;

import java.sql.Date;

import lombok.Data;
@Data
public class AirplaneVO {
	private int airplaneId;
	private String airplaneStart;
	private String airplaneFinish;
	private Date airplaneGoday;
	private Date airplaneComeday;
	private String airplaneGrade;
	private String airplanePerson;
	private String airplaneDeptime;
	private String airplaneArrtime;
	private String airplaneSeats;
	private int airplanePrice;
}
