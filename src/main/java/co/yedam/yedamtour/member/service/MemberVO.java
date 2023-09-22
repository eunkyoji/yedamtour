package co.yedam.yedamtour.member.service;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberVO {
		String memberId;
		String memberPassword;
		String memberName;
		String memberPhone;
		String memberNickname;
		Date   memberRegist;
		int	   rownum;
		String memberViewDate;
	
}
