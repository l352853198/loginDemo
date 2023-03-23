package com.example.demo.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("TX")
public class UserSingleLoginMessageReq {
    @XStreamAlias("MESSAGE_HEADER")
    private String messageHeader;

    @XStreamAlias("MESSAGE_BODY")
    private UserSingleLoginMessageBodyReq userSingleLoginMessageBodyReq;

    public String getMessageHeader() {
        return messageHeader;
    }

    public void setMessageHeader(String messageHeader) {
        this.messageHeader = messageHeader;
    }

    public UserSingleLoginMessageBodyReq getUserSingleLoginMessageBodyReq() {
        return userSingleLoginMessageBodyReq;
    }

    public void setUserSingleLoginMessageBodyReq(UserSingleLoginMessageBodyReq userSingleLoginMessageBodyReq) {
        this.userSingleLoginMessageBodyReq = userSingleLoginMessageBodyReq;
    }
}
