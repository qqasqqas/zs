package com.answer.service.impl;

import com.answer.dao.EsProductDao;
import com.answer.es.EsProduct;
import com.answer.es.EsProductRepository;
import com.answer.service.ESProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Iterator;
import java.util.List;
@Service
public class ESProductServiceImpl implements ESProductService {

    @Autowired
    EsProductRepository esProductRepository;
    @Autowired
    EsProductDao esProductDao;
    @Override
    public int importAll() {
        List<EsProduct> esProducts = esProductDao.getAll(null);
        Iterable<EsProduct> esProducts1 = esProductRepository.saveAll(esProducts);
        Iterator<EsProduct> iterator = esProducts1.iterator();
        int result = 0;
        while (iterator.hasNext()){
            result++;
            iterator.next();
        }
        return result;
    }

    @Override
    public void delete(Long id) {
        esProductRepository.deleteById(id);
    }

    @Override
    public EsProduct creat(Long id) {
        EsProduct result = null;
        List<EsProduct> esProductList = esProductDao.getAll(id);
        if (!CollectionUtils.isEmpty(esProductList)){
            EsProduct esProduct = esProductList.get(0);
            result = esProductRepository.save(esProduct);
        }
        return result;
    }

    @Override
    public Page<EsProduct> search(String keyword, Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return esProductRepository.findByNameOrSubTitleOrKeywords(keyword,keyword,keyword,pageable);
    }
}
