package com.answer.service.impl;

import com.answer.dao.PmsBrandMapper;
import com.answer.pojo.PmsBrand;
import com.answer.pojo.PmsBrandExample;
import com.answer.service.PmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PmsBrandServiceImpl implements PmsBrandService {

    @Autowired
    private PmsBrandMapper pmsBrandMapper;

    @Override
    public List<PmsBrand> getPmsBrands() {
        return  pmsBrandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public int creatPmsBrand(PmsBrand pmsBrand) {
        return  pmsBrandMapper.insertSelective(pmsBrand);
    }

    @Override
    public int delete(Long id) {
       return pmsBrandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Long id, PmsBrand pmsBrand) {
        pmsBrand.setId(id);
        return  pmsBrandMapper.updateByPrimaryKey(pmsBrand);
    }
}
