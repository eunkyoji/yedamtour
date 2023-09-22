package co.yedam.yedamtour.ticket.service;

import java.util.List;

public interface ThemeparkService {
	List<ThemeparkVO> themeparkSelectList();

	ThemeparkVO themeparkSelect(ThemeparkVO vo);

	int themeparkInsert(ThemeparkVO vo);

	int themeparkUpdate(ThemeparkVO vo);

	int themeparkDelete(ThemeparkVO vo);

}
