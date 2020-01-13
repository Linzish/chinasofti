package com.chinasofti.postbar.pbappmapper.mapper;

import com.chinasofti.postbar.pbappmapper.dto.AppDto;

public interface PbAppMapper {
//	@Select("select id,appID,apiKey,secretKey from pb_app")
	AppDto selectApp();
}
