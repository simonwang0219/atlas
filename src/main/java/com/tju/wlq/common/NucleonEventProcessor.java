package com.tju.wlq.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

@Slf4j
@Component("processor")
public class NucleonEventProcessor extends HttpServlet {
    private static final long serialVersionUID = -4101560534526229973L;

    // Servlet的init方法会在Tomcat启动的时候执行
    @Override
    public void init() throws ServletException {
        FutureTask<String> task = new FutureTask<String>(new Callable<String>() {
            public String call() throws Exception {
                start(); // 使用另一个线程来执行该方法，会避免占用Tomcat的启动时间
                return "Collection Completed";
            }
        });

        new Thread(task).start();
    }

    //希望tomcat启动结束后执行的方法
    private void start() {
        System.out.println("启动成功");
    }


}
