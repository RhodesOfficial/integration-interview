package org.mmybatis.spring;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/2/17 0:07
 */
public class MyFactoryBean implements FactoryBean {

    private Class mapperClass;

//    private SqlSession sqlSession;

    public MyFactoryBean(Class mapperClass) {
        this.mapperClass = mapperClass;
    }

//    @Autowired
//    public void setSqlSession(SqlSessionFactory sqlSessionFactory) {
//        this.sqlSession = sqlSessionFactory.openSession();
//    }

    @Override
    public Object getObject() {
        return Proxy.newProxyInstance(MyFactoryBean.class.getClassLoader(), new Class[]{mapperClass}, (proxy, method, args) -> null);
    }

    @Override
    public Class<?> getObjectType() {
        return mapperClass;
    }
}
