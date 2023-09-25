package co.yedam.yedamtour.hotel.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.yedamtour.common.DataSource;
import co.yedam.yedamtour.hotel.map.HotelMapper;
import co.yedam.yedamtour.hotel.service.HotelService;
import co.yedam.yedamtour.hotel.service.HotelVO;

public class HotelServiceImpl implements HotelService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private HotelMapper map = sqlSession.getMapper(HotelMapper.class);

	@Override
	public List<HotelVO> hotelSelectList() {
		return map.hotelSelectList();
	}

	@Override
	public HotelVO hotelSelect(HotelVO vo) {
		return map.hotelSelect(vo);
	}

	@Override
	public int hotelInsert(HotelVO vo) {
		return map.hotelInsert(vo);
	}

	@Override
	public int hotelUpdate(HotelVO vo) {
		return map.hotelUpdate(vo);
	}

	@Override
	public int hotelDelete(HotelVO vo) {
		return map.hotelDelete(vo);
	}

	@Override
	public List<HotelVO> hotelDetailSelectList(int hotelId) {
		return map.hotelDetailSelectList(hotelId);
	}

	@Override
	public HotelVO hotelRoomSelect(HotelVO vo) {
		return map.hotelRoomSelect(vo);
	}

}
