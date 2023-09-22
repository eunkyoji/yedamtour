package co.yedam.yedamtour.ticket.map;

import java.util.List;

import co.yedam.yedamtour.ticket.service.ThemeparkVO;

public interface ThemeparkMapper {
	List<ThemeparkVO> themeparkSelectList();

	ThemeparkVO themeparkSelect(ThemeparkVO vo);

	int themeparkInsert(ThemeparkVO vo);

	int themeparkUpdate(ThemeparkVO vo);

	int themeparkDelete(ThemeparkVO vo);
}
