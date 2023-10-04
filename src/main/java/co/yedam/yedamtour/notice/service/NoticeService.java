package co.yedam.yedamtour.notice.service;

import java.util.List;

public interface NoticeService {
	List<NoticeVO>	noticeSelectList(NoticeVO vo);
	NoticeVO		noticeSelect(NoticeVO vo);
	NoticeVO		noticeTotalCount(NoticeVO vo);
	int				noticeInsert(NoticeVO vo);
	int				noticeUpdate(NoticeVO vo);
	int				noticeDelete(NoticeVO vo);
}
