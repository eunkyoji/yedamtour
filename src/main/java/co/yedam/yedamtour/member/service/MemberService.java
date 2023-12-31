package co.yedam.yedamtour.member.service;

import java.util.List;

public interface MemberService {
	List<MemberVO> memberSelectList(String author);
	MemberVO memberSelect(MemberVO vo);
	int memberUpdate(MemberVO vo);
	int memberInsert(MemberVO vo);
	int memberDelete(MemberVO vo);
	
	MemberVO signupIdSelect(MemberVO vo);
	
	MemberVO memberSearch(MemberVO vo);
	
	MemberVO idCheckSelect(MemberVO vo);


}
