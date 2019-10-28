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