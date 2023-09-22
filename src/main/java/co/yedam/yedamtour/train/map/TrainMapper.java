package co.yedam.yedamtour.train.map;

import java.util.List;

import co.yedam.yedamtour.train.service.TrainVO;

public interface TrainMapper {
	List<TrainVO> trainSelectList();
	TrainVO trainSelect(TrainVO vo);
	int trainInsert(TrainVO vo);
	int trainUpdate(TrainVO vo);
	int trainDelete(TrainVO vo);
}
