package com.calpis.interview.base.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author Zhujialiang
 * @version V1.0
 * @Description
 * @Date 2021/2/19 15:48
 * @Copyright Copyright © 2020 深圳花儿绽放网络科技股份有限公司. All rights reserved.
 */
@Component
public class BeanFactoryProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        AbstractBeanFactory abstractBeanFactory = (AbstractBeanFactory) beanFactory;
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("a");
    }
}
