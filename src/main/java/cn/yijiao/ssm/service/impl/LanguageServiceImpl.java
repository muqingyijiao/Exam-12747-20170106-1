package cn.yijiao.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.yijiao.ssm.mapper.LanguageMapper;
import cn.yijiao.ssm.po.Language;
import cn.yijiao.ssm.service.LanguageService;


@Service
public class LanguageServiceImpl implements LanguageService{
	
	@Autowired
	private LanguageMapper languageMapper;

	@Override
	public String selectByLanguageId(int language_id) {
		// TODO Auto-generated method stub
		return languageMapper.selectByLanguageId(language_id);
	}

	@Override
	public List<Language> selectAllLanguage() {
		// TODO Auto-generated method stub
		return languageMapper.selectAllLanguage();
	}
	

}
