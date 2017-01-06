package cn.yijiao.ssm.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yijiao.ssm.po.Film;
import cn.yijiao.ssm.po.FilmPage;
import cn.yijiao.ssm.po.FilmVo;
import cn.yijiao.ssm.po.Language;
import cn.yijiao.ssm.service.FilmService;
import cn.yijiao.ssm.service.LanguageService;

@Controller
public class FilmController3 {

	@Autowired
	private FilmService filmService;

	@Autowired
	private LanguageService languageService;

	// 查询所有film
	@ResponseBody
	@RequestMapping("/selectAllFilm")
	public Map<Object, Object> selectAllFilm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Map<Object, Object> map = new HashMap<Object, Object>();
		FilmPage filmPage = new FilmPage();
		Film film = new Film();

		int count = filmService.selectCount(film);
		String pageNumStr = request.getParameter("pageNum");
		String pageSizeStr = request.getParameter("pageSize");
		if (pageNumStr != null && pageSizeStr != null) {
			int pageNum = Integer.parseInt(pageNumStr);
			int pageSize = Integer.parseInt(pageSizeStr);
			if (pageNum > 0) {

				double pageS = pageSize;
				int pageCount = (int) Math.ceil((count / pageS));
				if (pageNum > pageCount) {
					pageNum = pageCount;
				}

				int startNum = (pageNum - 1) * pageSize;

				filmPage.setPageNum(pageNum);
				filmPage.setStartNum(startNum);
				filmPage.setTotalCount(count);
				filmPage.setPageSize(pageSize);

				List<FilmVo> list = filmService.selectAllFilm(filmPage);
				map.put("list", list);
				map.put("filmPage", filmPage);
			}
		}

		return map;
	}

	// 根据条件查询film
	@ResponseBody
	@RequestMapping("/selectByCondition")
	public Map<Object, Object> selectByCondition(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<Object, Object> map = new HashMap<Object, Object>();
		String pageNumStr = request.getParameter("pageNum");
		String pageSizeStr = request.getParameter("pageSize");
		if (pageNumStr != null && pageSizeStr != null) {
			int pageNum = Integer.parseInt(pageNumStr);
			int pageSize = Integer.parseInt(pageSizeStr);
			String title = request.getParameter("title");
			String description = request.getParameter("description");
			Film film = new Film();
			film.setTitle(title);
			film.setDescription(description);
			int count = filmService.selectCount(film);

			double pageS = pageSize;
			int pageCount = (int) Math.ceil((count / pageS));
			if (pageNum > pageCount) {
				pageNum = pageCount;
			}

			FilmPage filmPage = new FilmPage();
			int startNum = (pageNum - 1) * pageSize;

			filmPage.setFilm(film);
			filmPage.setPageNum(pageNum);
			filmPage.setStartNum(startNum);
			filmPage.setTotalCount(count);

			filmPage.setPageSize(pageSize);

			List<FilmVo> list = filmService.selectByCondition(filmPage);

			map.put("list", list);
			map.put("filmPage", filmPage);
		}
		return map;
	}

	// 增加film
	@ResponseBody
	@RequestMapping("/add")
	public int insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Film film = new Film();
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		int language_id = Integer.parseInt(request.getParameter("language_id"));
		if ((title == null || title.equals("")) && (description == null || description.equals(""))) {
			pageNum = 0;
			return pageNum;
		}
		film.setTitle(title);
		film.setDescription(description);
		film.setLanguage_id(language_id);

		filmService.insert(film);
		return pageNum;
	}

	// 删除film
	@ResponseBody
	@RequestMapping(value = "/delete")
	public int toDelete(HttpServletRequest request, HttpServletResponse response) {
		int errorMsg = 1;
		int filmId = Integer.parseInt(request.getParameter("film_id"));
		try {
			filmService.delete(filmId);
		} catch (Exception e) {
			errorMsg = 0;
		}
		return errorMsg;
	}

	// 修改film
	@ResponseBody
	@RequestMapping(value = "/toUpdate")
	public Map<Object, Object> toUpdate(HttpServletRequest request, HttpServletResponse response) {

		Map<Object, Object> map = new HashMap<Object, Object>();
		int filmId = Integer.parseInt(request.getParameter("film_id"));
		FilmVo filmVo = filmService.selectById(filmId);

		List<Language> list = languageService.selectAllLanguage();

		map.put("filmVo", filmVo);
		map.put("list", list);
		return map;
	}

	// 修改film
	@ResponseBody
	@RequestMapping(value = "/update")
	public int update(HttpServletRequest request, HttpServletResponse response) {
		
//		Map<Object, Object> map = new HashMap<Object, Object>();
		
		int filmId = Integer.parseInt(request.getParameter("film_id"));
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		String language_id_str = request.getParameter("language_id");
//		String selectType= request.getParameter("selectType");
		int language_id = 1;
		if (language_id_str != null) {
			language_id = Integer.parseInt(language_id_str);
		}

		Film film = new Film();
		film.setFilm_id(filmId);
		film.setTitle(title);
		film.setDescription(description);
		film.setLanguage_id(language_id);

		filmService.update(film);
		
//		System.out.println(request.getParameter("selectType")+"hyyyyyyyyyy");

//		map.put("pageNum", pageNum);
//		map.put("selectType", selectType);
		return pageNum;

	}

	@ResponseBody
	@RequestMapping(value = "/languageList")
	public List<Language> languageList(HttpServletRequest request, HttpServletResponse response) {

		List<Language> list = languageService.selectAllLanguage();

		return list;

	}
}
