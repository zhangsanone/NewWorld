package com.zjc.log;


import com.zjc.pojo.Logtable;
import com.zjc.repositories.LogTableRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 定义切面
 */

@Component
@Aspect
public class LogAopAspect {

    @Autowired
    private LogTableRepository logTableRepository;

    @Pointcut("execution(* com.cdu.zjc.controller.*.*(..))")
    private void pointCutAll(){}

    @Pointcut("execution(* com.cdu.zjc.controller.*.del*(..))")
    private void pointCutDel(){}

    @Pointcut("execution(* com.cdu.zjc.controller.*.find*(..))")
    private void pointCutFind(){}

    @Pointcut("execution(* com.cdu.zjc.controller.*.add*(..))")
    private void pointCutAdd(){}

    @Pointcut("execution(* com.cdu.zjc.controller.*.upd*(..))")
    private void pointCutMod(){}

    @After("pointCutDel() && pointCutAdd() && pointCutMod()")
    private void afterAdvice(JoinPoint joinPoint){
        try {
            String operationType = "";
            String operationExplain = "";

            //获取封装了署名信息的对象
            Signature signature = joinPoint.getSignature();
            //目标方法名
            String methodName = signature.getName();
            //目标方法所属类的简单类名
            String simpleName = signature.getDeclaringType().getSimpleName();
            //获取传入目标方法的参数对象
            Object target = joinPoint.getTarget();
            //获取当前代理类的全限定名
            String targetName = joinPoint.getTarget().getClass().getName();
            //获取传入目标方法的参数对象
            Object[] args = joinPoint.getArgs();
            Class<?> aclass = null;
            try {
                aclass = Class.forName(targetName);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            Method[] methods = aclass.getMethods();
            for (int i = 0; i < methods.length; i++) {
                if (methods[i].getName() != methodName) {continue;}
                Class<?>[] clazzs = methods[i].getParameterTypes();
                if (clazzs.length == args.length){
                    //获取指定类名的注解
                    operationType = methods[i].getAnnotation(Log.class).operateType();
                    operationExplain = methods[i].getAnnotation(Log.class).operateExplain();
                    break;
                }
            }
            System.out.println("署名信息的对象:"+signature);
            System.out.println("目标方法所属类的简单类名:"+simpleName);
            System.out.println("获取传入目标方法的参数对象:"+target);

            System.out.println("代理类："+targetName);
            System.out.println("方法名:"+methodName);
            System.out.println("操作类型:"+operationType);
            System.out.println("操作解释:"+operationExplain);

            System.out.println("---------------------------开始保存日志----------------------------------");

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-HH-dd hh:mm:ss");
            String date = dateFormat.format(new Date());
            Logtable logtable = new Logtable();

            logtable.setOperateClassName(targetName);      //方法所在类名
            logtable.setOperateMethodName(methodName);     //执行的方法
            logtable.setOperateType(operationType);        //操作类型
            logtable.setOperateExplain(operationExplain);    //操作说明
            logtable.setOperateUser("超级管理员");         //操作人
            logtable.setOperateDate(date);                 //执行的时间
            logtable.setOperateResult("");
            logtable.setRemark("");
            logTableRepository.save(logtable);
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    @Before("pointCutFind()")
    private void beforeAdvice(JoinPoint joinPoint){
        try {
            String operationType = "";
            String operationExplain = "";

            //获取封装了署名信息的对象
            Signature signature = joinPoint.getSignature();
            //目标方法名
            String methodName = signature.getName();
            //目标方法所属类的简单类名
            String simpleName = signature.getDeclaringType().getSimpleName();
            //获取传入目标方法的参数对象
            Object target = joinPoint.getTarget();
            //获取当前代理类的全限定名
            String targetName = joinPoint.getTarget().getClass().getName();
            //获取传入目标方法的参数对象
            Object[] args = joinPoint.getArgs();
            Class<?> aclass = null;
            try {
                aclass = Class.forName(targetName);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            Method[] methods = aclass.getMethods();
            for (int i = 0; i < methods.length; i++) {
                if (methods[i].getName() != methodName) {continue;}
                Class<?>[] clazzs = methods[i].getParameterTypes();
                if (clazzs.length == args.length){
                    //获取指定类名的注解
                    operationType = methods[i].getAnnotation(Log.class).operateType();
                    operationExplain = methods[i].getAnnotation(Log.class).operateExplain();
                    break;
                }
            }
            System.out.println("署名信息的对象:"+signature);
            System.out.println("目标方法所属类的简单类名:"+simpleName);
            System.out.println("获取传入目标方法的参数对象:"+target);

            System.out.println("代理类："+targetName);
            System.out.println("方法名:"+methodName);
            System.out.println("操作类型:"+operationType);
            System.out.println("操作解释:"+operationExplain);

            System.out.println("---------------------------开始保存日志----------------------------------");

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-HH-dd hh:mm:ss");
            String date = dateFormat.format(new Date());
            Logtable logtable = new Logtable();

            logtable.setOperateClassName(targetName);      //方法所在类名
            logtable.setOperateMethodName(methodName);     //执行的方法
            logtable.setOperateType(operationType);        //操作类型
            logtable.setOperateExplain(operationExplain);    //操作说明
            logtable.setOperateUser("超级管理员");         //操作人
            logtable.setOperateDate(date);                 //执行的时间
            logtable.setOperateResult("");
            logtable.setRemark("");
            logTableRepository.save(logtable);
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    //异常通知
    @AfterThrowing(value = "pointCutAll()",throwing = "e")
    public void exceptionAdvice(JoinPoint joinPoint,Throwable e){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        //读取session中的用户
        Object user = session.getAttribute("user");
        //请求的IP
        String ip = request.getRemoteAddr();
        String params = "";
        if (joinPoint.getArgs() != null && joinPoint.getArgs().length > 0) {
            params= Arrays.toString(joinPoint.getArgs());
        }
        System.out.println(params);
        try {
            String operationType = "";
            String operateExplain = "";
            //获取传入目标方法的参数对象
            Object[] args = joinPoint.getArgs();
            //目标方法所属类的简单类名
            String simpleName = joinPoint.getSignature().getDeclaringType().getSimpleName();
            //获取方法名
            String methodName = joinPoint.getSignature().getName();
            //获取类的全限定名
            String targetName = joinPoint.getTarget().getClass().getName();

            //获取该类的Class对象
            Class<?> clazz = null;
            try {
                clazz = Class.forName(targetName);
            } catch (ClassNotFoundException ee) {
                ee.printStackTrace();
            }
            Method[] methods = clazz.getMethods();
            for (int i = 0; i < methods.length; i++) {
                if (methods[i].getName() != methodName){continue;}

                Class<?>[] parameterTypes = methods[i].getParameterTypes();
                if (parameterTypes.length == args.length){
                    Log annotation = methods[i].getAnnotation(Log.class);
                    operationType = annotation.operateType();
                    operateExplain = annotation.operateExplain();
                    break;
                }
            }
            System.out.println("---------------------------开始保存日志----------------------------------");

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-HH-dd hh:mm:ss");
            String date = dateFormat.format(new Date());
            Logtable logtable1 = new Logtable();

            logtable1.setOperateClassName(targetName);      //方法所在类名
            logtable1.setOperateMethodName(methodName);     //执行的方法
            logtable1.setOperateType(operationType);        //操作类型
            logtable1.setOperateExplain(operateExplain);    //操作说明
            logtable1.setOperateUser("超级管理员");         //操作人
            logtable1.setOperateDate(date);                 //执行的时间
            logtable1.setOperateResult("删除失败,异常代码"+e.getClass().getName() +"异常信息："+e.getMessage());
            logtable1.setRemark("");
            logTableRepository.save(logtable1);
        }catch (Exception ee){
            ee.printStackTrace();
        }
    }


}
