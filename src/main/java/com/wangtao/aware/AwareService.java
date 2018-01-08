package com.wangtao.aware;

import com.fasterxml.jackson.databind.util.ISO8601Utils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by want on 2018-1-8.
 */
@Service
public class AwareService implements BeanNameAware, ResourceLoaderAware {
    private String beanName;
    private ResourceLoader resourceLoader;

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public void outputResult() throws IOException {
        System.out.println("beanName = " + beanName);
        Resource resource = resourceLoader.getResource("classpath:wangtao/aaa.txt");
        System.out.println("文件内容 = " + IOUtils.toString(resource.getInputStream()) );
    }
}
