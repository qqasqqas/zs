package com.answer.controller;

import com.answer.commont.CommonPage;
import com.answer.commont.CommonResult;
import com.answer.es.EsProduct;
import com.answer.service.ESProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/esProduct")
@Api(value = "EsProductController", description = "搜索商品")
public class EsProductController {
    @Autowired
    ESProductService esProductService;

    @ApiOperation(value = "导入商品")
    @RequestMapping(value = "/importAll",method = RequestMethod.POST)
    public CommonResult<Integer> importAll(){
        int count = esProductService.importAll();
        return CommonResult.success(count);
    }

    @ApiOperation(value = "根据id删除商品")
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public CommonResult<Object> delete(@PathVariable Long id){
        esProductService.delete(id);
        return CommonResult.success(null);
    }

    @ApiOperation(value = "搜索")
    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public CommonResult<Object> search(@RequestParam(required = false) String keyword,
                                       @RequestParam(required = false,defaultValue = "0") Integer pageNum,
                                       @RequestParam(required = false,defaultValue = "5") Integer pageSzie)
    {
        Page<EsProduct> esProducts = esProductService.search(keyword, pageNum, pageSzie);
        return CommonResult.success(CommonPage.restPage(esProducts));
    }
}
