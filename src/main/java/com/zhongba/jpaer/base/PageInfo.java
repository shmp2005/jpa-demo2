package com.zhongba.jpaer.base;

import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class PageInfo<T> implements Serializable {
    protected int page = 1;
    protected int size = 20;
    protected String sidx = "id";
    protected Sort.Direction sord = Sort.Direction.ASC;
    protected List<T> result = Collections.emptyList();

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    public Sort.Direction getSord() {
        return sord;
    }

    public void setSord(Sort.Direction sord) {
        this.sord = sord;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }
}
