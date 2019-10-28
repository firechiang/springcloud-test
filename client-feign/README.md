#### Feign 组成部分
接口  | 作用 | 默认值
---- | ----- | ------ 
Feign.Builder  | Feign的入口 | Feign.Builder
Client  | Feign底层用什么去请求 | 和Ribbon配置使用时：LoadBalancerFeignClient，不和Ribbon配合时：Feign.Client.Default
Contract  | 注解支持 | SpringMVCContract（用于支持MVC的注解）
Encoder  | 编码器，用于将对象转换成HTTP请求消息体 | SpringEncoder
Decoder  | 解码器，用于将响应消息体转换成对象 | ResponseEntityDecoder
Logger  | 日志管理器 | Slf4jLogger
RequestInterceptor  | 请求拦截器，用于对每个请求添加通用逻辑 | 无

#### Feign 日志级别（注意：Feign的日志级别需先配置logging:level:com.firechiang=debug（一定是debug），再配置Feign的日志级别，否则无法生效）
级别  | 打印内容
---- | -----
NONE（默认值）  | 不记录任何日志
BASIC（推荐生产使用）  | 仅记录请求方法，URL，响应状态码以及执行时间
HEADERS  | 在记录BASIC级别的基础之上，再记录请求和响应的header
FULL（推荐开发使用）  | 记录请求和响应的header，body和元数据

#### Feign 配置项说明
配置项  | 作用
---- | -----
Logger.Level  | 指定日志级别
Retryer  | 指定重试策略
ErrorDecoder  | 指定错误解码器
Request.Options | 可指定超时时间
Collection<RequestInterceptor> | 请求拦截器
SetterFactory | 用于设置Hystrix的配置属性，Feign整合Hystrix才会有用
