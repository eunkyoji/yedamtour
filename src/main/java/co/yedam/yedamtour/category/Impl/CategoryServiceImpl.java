package co.yedam.yedamtour.category.Impl;

import org.apache.ibatis.session.SqlSession;

import co.yedam.yedamtour.category.map.CategoryMapper;
import co.yedam.yedamtour.category.service.CategoryVO;
import co.yedam.yedamtour.category.service.CategoryService;
import co.yedam.yedamtour.common.DataSource;

public class CategoryServiceImpl implements CategoryService{
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private CategoryMapper map = sqlSession.getMapper(CategoryMapper.class);
	
	@Override
	public CategoryVO categorySelect(CategoryVO vo) {
		return map.categorySelect(vo);
	}

}
