package net.ailq.response.page;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created by LiLongLong on 2016/11/22.
 * 分页基础类，默认是每页10条记录
 */
public class PageModel<T> {

    /**
     * 当前第几页
     */
    private int page;
    /**
     * 返回数据总条数
     */
    private long total;
    /**
     * 每页条数
     */
    private int limit;
    /**
     * 数据封装类
     */
    private List<T> list;
    /**
     * 数据库查询使用，从第start条开始
     */
    @JSONField(serialize = false)
    private int start;

    @JSONField(serialize = false)
    private T model;

    public PageModel(){

    }

    public PageModel(int current, int size) {
        this.limit = size == 0 ? 10 : size;
        this.page = current == 0 ? 1 : current;
        this.start = (this.page - 1) * this.limit;
    }

    public PageModel(int current, int size, T model) {
        this.model = model;
        this.limit = size == 0 ? 10 : size;
        this.page = current == 0 ? 1 : current;
        this.start = (this.page - 1) * this.limit;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }
}
