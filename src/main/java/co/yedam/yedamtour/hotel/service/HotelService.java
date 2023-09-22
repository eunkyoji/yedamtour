package co.yedam.yedamtour.hotel.service;

import java.util.List;

public interface HotelService {
	List<HotelVO> 	hotelSelectList();
	List<HotelVO>   hotelDetailSelectList(HotelVO vo);
	HotelVO			hotelSelect(HotelVO vo);
	int				hotelInsert(HotelVO vo);
	int				hotelUpdate(HotelVO vo);
	int				hotelDelete(HotelVO vo);
	
}
