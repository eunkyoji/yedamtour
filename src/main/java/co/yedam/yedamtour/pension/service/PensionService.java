package co.yedam.yedamtour.pension.service;

import java.util.List;

public interface PensionService {
	List<PensionVO> pensionSelectList();
	List<PensionVO> pensionDetailSelectList(int pensionId);
	PensionVO 		pensionSelect(PensionVO vo);
	PensionVO		pensionRoomSelect(PensionVO vo);
	List<PensionVO>	pensionSelectMember(PensionVO vo);
	int 			pensionInsert(PensionVO vo);
	int			 	pensionUpdate(PensionVO vo);
	int 			pensionDelete(PensionVO vo);
}
