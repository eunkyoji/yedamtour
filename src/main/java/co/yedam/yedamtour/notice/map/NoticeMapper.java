package co.yedam.yedamtour.notice.map;

import java.util.List;

import co.yedam.yedamtour.notice.service.NoticeVO;

public interface NoticeMapper {
	List<NoticeVO>	noticeSelectList(NoticeVO vo);
	NoticeVO		noticeSelect(NoticeVO vo);
	NoticeVO		noticeTotalCount(NoticeVO vo);
	int				noticeInsert(NoticeVO vo);
	int				noticeUpdate(NoticeVO vo);
	int				noticeDelete(NoticeVO vo);
}
