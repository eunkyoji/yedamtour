package co.yedam.yedamtour.pension.map;

import java.util.List;

import co.yedam.yedamtour.pension.service.PensionVO;

public interface PensionMapper {
	List<PensionVO> pensionSelectList();
	List<PensionVO> pensionDetailSelectList(int pensionId);
	PensionVO pensionSelect(PensionVO vo);
	int pensionInsert(PensionVO vo);
	int pensionUpdate(PensionVO vo);
	int pensionDelete(PensionVO vo);
}
