# Licsber's QBot

## 使用说明

简单的按照官方给的文档开发了一个传话筒。

只需要clone下来本项目，利用maven打包即可一键运行。

springboot配置文件参考：

> application.yml :

```yaml
server:
  port: 46087
bot:
  qid: XXX
  password: XXX
```

## 功能说明

接收POST请求，可以转发POST请求中对好友和对群聊的文本消息到QQ。

本项目开发的目的是同步部分自动化工具的信息到QQ这个平台。

因为QQ的接口特性不方便随用随登，所以这个项目采取始终运行，只参与接口信息转发，不参与业务逻辑。

本项目可以作为示例项目，应该可以说是最小的marai的hello-world了，总共代码量不超过十行。

作者刚学kotlin，对一些用法可能不太熟练，如果有问题欢迎PR。
