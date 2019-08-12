package com.how2java.tmall.util;

public class Page {
    private int offset; //页码
    private int limit; //每页显示数量
    private int total; //总共有多少条数据
    private String param; //参数

    private static final int defaultlimit = 5;

    public Page() {
        limit = defaultlimit;
    }

    public Page(int offset, int limit) {
        this();
        this.offset = offset;
        this.limit = limit;

    }

    public int getoffset() {
        return offset;
    }

    public void setoffset(int offset) {
        this.offset = offset;
    }

    public int getlimit() {
        return limit;
    }

    public void setlimit(int limit) {
        this.limit = limit;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }


    //根据 每页显示的数量count以及总共有多少条数据total，计算出总共有多少页
    public int getTotalPage() {
        int totalPage;
        if (0 == total % limit) {
            // 假设总数是50，是能够被5整除的，那么就有10页
            totalPage = total / limit;
        } else {
            // 假设总数是51，不能够被5整除的，那么就有11页
            totalPage = total / limit + 1;
        }//一条数据也没有也应该有一页
        if (0 == totalPage) {
            totalPage = 1;
        }
        return totalPage;
    }
    //计算出最后一页的数值是多少

    //判断是否有前一页
    public boolean isHasPreviouse() {
        if (offset == 0) {
            return false;
        }
        return true;
    }

    //判断是否有后一页
    public boolean isHasNext() {
        if (offset == getLast()) {
            return false;
        } else {
            return true;
        }
    }

    public int getLast() {
        int list;
        //如果总数据是50 每页数量为5 那么最后一页开始就应该是45
        if (0 == total % limit) {
            list = total - limit;
            //如果总数据是51,每页数量为5 ,那么最后一页就应该是50
        } else {
            list = total - total % limit;
        }
        list = list < 0 ? 0 : list;//校验list
        return list;
    }

    @Override
    public String toString() {
        return "Page [offset=" + offset + ", limit=" + limit + ", total=" + total + ", getStart()=" + getoffset()
                + ", getlimit()=" + getlimit() + ", isHasPreviouse()=" + isHasPreviouse() + ", isHasNext()="
                + isHasNext() + ", getTotalPage()=" + getTotalPage() + ", getLast()=" + getLast() + "]";
    }
}
