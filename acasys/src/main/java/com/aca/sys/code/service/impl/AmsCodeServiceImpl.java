package com.aca.sys.code.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aca.sys.code.service.AmsCodeService;

@Service("amaCodeService")
public class AmsCodeServiceImpl implements AmsCodeService {
	
	@Autowired
	AmsCodeMapper amsCodeMapper;

}
