package com.siyu.em.global;

import com.siyu.em.entity.Log;
import com.siyu.em.entity.Staff;
import com.siyu.em.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Component
@Aspect
public class LogAdvice {

    @Autowired
    private LogService logService;

    @After("execution(* com.siyu.em.controller.*.*(..)) && " +
            "!execution(* com.siyu.em.controller.LoginController.*(..)) &&"+
            "!execution(* com.siyu.em.controller.LogController.*(..)) &&"+
            "!execution(* com.siyu.em.controller.*.to*(..))")
    public void operationLog(JoinPoint joinPoint){
        Log log=new Log();
        log.setMoudle(joinPoint.getTarget().getClass().getSimpleName());
        log.setOperation(joinPoint.getSignature().getName());
        HttpServletRequest req=(HttpServletRequest) joinPoint.getArgs()[0];
        HttpSession session=req.getSession();
        Staff staff=(Staff)session.getAttribute("User");
        log.setOperator(staff.getAccount());
        log.setResult("Sucess");
        logService.addOperationLog(log);
    }

    @AfterThrowing(throwing = "e",pointcut ="execution(* com.siyu.em.controller.*.*(..)) && " +
            "!execution(* com.siyu.em.controller.LoginController.*(..))")
    public void systemLog(JoinPoint joinPoint,Throwable e){
        Log log=new Log();
        log.setMoudle(joinPoint.getTarget().getClass().getSimpleName());
        log.setOperation(joinPoint.getSignature().getName());
        HttpServletRequest req=(HttpServletRequest) joinPoint.getArgs()[0];
        HttpSession session=req.getSession();
        Staff staff=(Staff)session.getAttribute("User");
        log.setOperator(staff.getAccount());
        log.setResult(e.getClass().getSimpleName());
        logService.addSystemLog(log);
    }

    @After("execution(* com.siyu.em.controller.LoginController.login(..)) ")
    public void loginLog(JoinPoint joinPoint){
        Log log=new Log();
        log.setMoudle(joinPoint.getTarget().getClass().getSimpleName());
        log.setOperation(joinPoint.getSignature().getName());
        HttpServletRequest req=(HttpServletRequest) joinPoint.getArgs()[0];
        HttpSession session=req.getSession();
        Staff staff=(Staff)session.getAttribute("User");
        if(staff==null){
            log.setOperator(req.getParameter("account"));
            log.setResult("Login False");
        }
        else{
            log.setOperator(staff.getAccount());
            log.setResult("Login Sucess");
        }

        logService.addLoginLog(log);
    }

    @Before("execution(* com.siyu.em.controller.LoginController.logout(..)) ")
    public void logoutLog(JoinPoint joinPoint){
        Log log=new Log();
        log.setMoudle(joinPoint.getTarget().getClass().getSimpleName());
        log.setOperation(joinPoint.getSignature().getName());
        HttpServletRequest req=(HttpServletRequest) joinPoint.getArgs()[0];
        HttpSession session=req.getSession();
        Staff staff=(Staff)session.getAttribute("User");
        log.setOperator(staff.getAccount());
        log.setResult("Logout Sucess");

        logService.addLoginLog(log);
    }

}
