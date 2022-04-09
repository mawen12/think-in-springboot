package com.mawen.demo.aspect;

import com.mawen.demo.annotation.Log;
import com.mawen.demo.dao.SysLogDao;
import com.mawen.demo.domain.SysLog;
import com.mawen.demo.util.HttpContextUtils;
import com.mawen.demo.util.IpUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Component
public class LogAspect {

    @Autowired
    private SysLogDao sysLogDao;

    @Pointcut("@annotation(com.mawen.demo.annotation.Log)")
    public void pointCut() {

    }

    @Around("pointCut()")
    public void around(ProceedingJoinPoint point) {
        long beginTime = System.currentTimeMillis();
        try {
            point.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        long cost = System.currentTimeMillis() - beginTime;
        saveLog(point, cost);
    }

    private void saveLog(ProceedingJoinPoint point, long cost) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        SysLog sysLog = new SysLog();
        if (method.isAnnotationPresent(Log.class)) {
            sysLog.setOperation(method.getAnnotation(Log.class).value());
        }
        // 请求的方法名
        String className = point.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLog.setMethod(className + "." + methodName + "()");
        // 请求的方法参数
        Object[] args = point.getArgs();
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        String[] paramNames = u.getParameterNames(method);
        if (args != null && paramNames != null) {
            StringBuilder params = new StringBuilder();
            for (int i = 0; i < args.length; i++) {
                params.append(" ").append(paramNames[i]).append(": ").append(args[i]);
            }
            sysLog.setParams(params.toString());
        }
        // 获取Request
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        sysLog.setIp(IpUtils.getIpAddr(request));
        sysLog.setUsername("mawen");
        sysLog.setTime((int) cost);
        Date date = new Date();
        sysLog.setCreateTime(date);
        sysLogDao.saveSysLog(sysLog);
    }

}
