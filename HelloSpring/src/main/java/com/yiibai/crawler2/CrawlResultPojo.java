package com.yiibai.crawler2;

/**
 *  抓取结果的封装
 * @author tsj-pc
 *
 */
public class CrawlResultPojo {
    private boolean isSuccess;
    private String pageContent;
    private int httpStatuCode;

    public boolean isSuccess() {
        return isSuccess;
    }
    @Override
    public String toString() {
        return "CrawlResultPojo [httpStatuCode=" + httpStatuCode
                + ", isSuccess=" + isSuccess + ", pageContent=" + pageContent
                + "]";
    }

    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getPageContent() {
        return pageContent;
    }

    public void setPageContent(String pageContent) {
        this.pageContent = pageContent;
    }

    public int getHttpStatuCode() {
        return httpStatuCode;
    }

    public void setHttpStatuCode(int httpStatuCode) {
        this.httpStatuCode = httpStatuCode;
    }

}