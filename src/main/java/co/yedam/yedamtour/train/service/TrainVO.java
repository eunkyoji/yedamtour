package co.yedam.yedamtour.train.service;

import java.sql.Date;

import lombok.Data;

@Data
public class TrainVO {
	private int trainId;
	private String trainStart;
	private String trainFinish;
	private Date trainGoday;
	private Date trainComeday;
	private String trainGrade;
	private String trainPerson;
	private String trainDeptime;
	private String trainArrtime;
	private String trainSeats;
	private int trainPrice;
}
