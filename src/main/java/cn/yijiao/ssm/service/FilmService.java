package cn.yijiao.ssm.service;

import java.util.List;

import cn.yijiao.ssm.po.Film;
import cn.yijiao.ssm.po.FilmPage;
import cn.yijiao.ssm.po.FilmVo;

public interface FilmService {
	

	public List<FilmVo> selectAllFilm(FilmPage filmPage);
	
	public List<FilmVo> selectByCondition(FilmPage filmPage);
	
	public FilmVo selectById(int filmId);
	
	public int insert(Film film);
	
	public int delete(int film_id);
	
	public int update(Film film);
	
	public int selectCount(Film film);

}
