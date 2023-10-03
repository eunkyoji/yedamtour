package co.yedam.yedamtour.qna.map;

import java.util.List;

import co.yedam.yedamtour.qna.service.QandAVO;

public interface QandAMapper {
	List<QandAVO>		qnaSelectList(QandAVO vo);
	QandAVO				qnaSelect(QandAVO vo);
	QandAVO				qnaTotalCount(QandAVO vo);
	int					qnaInsert(QandAVO vo);
	int					qnaUpdate(QandAVO vo);
	int					qnaReplayWrite(QandAVO vo);
	int					qnaDelete(QandAVO vo);
}
