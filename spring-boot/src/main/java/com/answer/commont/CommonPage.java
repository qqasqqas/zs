package com.answer.commont;

import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Page;

import java.util.List;

public class CommonPage<T> {

    private Integer pageNum;
    private Integer pageSize;
    private Integer totalPage;
    private Long total;
    private List<T> list;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public static <T> CommonPage<T> restPage(List<T> list){
        CommonPage<T> result = new CommonPage<T>();
        PageInfo pageInfo = new PageInfo();
        result.setPageNum(pageInfo.getPageNum());
        result.setPageSize(pageInfo.getPageSize());
        result.setTotal(pageInfo.getTotal());
        result.setTotalPage(pageInfo.getPages());
        result.setList(pageInfo.getList());
        return result;
    }

    public static <T> CommonPage<T> restPage(Page<T> pageInfo){
        CommonPage<T> result = new CommonPage<T>();
        result.setPageNum(pageInfo.getNumber());
        result.setPageSize(pageInfo.getSize());
        result.setTotal(pageInfo.getTotalElements());
        result.setTotalPage(pageInfo.getTotalPages());
        result.setList(pageInfo.getContent());
        return result;
    }
}
