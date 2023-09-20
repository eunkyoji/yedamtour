package co.yedam.yedamtour.pension.service;

import lombok.Data;

@Data
public class PensionVO {
	private int pensionId;
	private String pensionName;
	private String pensionDetail;
	private int pensionPrice;
	private int pensionSale;
	private String pensionGrade;
	private int pensionCount;
	private String pensionImg;
	private String pensionAddress;
	private String pensionService;
}
