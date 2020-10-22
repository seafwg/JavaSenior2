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
#### 1.2 编写实体类
**注意：**
> ①属性应该对应数据库中的属性
> ②实体类的属性和前端表单的name值对应

#### 1.3 编写dao层：
> ①定义dao层接口UserDao -- User login(User user)
> ②实现dao层的接口UserDaoImpl -- USer login(User user) {使用连接池连接对象，查询数据，封装数据}
> ③进行测试

#### 1.4 编写service层
> ①定义service层接口UserService -- xxx
> ②实现UserService接口 -- xxx{调用dao层实现的方法}

#### 1.5 编写servlet层
> ①验证码的编写
> ②登录servlet的编写：数据获取，封装对象，调用service层方法进行比较，根据返回信息返回跳转，提示信息

### 登录功能总结以及出现的问题： 
①前端页面调整： 
②LoginServlet中验证码部分，用户数据获取，封装调用ServiceImpl中的方法login 
③UserService接口，ServiceImpl方法实现 
④UserDao接口实现，UserDaoImpl方法实现 
**遇到的问题：**
LoginServlet,获取用户数据后的封装要确保input中的name属性和实体类中的属性一致，不然无法获取。


### 2 模块二：查询所有的表格数据
#### 2.1 创建数据库userinfo
```sql
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

INSERT INTO userinfo VALUES (null,"admin","男",23,"甘肃","1004951923","1004951923@qq.com");
INSERT INTO userinfo VALUES (null,"seafwg","男",23,"北京","1004951923","1004951923@qq.com");
INSERT INTO userinfo VALUES (null,"王琦","男",23,"甘肃","1004951923","1004951923@qq.com");
INSERT INTO userinfo VALUES (null,"intelwisd","男",23,"杭州","1004951923","1004951923@qq.com");
INSERT INTO userinfo VALUES (null,"smallwun","男",23,"甘肃","1004951923","1004951923@qq.com");
INSERT INTO userinfo VALUES (null,"王五","男",23,"西安","1004951923","1004951923@qq.com");
INSERT INTO userinfo VALUES (null,"张三","男",23,"甘肃","1004951923","1004951923@qq.com");
INSERT INTO userinfo VALUES (null,"李四","男",23,"广州","1004951923","1004951923@qq.com");
INSERT INTO userinfo VALUES (null,"赵四","男",23,"甘肃","1004951923","1004951923@qq.com");
INSERT INTO userinfo VALUES (null,"郑九","男",23,"临洮","1004951923","1004951923@qq.com");
INSERT INTO userinfo VALUES (null,"邓世昌","男",53,"广州","1004951923","1004951923@qq.com");
INSERT INTO userinfo VALUES (null,"大圣","男",33,"甘肃","1004951923","1004951923@qq.com");
```
#### 2.2 创建实体类UserInfo
#### 2.3 编写UserInfoDao接口，声明查询所有用户信息的方法，编写UserInfoDaoImpl类实现查询所有用户信息的方法
#### 2.4 编写UserInfoService接口，声明查询所有用户信息的方法，编写UserInfoServiceImpl类实现查询所有用户的方法
#### 2.5 发送查询的servlet,创建UserInfoServiceImpl类，调用查询所有用户信息的方法

### 3 表格数据修改一行：