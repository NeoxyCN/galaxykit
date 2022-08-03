# 前言
GalaxyKit插件的配置文件均使用TOML，务必遵守其语法。  
该指南将按照galaykit文件夹中的各个配置文件进行介绍。

## group 用户组
### 该部分主要针对group.toml 
```
group = [
    "admin",
    "default",
]
```
此处主要填写所有用户组。
```
admin = [
    "NeoxyCN"
]
```
此处填写该用户组下有哪些用户  
注意，此处```admin```务必与```group```内保持一致  
此外，每个" "之间应有```,```作为分割，可换行。  
注意！若某个用户没有被分配到任意组中，那么GalaxyKit将默认他为default组成员，所以强烈不建议删除default组。  

## permission 权限控制  
### 该部分主要针对permission.toml  
还记得上面提到的组的概念吗，这个文件主要是对组的权限进行进一步限定。  
```
admin = [
    "ban",
    "banip",
]
```
此处列举admin组的所有权限。可自行修改。建议参照该目录下的permission（没有后缀的那个文件）进行填写。  
注意，此处填写的都是改组拥有的权限！

## config 配置文件
### 该部分针对config.toml  
auto-update 自动更新 暂未实现。 true 开启 false关闭  
channel 更新渠道 暂未实现 默认stable稳定版  
language 语言 暂未实现 zh-CN为中国简体 en-US为英文（美国），为防止乱码，默认采用en-US。  