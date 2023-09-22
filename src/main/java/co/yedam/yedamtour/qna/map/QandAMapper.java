package co.yedam.yedamtour.qna.map;

import java.util.List;

import co.yedam.yedamtour.qna.service.QandAVO;

public interface QandAMapper {
	List<QandAVO>		qnaSelectList();
	QandAVO				qnaSelect(QandAVO vo);
	int					qnaInsert(QandAVO vo);
	int					qnaUpdate(QandAVO vo);
	int					qnaDelete(QandAVO vo);
}
