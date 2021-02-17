package org.mmybatis.spring;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/2/17 0:07
 */
public class MyFactoryBean implements FactoryBean {

    private Class mapperClass;

    private SqlSession sqlSession;

    public MyFactoryBean(Class mapperClass) {
        this.mapperClass = mapperClass;
    }

    @Autowired
    public void setSqlSession(SqlSessionFactory sqlSessionFactory) {
        this.sqlSession = sqlSessionFactory.openSession();
    }

    @Override
    public Object getObject() {
        return sqlSession.getMapper(mapperClass);
    }

    @Override
    public Class<?> getObjectType() {
        return mapperClass;
    }
}
