package com.tju.wlq.common;

import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;

public class SessionManager extends DefaultWebSessionManager {

    public SessionManager() {
        super();
    }

    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
        return null;
    }

    @Override
    public void validateSessions() {

    }
}
