# multi-datasource

#### 项目介绍
多数据源动态切换示例
a.基于AOP动态切换;
b.配置 MapperScan ,不同的包使用不同的数据源

#### 软件架构
SpringBoot + MyBatis Plus + MySql +Druid + JDK1.8
参考： http://baomidou.oschina.io/mybatis-plus-doc/#/multi-datasource?id=%e5%a4%9a%e6%95%b0%e6%8d%ae%e6%ba%90%e4%bd%bf%e7%94%a8-spring-abstractroutingdatasource-%e5%ae%9e%e7%8e%b0

#### 使用说明
1. 在application-{dev}.yml中配置多数据源
2. 控制数据源切换的方式有三种
   * 手动控制:在需要切换数据源的代码初,编程式设置 DbContextHolder.setDbType(DBTypeEnum.db1);
   * 使用注解@DataSourceSwitch在类或方法上声明数据源
   * 由AOP自动控制数据源切换
   remark:以上设置的优先级由高到低
3. 特别注意:因为这里使用了MyBatis Plus,假设目前有两个数据源db1,db2,AOP切面的包路径分别为
   com.hong.service.db1和com.hong.service.db2,如果设置了db1为默认数据源,则需要在
   com.hong.service.db1的service实现类中显示的声明任何业务方法,而不能直接调用MyBatis Plus提供好的模板方法(???)
