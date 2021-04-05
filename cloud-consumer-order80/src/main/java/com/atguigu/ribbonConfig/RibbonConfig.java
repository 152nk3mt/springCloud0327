package com.atguigu.ribbonConfig;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName RibbonConfig
 * @Author cy
 * @Date 2021/3/28 11:51
 * @Description TODO
 * @Version 1.0
 **/
@Configuration
public class RibbonConfig {
    @Bean
    public IRule getRibbon(){
        return new RandomRule();
    }
}

