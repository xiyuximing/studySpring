# Spring

## 1、概述

### 1.1、spring优势

- **方便解耦，简化开发**

  通过IOC容器

- **AOP编程支持**

- **声明式事务**

  @Transactional
  可以将我们从单调烦闷的事务管理代码中解脱出来，通过声明式⽅式灵活的进⾏事务的管理，提⾼
  开发效率和质量

- **方便程序的测试**

- **方便集成各种优秀的框架**

- **降低JAVAEE API的使用难度**

- 源码设计精妙，结构清晰。

### 1.2、Spring核心结构

![image-20201005150442468](C:\Users\Yang\AppData\Roaming\Typora\typora-user-images\image-20201005150442468.png)

**采用模块化**，分为以下几个模块：

- **Spring核⼼容器（Core Container）：**容器是Spring框架最核⼼的部分，它管理着Spring应⽤中bean的创建、配置和管理。在该模块中，包括了Spring bean⼯⼚，它为Spring提供了DI的功能。基于bean⼯⼚，我们还会发现有多种Spring应⽤上下⽂的实现。所有的Spring模块都构建于核⼼容器之上
- **⾯向切⾯编程（AOP）/Aspects Spring模块：**对⾯向切⾯编程提供了丰富的⽀持。这个模块是Spring应⽤系统中开发切⾯的基础，与DI⼀样，AOP可以帮助应⽤对象解耦。
- **数据访问与集成（Data Access/Integration）模块：**
  Spring的JDBC和DAO模块封装了⼤量样板代码，这样可以使得数据库代码变得简洁，也可以更专注于我们的业务，还可以避免数据库资源释放失败⽽引起的问题。 另外，Spring AOP为数据访问提供了事务管理服务，同时Spring还对ORM进⾏了集成，如Hibernate、MyBatis等。该模块由JDBC、Transactions、ORM、OXM 和 JMS 等模块组成。
- **Web模块：** 该模块提供了SpringMVC框架给Web应⽤，还提供了多种构建和其它应⽤交互的远程调⽤⽅案。 SpringMVC框架在Web层提升了应⽤的松耦合⽔平。
- **Test模块：** 为了使得开发者能够很⽅便的进⾏测试，Spring提供了测试模块以致⼒于Spring应⽤的测试。 通过该模块，Spring为使⽤Servlet、JNDI等编写单元测试提供了⼀系列的mock对象实现。

##  2、核心思想

### 第一节、IOC

#### 1.1、什么是IOC

​	IOC(Inversion of Control)控制反转，是一个思想，不是技术实现。

​	描述的事情：java开发领域对象的创建、管理的问题

​	传统的开发方式：类A依赖于类B， A a = new B();

​	IOC思想开发方式：我们不用自己去new对象，而是由IOC容器去帮助我们实例化对象并管理他，我们需要那个对象，去问IOC容器（如spring）即可。我们不需要考虑对象的创建管理等一系列工作。

​	为什么叫控制反转？

​	控制：对对象的创建（实例化、管理的权利）

​	反转：控制权交给IOC容器了

![image-20201005153436169](C:\Users\Yang\AppData\Roaming\Typora\typora-user-images\image-20201005153436169.png)



#### 1.2 、IOC解决了什么问题

**解决了对象的耦合**

#### 1.3、IOC和DI的区别

**DI：**依赖注入（Dependancy Injection）

IOC是站在对象角度，对象实例化及管理的权利交给了容器。

DI是站在容器的角度，容器会把对象依赖的其他对象注入，比如A对象实例化的过程中，声明了一个B类型的属性，那么容器就需要把B对象注入给A。

### 第二节、AOP

#### 2.1 什么是AOP

AOP：Aspect oriented Programming 面向切面编程

AOP是OOP的延续。

OOP的三大特征：封装、继承、多态。

OOP编程思想可以解决大多数的代码重复问题，但是有一些情况处理不了的，比如在顶级父类中的多个方法中相同位置出现了重复代码，OOP就解决不了。

**横切逻辑代码：**在多个纵向流程中出现的相同子流程代码，称之为横切逻辑代码。

横切逻辑代码的使用场景有限：事务控制、权限校验、日志。

横切逻辑代码的问题：

- 代码逻辑重复
- 横切逻辑代码和业务代码混杂在一起，代码臃肿，维护不方便。

AOP横向抽取机制，将横切代码逻辑及业务逻辑代码分拆。

#### 2.2 AOP解决的问题：

在不改变原有业务逻辑的情况下，增强横切逻辑代码，从根本上解耦和，避免横切逻辑代码重复。

#### 2.3 为什么叫面向切面编程

切：指的是横切逻辑，原有业务逻辑代码不懂，只能操作横切逻辑代码，所以面向横切逻辑。

面：横切逻辑代码往往要影响的是很多个方法，每一个方法都如同一个点，多个点构成面。

## 3、手写实现IOC和AOP

### 问题及解决方式：

#### 1、解耦：

1、新建对象：

除了new方式外，还可有使用反射新建对象。Class.forName("全限定类名")配置在xml文件中

2、使用工厂模式通过反射来生产对象，工厂模式是解耦和非常好的一种方式。

![image-20201005165321966](C:\Users\Yang\AppData\Roaming\Typora\typora-user-images\image-20201005165321966.png)



**XPath表达式：**

- nodename：选取此节点的所有子节点
- /： 从根节点选取
- //：从匹配选择的当前节点选择文档中的节点，不考虑位置
- . :选取当前节点
- ..:选取当前节点的父节点
- @：选取属性

**代码**：

定义beans.xml:

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<beans>
    <!-- id标识对象，class为类的全限定名-->
    <bean id="accountDao" class="com.cy.edu.dao.impl.JdbcAccountDaoImpl"></bean>
    <bean id="transferService" class="com.cy.edu.service.impl.TransferServiceImpl">
        <!--通过name锁定到传值的set方法，通过反射技术调用该方法传入相应的值-->
        <property name="accountDao" ref="accountDao"></property>
    </bean>
</beans>
```

实现工厂类：

``` java
public class BeanFactory {

    /**
     * 1、读取解析xml，通过反射技术实例化对象并存储（map存储）
     * 2、对外提供获取对象的接口（根据id获取）
     */

    private static Map<String, Object> map = new HashMap<>();

    static {
        InputStream is = BeanFactory.class.getClassLoader().getResourceAsStream("beans.xml");
        //解析xml
        try {
            Document document = new SAXReader().read(is);
            Element root = document.getRootElement();
            List<Element> list = root.selectNodes("//bean");
            list.forEach(element -> {
                String id = element.attributeValue("id");
                String clazz = element.attributeValue("class");
                try {
                    map.put(id, Class.forName(clazz).newInstance());
                } catch (ClassNotFoundException|IllegalAccessException|InstantiationException e) {
                    e.printStackTrace();
                }
            });

            //实例化完成后，检查那些对象需要传值，根据他的配置，传入相应的值
            //有property子元素的ben就有传值 的需求
            List<Element> propertyList = root.selectNodes("//property");
            for (Element element: propertyList
                 ) {
                String name = element.attributeValue("name");
                String ref = element.attributeValue("ref");
                //找到父元素，及就是需要处理的
                Element parent = element.getParent();
                Object o = map.get(parent.attributeValue("id"));
                Method[] methods = o.getClass().getMethods();
                for (Method method : methods) {
                    if (method.getName().equalsIgnoreCase("set" + name)) {
                        method.invoke(o, map.get(ref));
                    }
                }
                map.put(parent.attributeValue("id"), o);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    public static Object getBean(String id) {
        return map.get(id);
    }
}
```

使用

``` java
    private AccountDao accountDao;

    //通过构造函数或set传值


    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
```

#### 2、事务控制

解决方法：

数据库事务其实是通过connection来提交的。

1. 两次update应该使用同一个connection

2. 事务控制在service层

![image-20201006165631013](C:\Users\Yang\AppData\Roaming\Typora\typora-user-images\image-20201006165631013.png)

**新建动态代理工厂，事务逻辑写在代理逻辑中**

``` java
public class ProxyFactory {

    private ProxyFactory(){

    }

    private static final ProxyFactory instance = new ProxyFactory();

    public static ProxyFactory getInstance() {
        return instance;
    }

    public Object getJdkProxy(Object o) {
        return Proxy.newProxyInstance(o.getClass().getClassLoader(), o.getClass().getInterfaces(), ((proxy, method, args) -> {
            Object result = null;
            try {
                TransactionManager.getInstance().beginTransaction();
                method.invoke(o, args);
                TransactionManager.getInstance().commit();
            } catch (Exception e) {
                e.printStackTrace();
                TransactionManager.getInstance().rollback();
                throw e;
            }
            return result;
        }));
    }

    public Object getCGLibProxy(Object o) {
        return Enhancer.create(o.getClass(), new MethodInterceptor() {
            @Override
            public Object intercept(Object proxy, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object result = null;
                try {
                    TransactionManager.getInstance().beginTransaction();
                    method.invoke(o, objects);
                    TransactionManager.getInstance().commit();
                } catch (Exception e) {
                    e.printStackTrace();
                    TransactionManager.getInstance().rollback();
                    throw e;
                }
                return result;
            }
        });
    }
}
```



## 4、SpringIoc

![image-20201007234614673](https://gitee.com/xiyuximing/image/raw/master/image-20201007234614673.png)

### 4.1、BeanFactory与ApplicationContext区别

1. BeanFactory是IOC容器的顶层接口，只定义了一些基础功能，定义一些基础规范。**为SpringIoc的基础容器**
2. ApplicationContext是他的子接口，有BeanFactory提供的所有功能。**是容器的高级接口，比BeanFactory有更多的功能，如资源访问，如java类、xml等**

![image-20201008000230108](https://gitee.com/xiyuximing/image/raw/master/image-20201008000230108.png)

### 4.2启动IOC容器：

java内启动：

- ClassPathXmlApplicationContext:从配置文件启动
- FileSystemXmlApplicationContext:从磁盘路径启动
- AnnotationConfigApplicationContext:通过注解启动IOC容器

Web环境：

web.xml配置：

``` xml
<!DOCTYPE web-app PUBLIC
 "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"
 "http://java.sun.com/dtd/web-app_2_3.dtd" >

<web-app>
  <display-name>Archetype Created Web Application</display-name>
  <!--配置application.xml的路径-->
  <context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>classpath:applicationContext.xml</param-value>
  </context-param>
  <!--使用spring监听器启动IOC-->
  <listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
  </listener>
</web-app>
```

注解启动:

<!DOCTYPE web-app PUBLIC
"-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"
"http://java.sun.com/dtd/web-app_2_3.dtd" >
<web-app>
<display-name>Archetype Created Web Application</display-name>
<!--告诉ContextloaderListener知道我们使⽤注解的⽅式启动ioc容器-->
<context-param>
<param-name>contextClass</param-name>
<paramvalue>
org.springframework.web.context.support.AnnotationConfigWebAppli
cationContext</param-value>
</context-param>

#### 使用xml模式

**引入依赖**

``` xml
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>5.1.12.RELEASE</version>
        </dependency>
```

**applicationContext.xml**

``` java
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd">
    <!-- id标识对象，class为类的全限定名-->
    <bean id="accountDao" class="com.cy.edu.dao.impl.JdbcAccountDaoImpl">
        <property name="connectionUtils" ref="connectionUtils"></property>
    </bean>
    <bean id="transferService" class="com.cy.edu.service.impl.TransferServiceImpl">
        <!--通过name锁定到传值的set方法，通过反射技术调用该方法传入相应的值-->
        <property name="accountDao" ref="accountDao"></property>
    </bean>
    <bean id="connectionUtils" class="com.cy.edu.utils.ConnectionUtils">
    </bean>
    <bean id="transactionManager" class="com.cy.edu.utils.TransactionManager">
        <property name="connectionUtils" ref="connectionUtils"></property>
    </bean>
    <bean id="proxyFactory" class="com.cy.edu.factory.ProxyFactory">
        <property name="transactionManager" ref="transactionManager"></property>
    </bean>
</beans>
```

**javaSE启动**

``` java
        //通过读取配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");
        System.out.println(accountDao);
```

``` java
				//通过绝对路径        
				ApplicationContext applicationContext = new FileSystemXmlApplicationContext("C:\\Users\\Yang\\IdeaProjects\\studySpring\\StudyspringTransfer-iocxml\\src\\main\\resources\\applicationContext.xml");
        AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");
        System.out.println(accountDao);
```

**Web启动**

使用监听器，配置web.xml

``` xml
<!DOCTYPE web-app PUBLIC
 "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"
 "http://java.sun.com/dtd/web-app_2_3.dtd" >

<web-app>
  <display-name>Archetype Created Web Application</display-name>
  <!--配置application.xml的路径-->
  <context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>classpath:applicationContext.xml</param-value>
  </context-param>
  <!--使用spring监听器启动IOC-->
  <listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
  </listener>
</web-app>
```

删除BeanFactory类

修改servlet类

``` java
    @Override
    public void init() throws ServletException {
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        ProxyFactory proxyFactory = (ProxyFactory) webApplicationContext.getBean("proxyFactory");

        transferService = (TransferService) proxyFactory.getJdkProxy(webApplicationContext.getBean("transferService"));

    }
```

#### 实例化Bean的三种⽅式

1. 通过无参构造函数（推荐使用）

   默认情况下使用，通过反射调用无参构造函数。若没有无参构造函数，会创建失败

   ``` xml
       <!--使用无参构造函数实例化对象-->
       <bean id="connectionUtils" class="com.cy.edu.utils.ConnectionUtils">
       </bean>
   ```

**以下两种方式是为了我们自己new对象加入到springIOC容器管理**

2. 使用静态方法

``` xml
    <!--使用静态方法创建-->
    <bean id="connectionUtils" class="com.cy.edu.factory.CreateBeanFactory" factory-method="getInstanceStatic"/>
```

​	我们有时候使用的对象有些时候并不是直接通过构造函数就可以创建出来的，它可能在创建的过程 中会做很多额外的操作。此时会提供⼀个创建对象的⽅法，恰好这个⽅法是static修饰的⽅法，即是此种情 况。
​	例如，我们在做Jdbc操作时，会⽤到java.sql.Connection接⼝的实现类，如果是mysql数据库，那么⽤的就 是JDBC4Connection，但是我们不会去写JDBC4Connection connection = new JDBC4Connection() ，因为我们要注册驱动，还要提供URL和凭证信息，⽤DriverManager.getConnection ⽅法来获取连接。

3. 使用实例化方法

   ``` xml
       <!--使用实例化方法-->
       <bean id="createBeanFactory" class="com.cy.edu.factory.CreateBeanFactory"/>
       <bean id="connectionUtils" factory-bean="createBeanFactory" factory-method="getInstance"/>
   ```



#### Bean的作用范围及生命周期

配置方式：

``` xml
    <bean id="accountDao" class="com.cy.edu.dao.impl.JdbcAccountDaoImpl" scope="singleton">
        <property name="connectionUtils" ref="connectionUtils"></property>
    </bean>
```

- singleton(单例，**默认值**):IOC容器中只有一个对象

  当创建容器时，对象就被创建了，当销毁容器时，对象就被销毁了

- prototype(原型):

  当使⽤对象时，创建新的对象实例，当对象⻓时间不⽤时，被java的垃圾回收器回收了。**spring框架只负责创建，不负责销毁**

- request:

  每次请求

- session:

  每次会话

- application:

  

- websocket:

#### bean标签的属性

- id属性： ⽤于给bean提供⼀个唯⼀标识。在⼀个标签内部，标识必须唯⼀。
- class属性：⽤于指定创建Bean对象的全限定类名。
- name属性：⽤于给bean提供⼀个或多个名称。多个名称⽤空格分隔。
- factory-bean属性：⽤于指定创建当前bean对象的⼯⼚bean的唯⼀标识。当指定了此属性之后，class属性失效
- factory-method属性：⽤于指定创建当前bean对象的⼯⼚⽅法，如配合factory-bean属性使⽤，则class属性失效。如配合class属性使⽤，则⽅法必须是static的。
- scope属性：⽤于指定bean对象的作⽤范围。通常情况下就是singleton。当要⽤到多例模式时，可以配置为prototype。
- init-method属性：⽤于指定bean对象的初始化⽅法，此⽅法会在bean对象装配后调⽤。必须是⼀个⽆参⽅法。
- destory-method属性：⽤于指定bean对象的销毁⽅法，此⽅法会在bean对象销毁前执⾏。它只能为scope是singleton时起作⽤。

#### DI依赖注入

**依赖注入方式：**

构造器注入

``` xml
    <bean id="transactionManager" class="com.cy.edu.utils.TransactionManager">
        <constructor-arg index="0" ref="connectionUtils"/>
        <constructor-arg index="1" value="123"/>
    </bean>
```



set注入

``` xml
    <bean id="transactionManager" class="com.cy.edu.utils.TransactionManager">
        <!--set注入，其他bean使用ref，普通值使用value-->
        <property name="connectionUtils" ref="connectionUtils"></property>
        <property name="name" value="123"></property>
    </bean>
```



**复杂类型注入**

``` xml
				<!--数组-->
        <property name="myArray">
            <array>
                <ref bean="connectionUtils"></ref>
                <value></value>
            </array>
        </property>
        <!--map-->
        <property name="myMap">
            <map>
                <entry key="" value=""/>
                <entry key-ref="" value-ref=""/>
            </map>
        </property>
        <!--set-->
        <property name="mySet">
            <set>
                <value></value>
            </set>
        </property>
        <!--Properties-->
        <property name="myProperty">
            <props>
                <prop key="">value1</prop>
            </props>
        </property>
```

其中数组和set的配置项可以互用，map和Properties的配置项可以互用

#### 使用XML和注解相结合方式



# 代理模式

**静态代理及动态代理区别：有没有代理类**

动态代理可以使用JDK动态代理，和CGLIB动态代理扩展

JDK动态代理委托对象必须实现接口，CGLIB而不需要