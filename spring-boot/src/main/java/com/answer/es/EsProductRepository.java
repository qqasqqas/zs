package com.answer.es;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 操作es
 */
public interface EsProductRepository extends ElasticsearchRepository<EsProduct,Long> {

    /**
     * 查询
     * @param name
     * @param SubTitle
     * @param keywords
     * @param page
     * @return
     */
    Page<EsProduct> findByNameOrSubTitleOrKeywords(String name, String SubTitle,
                                                   String keywords, Pageable page);
}
