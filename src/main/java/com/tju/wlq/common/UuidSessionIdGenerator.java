package com.tju.wlq.common;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;

import java.io.Serializable;

@Slf4j
public class UuidSessionIdGenerator implements SessionIdGenerator {
    public Serializable generateId(Session session) {
        Serializable uuid = new JavaUuidSessionIdGenerator().generateId(session);
        log.info("uuid = {}", uuid);
        return uuid;
    }
}
