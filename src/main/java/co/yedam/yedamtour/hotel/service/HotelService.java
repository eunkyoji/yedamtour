package co.yedam.yedamtour.hotel.service;

import java.util.List;

public interface HotelService {
	List<HotelVO> 	hotelSelectList();
	List<HotelVO>   hotelDetailSelectList(int hotelId);
	HotelVO			hotelRoomSelect(HotelVO vo);
	HotelVO			hotelSelect(HotelVO vo);
	List<HotelVO>	hotelSelectMember(HotelVO vo);
	int				hotelInsert(HotelVO vo);
	int				hotelUpdate(HotelVO vo);
	int				hotelDelete(HotelVO vo);
	
}
