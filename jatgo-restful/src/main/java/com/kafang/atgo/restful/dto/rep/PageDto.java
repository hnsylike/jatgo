package com.kafang.atgo.restful.dto.rep;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author like
 * @description 分页返还实体类
 * @data 2018/10/13
 */
@ToString
public class PageDto<T> {


    private List<T> pageData = new ArrayList<>();
    private Integer currentPage = Integer.valueOf(1);
    private Integer pageSize = Integer.valueOf(10);
    private Integer totalCount;
    private Boolean first;
    private Boolean last;
    private Boolean hasNext;
    private Boolean hasPrev;
    private Integer nextPage;
    private Integer prevPage;
    private Integer pageCount;

    public int getPageCount() {
        if (this.totalCount.intValue() % this.pageSize.intValue() == 0) {
            return this.totalCount.intValue() / this.pageSize.intValue();
        }
        return this.pageCount = this.totalCount.intValue() / this.pageSize.intValue() + 1;
    }

    public PageDto(List<T> pageData, Integer totalCount) {
        this.pageData = pageData;
        this.totalCount = totalCount;
    }

    public PageDto(Integer currentPage, Integer pageSize, Integer totalCount, List<T> pageData) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.pageData = pageData;
    }

    public PageDto() {
    }

    public boolean isFirst() {
        this.first = (this.currentPage.intValue() == 1) || (this.totalCount.intValue() == 0);
        return this.first;
    }

    public boolean isLast() {
        this.last = (this.totalCount.intValue() == 0) || (this.currentPage.intValue() >= getPageCount());
        return this.last;
    }

    public boolean isHasNext() {
        return this.hasNext = this.currentPage.intValue() < getPageCount();
    }

    public boolean isHasPrev() {
        return this.hasPrev = this.currentPage.intValue() > 1;
    }

    public Integer getNextPage() {
        if (this.currentPage.intValue() >= getPageCount()) {
            return Integer.valueOf(getPageCount());
        }
        return this.nextPage = Integer.valueOf(this.currentPage.intValue() + 1);
    }

    public Integer getPrevPage() {
        if (this.currentPage.intValue() <= 1) {
            return Integer.valueOf(1);
        }
        return this.prevPage = Integer.valueOf(this.currentPage.intValue() - 1);
    }

    public List<T> getPageData() {
        if (pageData.size() > pageSize) {
            int start = (this.currentPage.intValue() - 1) * pageSize;
            int end = this.currentPage.intValue() * pageSize;
            if (start > pageData.size()) {
                start = pageData.size();
            }
            if (start > end) {
                end = start;
            }
            if (end > pageData.size()) {
                end = pageData.size();
            }
            this.pageData = this.pageData.subList(start, end);
        }
        return this.pageData;
    }

    public void setPageData(List<T> pageData) {
        this.pageData = pageData;
    }

    public Integer getCurrentPage() {
        return this.currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }
}
