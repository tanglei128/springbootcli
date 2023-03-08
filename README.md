# springbootcli
springbootcli是一个基于springboot2.x的脚手架
### 版本管理tag
_使用tag进行管理，记录最小化/最轻量级的脚手架的变更_
- release:mybatis-plus



本脚手架包含：
### 集成的常用工具
- mysql5.7
- Mybatis-plus
- 分页处理
- knife4j在线文档
````
#springboot2.6及其以上版本需要设置,才能正确启用knife4j 
spring:
  application:
    name: auth
  mvc:
    pathmatch:
      matching-strategy: ant_path_matcher
  ````

### 自定义处理
- 自定义异常
- 自定义返回类
- 自定义报错码

### 待集成
- redis （尽可能做成开关形式，是否开启）
- log4j （注意win和mac的区别，最好是使用application-win.yml进行区分）
- 全局异常处理
- token校验
- shiro安全框架


