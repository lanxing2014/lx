package com.yiibai.crawler2;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

/**
 * url任务的pojo类
 * @author tsj-pc
 *
 */
public class UrlPojo {
    private Map<String, Object> parasMap;

    public Map<String, Object> getParasMap() {
        return parasMap;
    }

    public void setParasMap(Map<String, Object> parasMap) {
        this.parasMap = parasMap;
    }

    public UrlPojo(String url) {
        this.url = url;
    }

    public UrlPojo(String url, Map<String, Object> parasMap) {
        this.url = url;
        this.parasMap = parasMap;
    }

    @Override
    public String toString() {
        return "UrlPojo [taskLevel=" + taskLevel + ", url=" + url + "]";
    }

    public UrlPojo(String url, TaskLevel taskLevel) {
        this.url = url;
        this.taskLevel = taskLevel;
    }

    private String url;
    private TaskLevel taskLevel = TaskLevel.MIDDLE;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public TaskLevel getTaskLevel() {
        return taskLevel;
    }

    public void setTaskLevel(TaskLevel taskLevel) {
        this.taskLevel = taskLevel;
    }

    public HttpURLConnection getConnection() {
        try {
            URL url = new URL(this.url);
            URLConnection connection = url.openConnection();
            if (connection instanceof HttpURLConnection) {
                return (HttpURLConnection) connection;
            } else {
                throw new Exception("connection is errr!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getHost() {
        try {
            URL url = new URL(this.url);
            return url.getHost();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}