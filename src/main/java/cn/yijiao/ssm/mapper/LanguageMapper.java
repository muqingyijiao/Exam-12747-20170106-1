package cn.yijiao.ssm.mapper;

import java.util.List;

import cn.yijiao.ssm.po.Language;

public interface LanguageMapper{
	
	public String selectByLanguageId(int language_id);
	
	public List<Language> selectAllLanguage();
}
