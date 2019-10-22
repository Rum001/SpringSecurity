package com.itrum.ssm.demo.web;


import com.itrum.ssm.demo.domain.SysLog;
import com.itrum.ssm.demo.service.ISysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
public class SysAop {

    //获取当前访问的类
    private Class clazz;
    //获取当前访问的方法
    private Method method;
    //获取当前的时间
    private Date visitTime;

    //获取到上下文对象
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ISysLogService iSysLogService;

    //前置增强
    @Before("execution(* com.itrum.ssm.demo.web.*.*(..))")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {
        //获取当前的时间
        visitTime=new Date();
        //获取当前的类
        clazz=jp.getTarget().getClass();
        //获取当前的方法的名字
        String methodName = jp.getSignature().getName();
        //获取当前的参数列表
        Object[] args = jp.getArgs();
        //判断此方法是否有参数
        if (args==null||args.length==0){
            //无参的方法
            method=clazz.getMethod(methodName);
        }else {
            Class[] classes = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classes[i]=args[i].getClass();
            }
            method=clazz.getMethod(methodName,classes);
        }
    }

    //后置增强
    @After("execution(* com.itrum.ssm.demo.web.*.*(..))")
    public void doAfter(JoinPoint jp) throws Exception {
        //计算出执行的时长
        Long time =new Date().getTime()-visitTime.getTime();
        //获取当前操作用户的用户名
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        //获取当前的ip
        String ip = request.getRemoteAddr();
        //获取访问的资源url
        StringBuffer sb=new StringBuffer();
        if (clazz!=null&&method!=null&&clazz!=SysAop.class&&clazz!=SysLogController.class){
            //获取类上的RequestMapping("/product")
            RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if (classAnnotation!=null){
                sb.append(classAnnotation.value()[0]);
                //获取方法的RequestMapping("findAll.do")
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null) {
                    sb.append(methodAnnotation.value()[0]);
                }
            }
            SysLog sysLog = new SysLog();
            sysLog.setIp(ip);
            sysLog.setUrl(sb.toString());
            sysLog.setUsername(username);
            sysLog.setVisitTime(visitTime);
            sysLog.setExecutionTime(time);
            sysLog.setMethod("[类名]"+clazz.getName()+" [方法名]"+method.getName());
            iSysLogService.save(sysLog);
        }

    }


}
