# 在IDEA中配置Tomcat服务器

1.找到配置，创建新的配置

<img src="assets/image-20241202144345597.png" alt="image-20241202144345597" style="zoom:50%;" />

2.新建Tomcat服务器配置

<img src="assets/image-20241202144431835.png" alt="image-20241202144431835" style="zoom:30%;" />

3.配置内容

- 服务器：找到你下载的Tomcat放置的目录；
- 设定浏览器和地址，URL是根目录

<img src="assets/image-20241202144822575.png" alt="image-20241202144822575" style="zoom:33%;" />

4.补充模块的部署，IDEA虽然配置了Tomcat应用环境，但是我们生成的组件不再环境内，需要我们自己添加进去。

![image-20241202152015501](assets/image-20241202152015501.png)

5.配置项目应用路径，就根目录就行

![image-20241202152102943](assets/image-20241202152102943.png)

6.点击试着启动Tomcat吧，不需要再./startup.sh啦。