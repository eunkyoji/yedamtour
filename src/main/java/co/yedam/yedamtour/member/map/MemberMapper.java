package co.yedam.yedamtour.member.map;

import java.util.List;

import co.yedam.yedamtour.member.service.MemberVO;

public interface MemberMapper {
	//멤버 
	List<MemberVO> memberSelectList(String author);

	MemberVO memberSelect(MemberVO vo);

	int memberUpdate(MemberVO vo);

	int memberInsert(MemberVO vo);

	int memberDelete(MemberVO vo);
	
	MemberVO signupIdSelect(MemberVO vo);
	
	MemberVO memberSearch(MemberVO vo);
	
	MemberVO idCheckSelect(MemberVO vo);
	
}
