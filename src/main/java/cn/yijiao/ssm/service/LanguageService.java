package cn.yijiao.ssm.service;

import java.util.List;

import cn.yijiao.ssm.po.Language;

public interface LanguageService {

	public String selectByLanguageId(int language_id);

	public List<Language> selectAllLanguage();

}
