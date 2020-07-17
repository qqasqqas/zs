package com.answer.controller;

import com.answer.commont.CommonResult;
import com.answer.pojo.PmsBrand;
import com.answer.service.PmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@Api(tags = "PmsBrandController",description = "商品品牌管理")
@RestController
@RequestMapping("/brand")
public class PmsBrandController {

    @Autowired
    PmsBrandService pmsBrandService;

    @ApiOperation("添加品牌")
    @RequestMapping(value="/creat",method = RequestMethod.POST)
    public CommonResult creat(@RequestBody PmsBrand pmsBrand){
        CommonResult commonResult;
        int count = pmsBrandService.creatPmsBrand(pmsBrand);
        if (count == 1){
            commonResult = CommonResult.success(pmsBrand);
        }else {
            commonResult = CommonResult.success(pmsBrand);
        }
        return commonResult;
    }
}
