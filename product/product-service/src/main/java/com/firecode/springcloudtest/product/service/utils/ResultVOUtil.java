package com.firecode.springcloudtest.product.service.utils;

import com.firecode.springcloudtest.product.common.vo.ResultVO;

/**
 * Created by 廖师兄
 * 2017-12-09 22:53
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class ResultVOUtil {

    
	public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }
}
