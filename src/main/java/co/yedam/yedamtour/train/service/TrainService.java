package co.yedam.yedamtour.train.service;

import java.util.List;

public interface TrainService {
	List<TrainVO> trainSelectList(TrainVO vo);
	TrainVO trainSelect(TrainVO vo);
	int trainInsert(TrainVO vo);
	int trainUpdate(TrainVO vo);
	int trainDelete(TrainVO vo);
}
