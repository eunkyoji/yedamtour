package co.yedam.yedamtour.pension.map;

import java.util.List;

import co.yedam.yedamtour.pension.service.PensionVO;

public interface PensionMapper {
	List<PensionVO> pensionDetailSelectList(int pensionId);
	List<PensionVO> pensionSelectList();
	PensionVO 		pensionSelect(PensionVO vo);
	PensionVO		pensionRoomSelect(PensionVO vo);
	List<PensionVO>	pensionSelectMember(PensionVO vo);
	int 			pensionInsert(PensionVO vo);
	int				pensionUpdate(PensionVO vo);
	int 			pensionDelete(PensionVO vo);
}
