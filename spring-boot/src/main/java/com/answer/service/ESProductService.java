package com.answer.service;

import com.answer.es.EsProduct;
import org.springframework.data.domain.Page;

/**
 * 商品搜索
 */
public interface ESProductService {

    /**
     * 从数据库导入到es
     * @return
     */
    int importAll();

    /**
     * 根据id删除商品
     * @param id
     */
    void delete(Long id);

    /**
     * 根据id创建商品
     * @param id
     * @return
     */
    EsProduct creat(Long id);

    /**
     * 根据关键字搜索
     * @param keyword
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<EsProduct> search(String keyword,Integer pageNum, Integer pageSize);

}
