package com.mail.model;

public class Context {
    private Integer contextId;

    private String contextName;

    public Integer getContextId() {
        return contextId;
    }

    public void setContextId(Integer contextId) {
        this.contextId = contextId;
    }

    public String getContextName() {
        return contextName;
    }

    public void setContextName(String contextName) {
        this.contextName = contextName == null ? null : contextName.trim();
    }
}