package org.mmybatis.spring;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/2/16 23:46
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    private static final String PATH = "com.calpis.interview.mmybatis.mapper";

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {
        MyBeanDefinitionScanner scanner = new MyBeanDefinitionScanner(registry);
        scanner.addIncludeFilter((metadataReader, metadataReaderFactory) -> true);
        scanner.scan(PATH);
    }
}
