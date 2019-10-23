package com.firecode.springcloud_test.loadbalan.ribbon;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.ribbon.NacosServer;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.Server;

import lombok.extern.slf4j.Slf4j;

/**
 * 扩展Ribbon-支持Nacos权重
 */
@Slf4j
public class NacosWeightedRule extends AbstractLoadBalancerRule {
    
    @Autowired
    private NacosDiscoveryProperties nacosDiscoveryProperties;
    
    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {
        //读取配置文件，并初始化
    }

    @Override
    public Server choose(Object o) {
        try {
            BaseLoadBalancer loadBalancer = (BaseLoadBalancer) this.getLoadBalancer();
            //想要请求的微服务名称
            String name = loadBalancer.getName();
            //实现负载均衡算法
            //拿到服务发现相关API
            NamingService namingService = nacosDiscoveryProperties.namingServiceInstance();
            //nacos client自动通过基于权重的负载均衡算法，给我们选择一个实例。
            Instance instance = namingService.selectOneHealthyInstance(name);
            
            log.info("选择的实例是：port = {}, instance = {}", instance.getPort(), instance);
            return new NacosServer(instance);
        } catch (NacosException e) {
            log.error("选择实例异常：{}", e.getMessage(), e);
            return null;
        }
    }
}
