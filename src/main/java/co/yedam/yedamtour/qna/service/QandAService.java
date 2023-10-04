package co.yedam.yedamtour.qna.service;

import java.util.List;

public interface QandAService {
	List<QandAVO>		qnaSelectList(QandAVO vo);
	QandAVO				qnaSelect(QandAVO vo);
	QandAVO				qnaTotalCount(QandAVO vo);
	int					qnaInsert(QandAVO vo);
	int					qnaUpdate(QandAVO vo);
	int					qnaReplayWrite(QandAVO vo);
	int					qnaDelete(QandAVO vo);
}
