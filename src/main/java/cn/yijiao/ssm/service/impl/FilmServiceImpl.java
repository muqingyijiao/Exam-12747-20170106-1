package cn.yijiao.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.yijiao.ssm.mapper.FilmMapper;
import cn.yijiao.ssm.po.Film;
import cn.yijiao.ssm.po.FilmPage;
import cn.yijiao.ssm.po.FilmVo;
import cn.yijiao.ssm.service.FilmService;


@Service
public class FilmServiceImpl implements FilmService{
	
	@Autowired
	private FilmMapper filmMapper;
	
	@Override
	public List<FilmVo> selectAllFilm(FilmPage filmPage) {
		// TODO Auto-generated method stub
		return filmMapper.selectAllFilm(filmPage);
	}

	@Override
	public List<FilmVo> selectByCondition(FilmPage filmPage) {
		// TODO Auto-generated method stub
		return filmMapper.selectByCondition(filmPage);
	}

	@Override
	public int insert(Film film) {
		// TODO Auto-generated method stub
		return filmMapper.insert(film);
	}

	@Override
	public int delete(int film_id) {
		// TODO Auto-generated method stub
		return filmMapper.delete(film_id);
	}

	@Override
	public int update(Film film) {
		// TODO Auto-generated method stub
		return filmMapper.update(film);
	}

	@Override
	public int selectCount(Film film) {
		// TODO Auto-generated method stub
		return filmMapper.selectCount(film);
	}

	@Override
	public FilmVo selectById(int filmId) {
		// TODO Auto-generated method stub
		return filmMapper.selectById(filmId);
	}
}
