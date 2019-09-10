package com.siyu;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.TransactionFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import javax.swing.event.InternalFrameEvent;
import java.io.IOException;

@Component
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/*.xml"})
public class Test {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private BeanFactoryAwareIml beanFactoryAwareIml;

    @org.junit.Test
    public void test() throws IOException {



    }

    @org.junit.Test
    public void test2(){

        ApplicationContext context=new ClassPathXmlApplicationContext();
        System.out.println(context+"\n"+applicationContext);


    }

}

