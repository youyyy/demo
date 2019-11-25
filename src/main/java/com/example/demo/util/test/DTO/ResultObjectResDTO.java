package com.example.demo.util.test.DTO;

/**
 * @Description: [用于接受外部接口的参数入口类]
 * @Author:
 * @CreateDate:
 * @Version: [v1.0]
 */
public class ResultObjectResDTO<T> {
    public static final Integer successRet = 1;
    public static final Integer successErrorCode = 0;
    private Integer ret;
    private T data;
    /**
     * 0成功非0失败
     */
    private Integer error_code;
    private String error;//错误信息
    private Integer recoreds_perpage;

    private Integer total_records;

    private Integer current_page;

    public Integer getRet() {
        return ret;
    }

    public void setRet(Integer ret) {
        this.ret = ret;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getError_code() {
        return error_code;
    }

    public void setError_code(Integer error_code) {
        this.error_code = error_code;
    }

    public Integer getRecoreds_perpage() {
        return recoreds_perpage;
    }

    public void setRecoreds_perpage(Integer recoreds_perpage) {
        this.recoreds_perpage = recoreds_perpage;
    }

    public Integer getTotal_records() {
        return total_records;
    }

    public void setTotal_records(Integer total_records) {
        this.total_records = total_records;
    }

    public Integer getCurrent_page() {
        return current_page;
    }

    public void setCurrent_page(Integer current_page) {
        this.current_page = current_page;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getPageCount() {
        if (null == this.total_records || null == this.recoreds_perpage) {
            return 0;
        }
        //向上取整
        Double totalPage = Math.ceil((Double.valueOf(this.total_records) / Double.valueOf(this.recoreds_perpage)));
        return totalPage.intValue();
    }
}
