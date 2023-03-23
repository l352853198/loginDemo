package com.example.demo.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("MESSAGE_BODY")
public class UserSingleLoginMessageBodyReq {
    @XStreamAlias("USERID")
    private String userId;

    @XStreamAlias("PARAM")
    private String param;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public UserSingleLoginMessageBodyReq(String userId, String param) {
        this.userId = userId;
        this.param = param;
    }

    public UserSingleLoginMessageBodyReq() {
    }
}
