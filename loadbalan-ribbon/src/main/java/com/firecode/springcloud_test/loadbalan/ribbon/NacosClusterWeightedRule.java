package com.firecode.springcloud_test.loadbalan.ribbon;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.cloud.nacos.ribbon.NacosServer;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.alibaba.nacos.client.naming.core.Balancer;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.Server;

import lombok.extern.slf4j.Slf4j;

/**
 * 扩展Ribbon-支持Nacos权重并同一集群优先调用.
 */
@Slf4j
public class NacosClusterWeightedRule extends AbstractLoadBalancerRule {
    
    @Autowired
    private NacosDiscoveryProperties nacosDiscoveryProperties;
    
    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {
        //读取配置文件，并初始化
    }

    @Override
    public Server choose(Object o) {
        try {
        	// 配置文件中的集群名称
        	String clusterName = nacosDiscoveryProperties.getClusterName();
        	
        	
            BaseLoadBalancer loadBalancer = (BaseLoadBalancer) this.getLoadBalancer();
            //想要请求的微服务名称
            String name = loadBalancer.getName();
            //实现负载均衡算法
            //拿到服务发现相关API
            NamingService namingService = nacosDiscoveryProperties.namingServiceInstance();
            // 获取健康的实例
            List<Instance> selectInstances = namingService.selectInstances(name, true);
            // 获取相同集群的服务
            List<Instance> collect = selectInstances.stream().filter(i->{
            	return Objects.deepEquals(i.getClusterName(), clusterName);
            }).collect(Collectors.toList());
            // 如果同一集群有服务，就是使用同一集群下的服务
            if(!CollectionUtils.isEmpty(collect)) {
            	selectInstances = collect;
            }else {
            	System.err.println("跨集群调用");
            }
            //nacos client自动通过基于权重的负载均衡算法，给我们选择一个实例。
            Instance instance = SimpleLoadBan.getHostByRandomWeight1(selectInstances);
            log.info("选择的实例是：port = {}, instance = {}", instance.getPort(), instance);
            return new NacosServer(instance);
        } catch (NacosException e) {
            log.error("选择实例异常：{}", e.getMessage(), e);
            return null;
        }
    }
    
    private static final class SimpleLoadBan extends Balancer {
    	
    	public static Instance getHostByRandomWeight1(List<Instance> hosts) {
    		
    		return getHostByRandomWeight(hosts);
    	}
    }
}
