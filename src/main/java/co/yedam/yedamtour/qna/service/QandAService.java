package co.yedam.yedamtour.qna.service;

import java.util.List;

public interface QandAService {
	List<QandAVO>		qnaSelectList();
	QandAVO				qnaSelect(QandAVO vo);
	int					qnaInsert(QandAVO vo);
	int					qnaUpdate(QandAVO vo);
	int					qnaDelete(QandAVO vo);
}
