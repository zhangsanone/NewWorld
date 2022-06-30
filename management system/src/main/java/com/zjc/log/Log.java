package com.zjc.log;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * 自定义注解类
 * @Target({ElementType.PARAMETER, ElementType.METHOD})
 *    作用：用于描述注解的使用范围（即：被描述的注解可以用在什么地方）
 *    PARAMETER:用于描述参数 METHOD:用于描述方法
 *    @Retention(RetentionPolicy.RUNTIME)
 *    解释：@Retention()  定义了该Annotation（注释）被保留的时间长短
 *    RUNTIME:在运行时有效（即运行时保留）
 */

@Component
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    // 操作类型
    String operateType();
    // 操作解释
    String operateExplain();
}
