package com.jt.common.aspect;

import java.lang.reflect.Method;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jt.common.anno.RequestLog;
import com.jt.common.util.IPUtils;
import com.jt.sys.dao.SysLogDao;
import com.jt.sys.entity.SysLog;
import com.jt.sys.entity.SysUser;
import com.jt.sys.service.realm.ShiroUserRealm;
@Order(1)
@Aspect
@Component
public class SysLogAspect {
	@Autowired
	private SysLogDao sysLogDao;
	private Logger log=Logger.getLogger(SysLogAspect.class);
	@Pointcut("@annotation(com.jt.common.anno.RequestLog)")
	public void logPointCut() {	}

	@Around("logPointCut()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime=System.currentTimeMillis();
		//执行目标方法
		Object result = joinPoint.proceed();
		long endTime=System.currentTimeMillis();
		long totalTime=endTime-startTime;
		log.info("方法执行的总时长为"+totalTime);
		saveSysLog(joinPoint,totalTime);
		return result;
	}

	private void saveSysLog(ProceedingJoinPoint point, long totalTime) throws JsonProcessingException, NoSuchMethodException, SecurityException {
		//获取信息
		MethodSignature ms=
				(MethodSignature)point.getSignature();
		Class<?> targetClass=
				point.getTarget().getClass();
		String className=targetClass.getName();
		//获取接口声明的方法
		String methodName=ms.getMethod().getName();
		Class<?>[] parameterTypes=ms.getMethod().getParameterTypes();
		//获取目标对象方法
		Method targetMethod=targetClass.getDeclaredMethod(
				methodName,
				parameterTypes);
		//判定目标方法上是否有RequestLog注解
		boolean flag=
				targetMethod.isAnnotationPresent(RequestLog.class);
		SysUser name=
				(SysUser)SecurityUtils.getSubject().getPrincipal();
		String username = name.getUsername();
		//获取方法参数
		Object[] paramsObj=point.getArgs();
		System.out.println("paramsObj="+paramsObj);
		//将参数转换为字符串
		String params=new ObjectMapper()
				.writeValueAsString(paramsObj);
		//2.封装日志信息
		SysLog log=new SysLog();
		log.setUsername(username);//登陆的用户
		//假如目标方法对象上有注解,我们获取注解定义的操作值
		if(flag){
			RequestLog requestLog=
					targetMethod.getDeclaredAnnotation(RequestLog.class);
			log.setOperation(requestLog.value());
		}
		log.setMethod(className+"."+methodName);//className.methodName()
		log.setParams(params);//method params
		log.setIp(IPUtils.getIpAddr());//ip 地址
		log.setTime(totalTime);//
		log.setCreateDate(new Date());
		//3.保存日志信息
		sysLogDao.insertObject(log);





	}





}
