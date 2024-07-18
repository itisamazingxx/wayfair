# 家居电商平台
1. 后台采用经典分层结构: Web-Service-DAO-Entity
2. MVC

   MVC是用来指导Web层的代码如何有效分离单独工作

   View∶ 只负责数据和界面的显示 不接受任何与显示数据无关的代码 (Vue/JSP/Thymeleaf/HTML)

   Controller∶只负责接收请求 调用业务层的代码处理请求 然后派发页面 (Servlet)

   Model∶ 将与业务逻辑相关的数据封装为具体的JavaBean类 其中不掺杂任何与数
   据处理相关的代码 (JavaBean/Domain/Pojo)

### Configuration
1. /WEB-INF/web.xml 是Java Web应用程序的配置文件
2. 通常位于Web应用程序的WEB-INF目录下

### 为什么要把JAR包放入WEB-INF/lib目录下
1. 这一步相当于手动添加依赖库（dependency

### 创建MVC
1. src下创建文件

### 搭建静态页面
1. 复制前端代码到web下
2. 为index.html配置tomcat
3. 此时如果没有看到任何工件 可以创建一个exploded工件(File -> Project Structure)
4. 点击上方的+按钮 选择Web Application:Exploded
5. 继续重复步骤2

### 配置Servlet
1. web.xml下配置java中想用的Servlet class
2. Servlet最好统一集中管理, 根据业务进行合并(用户注册/登录用一个Servlet)

## 功能

### 功能1: 用户注册/登录

**数据库中用户表单如下**

```mysql
-- 删除现有的数据库 如果存在
DROP DATABASE IF EXISTS wayfair;

-- 创建一个新的数据库
CREATE DATABASE wayfair;

-- 使用刚创建的数据库
USE wayfair;

-- 创建user表
CREATE TABLE `user` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `user_name`VARCHAR(32) NOT NULL UNIQUE,
    `password` VARCHAR(32) NOT NULL,
    `email` VARCHAR(64)
) CHARACTER SET utf8 ENGINE=INNODB;

-- 插入数据到 user 表中
INSERT INTO `user` (`user_name`, `password`, `email`) VALUES
    ('john123', 'password123', 'john.doe@example.com'),
    ('jane123', 'securepassword', 'jane.doe@example.com'),
    ('sam123', 'mypassword', 'sam.smith@example.com');
```

#### 用户注册

需求分析:

1. **新用户注册时 需对请求用户输入内容进行校验**

   验证用户名: 必须由字母, 数字, 下划线组成; 长度为6-10 (正则表达式)

   验证密码: 必须由字母, 数字, 下划线组成; 长度为6-10

   将前端login.jsp页面中的sign-up-btn绑定

   使用jQuery库写一段javascript


2. **校验通过后, 提交给服务器检查用户名在数据库是否存在**

   在前端login.jsp中用户注册部分添加指定接收action的servlet (userServlet)
   
   servlet接收到指定action (userServlet接收到register指令)

   调用Service层对数据库的操作 (userService调用DAO层对数据库的连接)


#### 用户登录

需求分析:

1. **用户输入用户名密码 提交后由服务器验证是否存在**

   在前端login.jsp中用户注册部分添加指定接收action的servlet (userServlet)

   提交后该servlet会接收到用户request中的参数信息 (需与前端input栏中名字一样)

   调用Service层对数据库的操作 (根据username password查询单行结果)

   如果用户存在 即可登陆成功 (转发页面到login_ok.html)

   如果用户不存在 给出错误信息 重新登陆


### 功能2: 管理员

**管理员数据库表单**
```mysql
DROP TABLE IF EXISTS Admin;

CREATE TABLE Admin (
    id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    user_name VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
) CHARACTER SET utf8 ENGINE=INNODB;

INSERT INTO Admin (user_name, password)
VALUES ('admin', '123456');
```

需求分析:

1. **为了给后台管理者提供对应的商品库存/信息修改页面**

   此页面应为后台管理者单独登录 不对外公开

   登录成功后, 显示家具管理和订单管理的页面(manage_menu.jsp)

   管理员点击家具管理 显示所有家具信息 (在前端直接调用servlet中的方法)

### 功能3: 家具后台系统管理

家具表

```mysql
CREATE TABLE `furniture` (
    `id` INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(64) NOT NULL UNIQUE,
    `manufacturer` VARCHAR(32) NOT NULL,
    `price` DECIMAL(11, 2) NOT NULL,
    `sales` INT UNSIGNED NOT NULL,
    `stock` INT UNSIGNED NOT NULL,
    `img` VARCHAR(256) NOT NULL
) CHARACTER SET utf8 ENGINE=INNODB;

-- 插入数据
INSERT INTO `furniture` (`name`, `manufacturer`, `price`, `sales`, `stock`, `img`)
VALUES
    ('Classic Chair', 'WoodCrafters', 150.00, 30, 50, 'images/classic_chair.png'),
    ('Modern Sofa', 'ComfyHome', 850.00, 20, 10, 'images/modern_sofa.png'),
    ('Elegant Table', 'DesignsRUs', 450.00, 15, 25, 'images/elegant_table.png');
```

#### 显示家具
需求分析:
1. 管理员登录成功后进入到管理页面, 显示家居管理展示全部家具
2. 家具管理按钮添加关于furnitureServlet的action, 直接调用其方法

#### 添加家具
需求分析:
1. 管理员进入到家居管理页面
2. 点击添加家具, 家具添加完成后跳转回furn_manage界面

#### 删除家具
需求分析:
1. 管理员进入到家居管理页面
2. 点击删除家具button, 前端提示"是否删除"的确认信息
3. 点击确认即可删除数据库数据

#### 修改家具
需求分析:
1. 管理员进入到家居管理页面
2. 点击商品末尾的小铅笔即进入该商品的单独修改页面 (furn_update.jsp回显)
3. 重新填写需要修改的信息, 点击确认修改后将新信息提交到数据库

### 功能3: 分页管理
#### 后台分页管理
需求分析:
1. 将前端家具页面分页显示
2. 为每页所展示的商品作数量限定, 制定分页查询
3. (将page作为一个Bean Entity), 把每页要展示的商品信息整体当做一个对象传输
4. 完成"上页下页", "总页数", "点击切换到指定页面"等功能
5. 删除/修改/ 添加制定家具后回到原页面

#### 首页分页管理
需求分析:
1. 为首页商品分类, 用户不登录/注册也可以浏览商品
2. 由CustomerFurnitureServlet负责
3. 其余功能实现与后台分页管理相似

### 功能4: 首页搜索

### 功能3: 验证码
需求分析:
1. 验证码可以解决用户表单重复提交的情况
2. 防止恶意注册

实现步骤:
1. 按需求选择不同公司的验证码实现(自己下载jar包添加), web.xml中配置


### 功能4: 购物车
需求分析:
1. 当用户登录后, 可以添加产品到购物车
2. 需要在这个模块完成购物车功能的实现
3. 每添加一个家具(每个产品有add to cart标识), 购物车的数量+1, 并显示