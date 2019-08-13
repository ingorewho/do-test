package com.ignore.validator;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author renzhiqiang
 * @Description
 * @Date 2019-08-08
 **/
public class Response {
    private List<String> failureList;

    private Exception ex;

    public List<String> getFailureList() {
        return failureList;
    }

    public void setEx(Exception ex) {
        this.ex = ex;
    }

    /**
     * 是否成功
     * @return
     */
    public boolean isSuccess() {
       return CollectionUtils.isEmpty(failureList);
    }

    public boolean isFailed() {
        return CollectionUtils.isNotEmpty(failureList);
    }

    public boolean isException() {
        return ex != null;
    }

    /**
     * 添加失败信息
     * @param failure
     */
    public void addFailure(String failure) {
        if (failureList == null) {
            failureList = new ArrayList<>();
        }

        failureList.add(failure);
    }

    /**
     * 添加失败信息
     * @param response
     */
    public void addFailure(Response response) {
        if (response != null) {
            if (failureList == null) {
                failureList = new ArrayList<>();
            }

            List<String> innerFailureList = response.getFailureList();
            if (CollectionUtils.isNotEmpty(innerFailureList)) {
                failureList.addAll(response.getFailureList());
            }
        }
    }

    /**
     *
     * @param ex
     * @return
     */
    public static Response buildExceptionResponse(Exception ex) {
        Response response = new Response();
        response.setEx(ex);
        return response;
    }

    /**
     *
     * @return
     */
    public static Response buildSuccessResponse() {
        Response response = new Response();
        return response;
    }
}
