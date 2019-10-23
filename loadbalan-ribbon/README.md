#### Ribbon组成
![image](https://github.com/firechiang/springcloud-test/blob/master/loadbalan-ribbon/image/ribbon-form.png)
#### Ribbon内置负载均衡规则
![image](https://github.com/firechiang/springcloud-test/blob/master/loadbalan-ribbon/image/ribbon-role.png)
#### RibbonRibbon配置方式
![image](https://github.com/firechiang/springcloud-test/blob/master/loadbalan-ribbon/image/ribbon-config.png)
```bash
# 服务名称
user-service:  
  ribbon:
    NFLoadBalancerRuleClassName: com.netflix.loadbalancer.RandomRule
    NFLoadBalancerPingClassName: com.netflix.loadbalancer.PingUrl
    
# 配置饿加载（默认是代码执行到了才加载，所以第一次可能会有点慢）
ribbon:
  eager-load:
    # 开启饿加载（推荐生产使用）
    enabled: true
    clients: user-service,xxx,xxx  
```
