package com.answer.dao;

import com.answer.es.EsProduct;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EsProductDao {
    List<EsProduct> getAll(@Param("id") Long id);
}
