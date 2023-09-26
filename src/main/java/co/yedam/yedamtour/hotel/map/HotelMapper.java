package co.yedam.yedamtour.hotel.map;

import java.util.List;

import co.yedam.yedamtour.hotel.service.HotelVO;

public interface HotelMapper {
	List<HotelVO> 	hotelSelectList();
	List<HotelVO>   hotelDetailSelectList(int hotelId);
	HotelVO			hotelRoomSelect(HotelVO vo);
	HotelVO			hotelSelect(HotelVO vo);
	List<HotelVO>	hotelSelectMember(HotelVO vo);
	int				hotelInsert(HotelVO vo);
	int				hotelUpdate(HotelVO vo);
	int				hotelDelete(HotelVO vo);
}
