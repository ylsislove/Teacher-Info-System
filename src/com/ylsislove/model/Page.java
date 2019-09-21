package com.ylsislove.model;

import java.util.List;
import java.util.Map;

/**
 * @Description 动态表格分页模型，包括当前页数，每一页显示多少条数据，总记录数，总页数，普通模型对象的列表，map模型对象的列表
 * @ClassName Page
 * @Author Apple_Coco
 * @Date 2019/9/6 0:01
 * @Version V1.0
 */
public class Page {

    private int pageNo;
    private int pageSize;
    private int totalCount;
    private int totalPage;
    private List<Object> list;
    private List<Map<String, Object>> mapList;

    public void setPageSizeAndTotalCount(int pageSize, int totalCount) {
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        totalPage = (int) Math.ceil((float)totalCount/pageSize);
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public List<Map<String, Object>> getMapList() {
        return mapList;
    }

    public void setMapList(List<Map<String, Object>> mapList) {
        this.mapList = mapList;
    }
}
