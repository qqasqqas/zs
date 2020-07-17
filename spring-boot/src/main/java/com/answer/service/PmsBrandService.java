package com.answer.service;

import com.answer.pojo.PmsBrand;

import java.util.List;

public interface PmsBrandService {

    List<PmsBrand> getPmsBrands();

    int creatPmsBrand(PmsBrand pmsBrand);

    int delete(Long id);

    int update(Long id,PmsBrand pmsBrand);
}
