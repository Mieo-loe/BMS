package com.tencent.util.advice;

import com.tencent.util.expection.ErrorExpection;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect //声明这是一个切面类
public class TxLog {

    private SqlSession sqlSession;
    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    /*配置切点（此处切点为所有的Implservice类）*/
    @Pointcut(value = "execution(* com.tencent.service.impl.*.*(..))")
    public void pst(){};

    public void before(){
    }
    public void after(){
        sqlSession.commit();
    }
    public void error(){
        sqlSession.rollback();
    }
    public void finall(){
        sqlSession.close();
    }

    @Around(value = "pst()")
    public Object tx(ProceedingJoinPoint proceedingJoinPoint) throws ErrorExpection {
        Object result=null;
        try {
            this.before();
            /*获得切点方法参数*/
            Object[] args=proceedingJoinPoint.getArgs();
            /*获得切点方法返回值*/
            result=proceedingJoinPoint.proceed(args);
            this.after();
        } catch (Throwable throwable) {
            this.error();
            throw new ErrorExpection("数据库出错了");
        }finally {
            this.finall();
        }
        return result;
    }

}
