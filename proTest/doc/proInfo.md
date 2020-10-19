# 项目说明：
**该项目包括以下内容：**
用户信息的增删改查操作
> ①用户的登录
> ②简单的列表查询，添加，删除，修改
> ③复杂功能，删除选中，分页查询,复杂条件查询

## 设计：
### 技术选型：
`Servlet+JSP+MySQL+JDBCTempleat+Duird+BeanUtilS+tomcat`
### 数据库设计：
```sql
create database jaPro;
use jaPro;
```
### 开发：
#### 环境搭建：
> ①创建项目，导入jar包
> ②创建数据库环境
##### 创建项目，导入jar包
WEB-INF下新建lib文件，导入jar包
##### 创建数据库环境
```sql
# 创建数据库
CREATE DATABASE japro;
use japro;

# 创建用户表，登录注册
DROP TABLE IF EXISTS `user`;
CREATE TABLE user(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(32) NOT NULL UNIQUE,
    password VARCHAR(32)
);

# 创建用户信息表，用户详细信息
DROP TABLE IF EXISTS `userInfo`;
CREATE TABLE userInfo(
     id int primary key auto_increment,
     name varchar(20) not null,
     gender varchar(5),
     age int,
     address varchar(32),
     qq	varchar(20),
     email varchar(50)
);
```    
### 1 模块一：用户登录
数据库中先保存admin/seafwg用户：
```sql
SELECT * FROM user;
INSERT INTO user VALUES(1,"admin","seafwg");
```
#### 1.1 修改项目默认加载login.jsp页面
**WEB-INF>web.xml中设置**
```xml
<!--在<web-app>中配置-->
<welcome-file-list>
    <welcome-file>login.jsp</welcome-file>
</welcome-file-list>
```