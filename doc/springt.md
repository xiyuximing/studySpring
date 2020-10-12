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

| xml配置                  | 对应注解                                                     |
| ------------------------ | ------------------------------------------------------------ |
| \<bean/>                 | @Component、@Controller、@Service、@Repository，四个注解用法一样，只不过用来区别于控制层、服务层、数据层。如果不配置id属性，默认为这个bean的id名为首字母小写 |
| \<bean/>中scope属性      | @Scope("prototype")，默认单例，注解加在类上                  |
| 标签的init-method属性    | @PostConstruct，注解加在⽅法上，该⽅法就是初始化后调⽤的⽅法 |
| 标签的destory-method属性 | @PreDestory，注解加在⽅法上，该⽅法就是销毁前调⽤的⽅法      |

DI注解方式：

@Autowired:默认按类型注入

@Qualifier:指定注入那个对象

``` java
@Repository("accountDao")
public class JdbcAccountDaoImpl implements AccountDao {

    @Autowired
    @Qualifier("connectionUtils")
    private ConnectionUtils connectionUtils;

    @Autowired
    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }
}
```

@Resource:不推荐

@Resource 注解由 J2EE 提供，需要导⼊包 javax.annotation.Resource。
@Resource 默认按照 ByName ⾃动注⼊。

- 如果同时指定了 name 和 type，则从Spring上下⽂中找到唯⼀匹配的bean进⾏装配，找不到则抛出异常。
- 如果指定了 name，则从上下⽂中查找名称（id）匹配的bean进⾏装配，找不到则抛出异常。
- 如果指定了 type，则从上下⽂中找到类似匹配的唯⼀bean进⾏装配，找不到或是找到多个，都会抛出异常。
- 如果既没有指定name，⼜没有指定type，则⾃动按照byName⽅式进⾏装配；

#### 纯注解模式

**@Configuration：**申明当前类是个配置类

**@ComponentScan(basePackages = {"com.cy.edu"})：**扫描包，可以配置多个

**@PropertySource({"classpath:jdbc.properties"})：**读取外部资源文件

**@Value("${jdbc.driver}")：**对变量赋值，可以直接赋值，也可以使⽤ ${} 读取资源配置⽂件中的信息

**@Bean:**将⽅法返回对象加⼊ SpringIOC 容器

**@Import:**引⼊其他配置类

```java
@Configuration
@ComponentScan(basePackages = {"com.cy.edu"})
@PropertySource({"classpath:jdbc.properties"})
@Import()
public class SpringConfig {

    @Value("${jdbc.driver}")
    private String driverClassName;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    @Bean("dataSource")
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
```

启动方式：

javaSE：使用AnnotationConfigApplicationContext

``` java
ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
```

Web启动：配置web.xml

``` xml
  <!--告诉ContextLoaderListener是通过注解方式启动IOC容器-->
  <context-param>
    <param-name>contextClass</param-name>
    <param-value>org.springframework.web.context.support.AnnotationConfigWebApplicationContext</param-value>
  </context-param>
  <context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>com.cy.edu.SpringConfig</param-value>
  </context-param>
  <!--使用spring监听器启动IOC-->
  <listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
  </listener>
```

### 4.3 lazy-Init 延迟加载

ApplicationContext 容器的默认⾏为是在启动服务器时将所有 **singleton bean** 提前进⾏实例化。提前实例化意味着作为初始化过程的⼀部分ApplicationContext 实例会创建并配置所有的singleton bean。

设置 lazy-init 为 true 的 bean 将不会在 ApplicationContext 启动时提前被实例化，⽽是第⼀次向容器通过 **getBean** 索取 bean 时实例化的。如果⼀个设置了⽴即加载的 bean1，引⽤了⼀个延迟加载的 bean2 ，那么 bean1 在容器启动时被实例化，⽽ bean2 由于被 bean1 引⽤，所以也被实例化，这种情况也符合延时加载的 bean 在第⼀次调⽤时才被实例化的规则。

**如果⼀个 bean 的 scope 属性为 scope="pototype" 时，即使设置了 lazy-init="false"，容器启动时也不会实例化bean，⽽是调⽤ getBean ⽅法实例化的。**

#### 配置方式

``` xml
<bean id="testBean" calss="cn.lagou.LazyBean" lazy-init="true" />
或者
<beans default-lazy-init="true" xmlns="http://www.springframework.org/schema/beans"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd">

```

或者使用@Lazy注解

``` java
@Lazy
public class JdbcAccountDaoImpl implements AccountDao {
}
```

#### 使用场景

- 开启延迟加载⼀定程度提⾼容器启动和运转性能
- 对于不常使⽤的 Bean 设置延迟加载，这样偶尔使⽤的时候再加载，不必要从⼀开始该 Bean 就占⽤资源

### 4.4 BeanFactory和FactoryBean

**BeanFactory接⼝**是容器的顶级接⼝，定义了容器的⼀些基础⾏为，负责⽣产和管理Bean的⼀个⼯⼚，具体使⽤它下⾯的⼦接⼝类型，⽐ApplicationContext；
Spring中Bean有两种，⼀种是普通Bean，⼀种是⼯⼚Bean（FactoryBean），FactoryBean可以⽣成某⼀个类型的Bean实例（返回给我们），也就是说我们可以借助于它⾃定义Bean的创建过程。

**Bean创建的三种⽅式中的静态⽅法和实例化⽅法和FactoryBean作⽤类似**，FactoryBean使⽤较多，尤其在Spring框架⼀些组件中会使⽤，还有其他框架和Spring框架整合时使⽤。

``` java
// 可以让我们⾃定义Bean的创建过程（完成复杂Bean的定义）
public interface FactoryBean<T> {
  @Nullable
  // 返回FactoryBean创建的Bean实例，如果isSingleton返回true，则该实例会放到Spring容器
  的单例对象缓存池中Map
  T getObject() throws Exception;
  @Nullable
  // 返回FactoryBean创建的Bean类型
  Class<?> getObjectType();
  // 返回作⽤域是否单例
  default boolean isSingleton() {
  	return true;
  }
}
```

**使用方式：**

新建实体类：

``` java
public class Company {

    private String name;

    private String address;

    private Integer scale;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", scale=" + scale +
                '}';
    }
```

新建factorybean

``` java
@Component("company")
public class CompanyFactoryBean implements FactoryBean {

    @Value("名称,地址,10")
    private String companyInfo;// 公司名称,地址,规模
    public void setCompanyInfo(String companyInfo) {
        this.companyInfo = companyInfo;
    }

    @Override
    public Company getObject() throws Exception {
        // 模拟创建复杂对象Company
        Company company = new Company();
        String[] strings = companyInfo.split(",");
        company.setName(strings[0]);
        company.setAddress(strings[1]);
        company.setScale(Integer.parseInt(strings[2]));
        return company;
    }

    @Override
    public Class<?> getObjectType() {
        return Company.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
```

测试使用

``` java
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        //获取companybean
        Object o = applicationContext.getBean("company");
        System.out.println(o);
        //获取factorybean
        o = applicationContext.getBean("&company");
        System.out.println(o);
```



### 4.5 后置处理器

Spring提供了两种后处理bean的扩展接⼝，分别为 BeanPostProcessor 和BeanFactoryPostProcessor，两者在使⽤上是有所区别的。
⼯⼚初始化（BeanFactory）—> Bean对象

**BeanFactoryPostProcessor**是用来在BeanFactory初始化之后进行一些后置处理的。

**BeanPostProcessor**是在Bean对象实例化（**并不是Bean整个生命周期完成之后**）之后进行后置处理做一些事情。

**对象不⼀定是springbean，⽽springbean⼀定是个对象**

#### SpringBean生命周期

![image-20201011111928291](https://gitee.com/xiyuximing/image/raw/master/image-20201011111928291.png)

1. 根据配置调用Bean的构造方法或工厂方法实例化Bean
2. 利用依赖注入完成Bean中所有属性值的配置注入
3. 若Bean实现了BeanNameAware接口，则Spring调用Bean的setBeanName()方法传入当前bean的id值
4. 若Bean实现了BeanFactoryAware接口，则Spring调用setBeanFactory()方法传入当前工场实例的引用
5. 若Bean实现了ApplicationContextAware接口，则Spring调用setApplicationContext()方法传入当前ApplicationContext实例的引用
6. 若BeanPostProcessor和Bean关联，则Spring将调用该接口的预初始化方法postProcessBeforeInitialzation()方法对bean进行加工操作。**SpringAop就是通过它实现的**。
7. 若Bean实现了InitializingBean接口，则Spring将调用afterPropertiesSet()方法。
8. 若配置文件中配置了init-method属性制定了初始化方法，则调用该方法。
9. 若BeanPostProcessor和Bean关联，则Spring将调用该接口的初始化方法postProcessAfterInitialization()方法。此时，**Bean已经可以被应用系统使用了**。
10. 若此bean的作用范围为singleton单例，则将该Bean放入SpringIOC的缓存池中，将触发Spring对该Bean生命周期的管理。若为prototype，则将该Bean交给调用者。
11. 若Bean实现了DisposableBean接口，则Spring会调用destory()方法对Bean进行销毁。若在配置文件中通过destory-method属性指定了Bean的销毁方法，则Spring将调用该方法对Bean进行销毁。



实体类bean

``` java
public class Result implements BeanNameAware,BeanFactoryAware,ApplicationContextAware,InitializingBean, DisposableBean {

    private String status;
    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Result{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("注册我成为bean时定义的id：" + name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("管理我的beanfactory为：" + beanFactory);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("高级容器接口ApplicationContext：" + applicationContext);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet......");
    }


    public void initMethod() {
        System.out.println("init-method....");
    }

    @PostConstruct
    public void postCoustrcut() {
        System.out.println("postCoustrcut");
    }


    @PreDestroy
    public void PreDestroy(){
        System.out.println("PreDestroy...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy.....");
    }
}
```

BeanPostProcessor

``` java
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if("lazyResult".equalsIgnoreCase(beanName)) {
            System.out.println("MyBeanPostProcessor  before方法拦截处理lazyResult");
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if("lazyResult".equalsIgnoreCase(beanName)) {
            System.out.println("MyBeanPostProcessor  after方法拦截处理lazyResult");
        }
        return bean;
    }
}
```

测试输出：

``` 
注册我成为bean时定义的id：lazyResult
管理我的beanfactory为：org.springframework.beans.factory.support.DefaultListableBeanFactory@76f2b07d: defining beans [org.springframework.context.annotation.internalConfigurationAnnotationProcessor,org.springframework.context.annotation.internalAutowiredAnnotationProcessor,org.springframework.context.annotation.internalCommonAnnotationProcessor,org.springframework.context.event.internalEventListenerProcessor,org.springframework.context.event.internalEventListenerFactory,springConfig,accountDao,company,myBeanPostProcessor,proxyFactory,lazyResult,transferService,connectionUtils,transactionManager,dataSource]; root of factory hierarchy
高级容器接口ApplicationContext：org.springframework.context.annotation.AnnotationConfigApplicationContext@4141d797, started on Sun Oct 11 11:45:38 CST 2020
MyBeanPostProcessor  before方法拦截处理lazyResult
postCoustrcut
afterPropertiesSet......
MyBeanPostProcessor  after方法拦截处理lazyResult
Result{status='null', message='null'}
PreDestroy...
destroy.....
```



#### BeanPostProcessor

BeanPostProcessor是针对Bean级别的处理，可以针对某个具体的Bean.

``` java
public interface BeanPostProcessor {
    @Nullable
    default Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Nullable
    default Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
```

该接⼝提供了两个⽅法，分别在Bean的初始化⽅法前和初始化⽅法后执⾏，具体这个初始化⽅法指的是什么⽅法，类似我们在定义bean时，定义了init-method所指定的⽅法。
定义⼀个类实现了BeanPostProcessor，默认是会对整个Spring容器中所有的bean进⾏处理。如果要对具体的某个bean处理，可以通过⽅法参数判断，两个类型参数分别为Object和String，第⼀个参数是每个bean的实例，第⼆个参数是每个bean的name或者id属性的值。所以我们可以通过第⼆个参数，来判断我们将要处理的具体的bean。
注意：**处理是发⽣在Spring容器的实例化和依赖注⼊之后**。

#### BeanFactoryPostProcessor

BeanFactory级别的处理，是针对整个Bean的⼯⼚进⾏处理，典型应⽤:PropertyPlaceholderConfigurer读取xml配置文件中的propertites属性。

``` java
@FunctionalInterface
public interface BeanFactoryPostProcessor {
    void postProcessBeanFactory(ConfigurableListableBeanFactory var1) throws BeansException;
}
```

此接⼝只提供了⼀个⽅法，⽅法参数为ConfigurableListableBeanFactory，该参数类型定义了⼀些⽅法:

![image-20201011115136658](https://gitee.com/xiyuximing/image/raw/master/image-20201011115136658.png)

其中有个⽅法名为getBeanDefinition的⽅法，我们可以根据此⽅法，找到我们定义bean 的BeanDefinition对象。然后我们可以对定义的属性进⾏修改。

![image-20201011115301666](https://gitee.com/xiyuximing/image/raw/master/image-20201011115301666.png)

BeanDefinition⽅法名字类似我们bean标签的属性，setBeanClassName对应bean标签中的class属性，所以当我们拿到BeanDefinition对象时，我们可以⼿动修改bean标签中所定义的属性值。
**BeanDefinition对象**：我们在 XML 中定义的 bean标签，Spring 解析 bean 标签成为⼀个 JavaBean，这个JavaBean 就是 BeanDefinition
**注意：**调⽤ BeanFactoryPostProcessor ⽅法时，这时候bean还没有实例化，此时 bean 刚被解析成BeanDefinition对象

## 5、源码

- 源码阅读原则
  - 定焦原则：抓主线
  - 宏观原则：关注源码结构和业务流程（淡化具体某⾏代码的编写细节）
- 读源码的⽅法和技巧
  - 断点（观察调⽤栈）
  - 反调（Find Usages）
  - 经验（spring框架中doXXX，做具体处理的地⽅）
- 编译工程
  - 使用gradle
  - 编译⼯程（顺序：core-oxm-context-beans-aspects-aop）
    - ⼯程—>tasks—>compileTestJava

### 1、Spring IoC容器初始化主体流程

#### Spring IoC的容器体系

IoC容器是Spring的核⼼模块，是抽象了对象管理、依赖关系管理的框架解决⽅案。Spring 提供了很多的容器，其中 BeanFactory 是顶层容器（根容器），不能被实例化，它定义了所有 IoC 容器 必须遵从的⼀套原则，具体的容器实现可以增加额外的功能，⽐如我们常⽤到的ApplicationContext，其下更具体的实现如 ClassPathXmlApplicationContext 包含了解析 xml 等⼀系列的内容，AnnotationConfigApplicationContext 则是包含了注解解析等⼀系列的内容。Spring IoC 容器继承体系⾮常聪明，需要使⽤哪个层次⽤哪个层次即可，不必使⽤功能⼤⽽全的。

BeanFactory 顶级接⼝⽅法栈如下：

![image-20201011183336069](https://gitee.com/xiyuximing/image/raw/master/image-20201011183336069.png)



BeanFactory容器继承体系

![image-20201011183607334](https://gitee.com/xiyuximing/image/raw/master/image-20201011183607334.png)

通过其接⼝设计，我们可以看到我们⼀贯使⽤的 ApplicationContext 除了继承BeanFactory的⼦接⼝，还继承了ResourceLoader、MessageSource等接⼝，因此其提供的功能也就更丰富了。

ApplicationContext是容器的高级接口，BeanFacotry是顶级容器/根容器，规范了/定义了容器的基础行为。

Spring应用上下文，官方称之为 IoC容器。错误的认识：容器就是map而已；准确来说，map是ioc容器的一个成员，叫做单例池, singletonObjects,容器是一组组件和过程的集合，包括BeanFactory、单例池、BeanPostProcessor等以及之间的协作流程

#### Bean⽣命周期关键时机点

**思路：**创建⼀个类 LagouBean ，让其实现⼏个特殊的接⼝，并分别在接⼝实现的构造器、接⼝⽅法中断点，观察线程调⽤栈，分析出 Bean 对象创建和管理关键点的触发时机。

结论：

- 在未设置延迟加载的前提下，Bean 的创建是在容器初始化过程中完成的

- 构造函数的调⽤时机在AbstractApplicationContext类refresh⽅法的finishBeanFactoryInitialization(beanFactory)处

- InitializingBean中afterPropertiesSet ⽅法的调⽤时机也是在AbstractApplicationContext类refresh⽅法的finishBeanFactoryInitialization(beanFactory)

- BeanFactoryPostProcessor 初始化在AbstractApplicationContext类refresh⽅法的invokeBeanFactoryPostProcessors(beanFactory)处;postProcessBeanFactory方法调⽤在AbstractApplicationContext类refresh⽅法的invokeBeanFactoryPostProcessors(beanFactory);

- BeanPostProcessor 初始化在AbstractApplicationContext类refresh⽅法的registerBeanPostProcessors(beanFactory);postProcessBeforeInitialization 调⽤在AbstractApplicationContext类refresh⽅法的finishBeanFactoryInitialization(beanFactory);postProcessAfterInitialization 调⽤在AbstractApplicationContext类refresh⽅法的finishBeanFactoryInitialization(beanFactory);

- | 关键点                            | 触发代码                                                     |
  | --------------------------------- | ------------------------------------------------------------ |
  | 构造器                            | AbstractApplicationContext#refresh#finishBeanFactoryInitialization(beanFactory)(beanFactory) |
  | BeanFactoryPostProcessor 初始化   | AbstractApplicationContext#refresh#invokeBeanFactoryPostProcessors(beanFactory) |
  | BeanFactoryPostProcessor ⽅法调用 | AbstractApplicationContext#refresh#invokeBeanFactoryPostProcessors(beanFactory) |
  | BeanPostProcessor 初始化          | AbstractApplicationContext#refresh#registerBeanPostProcessors(beanFactory) |
  | BeanPostProcessor ⽅法调用        | AbstractApplicationContext#refresh#finishBeanFactoryInitialization(beanFactory) |

  

#### Spring IoC容器初始化主流程

由上分析可知，Spring IoC 容器初始化的关键环节就在 AbstractApplicationContext#refresh() ⽅法中，我们查看 refresh ⽅法来俯瞰容器创建的主体流程

``` java
public void refresh() throws BeansException, IllegalStateException {
		// 对象锁加锁
		synchronized (this.startupShutdownMonitor) {
			/*
				Prepare this context for refreshing.
			 	刷新前的预处理
			 	表示在真正做refresh操作之前需要准备做的事情：
					设置Spring容器的启动时间，
					开启活跃状态，撤销关闭状态
					验证环境信息里一些必须存在的属性等
			 */
			prepareRefresh();

			/*
				Tell the subclass to refresh the internal bean factory.
			 	获取BeanFactory；默认实现是DefaultListableBeanFactory
                加载BeanDefition 并注册到 BeanDefitionRegistry
			 */
			ConfigurableListableBeanFactory beanFactory = obtainFreshBeanFactory();

			/*
				Prepare the bean factory for use in this context.
				BeanFactory的预准备工作（BeanFactory进行一些设置，比如context的类加载器等）
			 */
			prepareBeanFactory(beanFactory);

			try {
				/*
					Allows post-processing of the bean factory in context subclasses.
					BeanFactory准备工作完成后进行的后置处理工作
				 */
				postProcessBeanFactory(beanFactory);

				/*
					Invoke factory processors registered as beans in the context.
					实例化实现了BeanFactoryPostProcessor接口的Bean，并调用接口方法
				 */
				invokeBeanFactoryPostProcessors(beanFactory);

				/*
					Register bean processors that intercept bean creation.
					注册BeanPostProcessor（Bean的后置处理器），在创建bean的前后等执行
				 */
				registerBeanPostProcessors(beanFactory);

				/*
					Initialize message source for this context.
					初始化MessageSource组件（做国际化功能；消息绑定，消息解析）；
				 */
				initMessageSource();

				/*
					Initialize event multicaster for this context.
					初始化事件派发器
				 */
				initApplicationEventMulticaster();

				/*
					Initialize other special beans in specific context subclasses.
					子类重写这个方法，在容器刷新的时候可以自定义逻辑；如创建Tomcat，Jetty等WEB服务器
				 */
				onRefresh();

				/*
					Check for listener beans and register them.
					注册应用的监听器。就是注册实现了ApplicationListener接口的监听器bean
				 */
				registerListeners();

				/*
					Instantiate all remaining (non-lazy-init) singletons.
					初始化所有剩下的非懒加载的单例bean
					初始化创建非懒加载方式的单例Bean实例（未设置属性）
                    填充属性
                    初始化方法调用（比如调用afterPropertiesSet方法、init-method方法）
                    调用BeanPostProcessor（后置处理器）对实例bean进行后置处理
				 */
				finishBeanFactoryInitialization(beanFactory);

				/*
					Last step: publish corresponding event.
					完成context的刷新。主要是调用LifecycleProcessor的onRefresh()方法，并且发布事件（ContextRefreshedEvent）
				 */
				finishRefresh();
        ......
			}
    }
}
```

### 2、 BeanFactory创建流程

#### 获取BeanFactory⼦流程



#### BeanDefinition加载解析及注册⼦流程

### 3、Bean创建流程



### 4、lazy-init 延迟加载机制原理

- lazy-init 延迟加载机制分析：

  普通 Bean 的初始化是在容器启动初始化阶段执⾏的，⽽被lazy-init=true修饰的 bean 则是在从容器⾥第⼀次进⾏context.getBean() 时进⾏触发。Spring 启动的时候会把所有bean信息(包括XML和注解)解析转化成Spring能够识别的BeanDefinition并存到Hashmap⾥供下⾯的初始化时⽤，然后对每个BeanDefinition进⾏处理，如果是懒加载的则在容器初始化阶段不处理，其他的则在容器初始化阶段进⾏初始化并依赖注⼊。

- 对于被修饰为lazy-init的bean Spring 容器初始化阶段不会进⾏ init 并且依赖注⼊，当第⼀次进⾏getBean时候才进⾏初始化并依赖注⼊
- 对于⾮懒加载的bean，getBean的时候会从缓存⾥头获取，因为容器初始化阶段 Bean 已经初始化完成并缓存了起来



### 5、Spring IoC循环依赖问题

#### 什么是循环依赖

循环依赖其实就是循环引⽤，也就是两个或者两个以上的 Bean 互相持有对⽅，最终形成闭环。⽐如A依赖于B，B依赖于C，C⼜依赖于A。

Spring中循环依赖场景有：

- 构造器的循环依赖（构造器注⼊）
- Field 属性的循环依赖（set注⼊）

其中，构造器的循环依赖问题⽆法解决，只能拋出 BeanCurrentlyInCreationException 异常，在解决属性循环依赖时，spring采⽤的是提前暴露对象的⽅法。

#### 循环依赖处理机制

- 单例 bean 构造器参数循环依赖（⽆法解决）

- prototype 原型 bean循环依赖（⽆法解决）

  对于原型bean的初始化过程中不论是通过构造器参数循环依赖还是通过setXxx⽅法产⽣循环依赖，Spring都 会直接报错处理。



- 单例bean通过setXxx或者@Autowired进⾏循环依赖

  **通过三级缓存机制**

  ![image-20201011222047374](https://gitee.com/xiyuximing/image/raw/master/image-20201011222047374.png)

  Spring 的循环依赖的理论依据基于 Java 的引⽤传递，当获得对象的引⽤时，对象的属性是可以延后设置的，但是构造器必须是在获取引⽤之前。

  Spring通过setXxx或者@Autowired⽅法解决循环依赖其实是通过提前暴露⼀个ObjectFactory对象来完成的，简单来说ClassA在调⽤构造器完成对象初始化之后，在调⽤ClassA的setClassB⽅法之前就把ClassA实例化的对象通过ObjectFactory提前暴露到Spring容器中。

  1. Spring容器初始化ClassA通过构造器初始化对象后提前暴露到Spring容器,放入3级缓存中
  2. ClassA调⽤setClassB⽅法，Spring⾸先尝试从容器中获取ClassB，此时ClassB不存在Spring容器中
  3. Spring容器初始化ClassB，同时也会将ClassB提前暴露到Spring容器中
  4. ClassB调⽤setClassA⽅法，Spring从容器中获取ClassA ，因为第⼀步中已经提前暴露了ClassA，因此可以获取到ClassA实例
  5. 这样ClassA和ClassB都完成了对象初始化操作，解决了循环依赖问题



## 6、Spring AOP 应⽤

AOP本质：在不改变原有业务逻辑的情况下增强横切逻辑，横切逻辑代码往往是权限校验代码、⽇志代码、事务控制代码、性能监控代码

### 1、AOP相关术语

| 名词              | 解释                                                         |
| ----------------- | ------------------------------------------------------------ |
| Joinpoint(连接点) | 它指的是那些可以⽤于把增强代码加⼊到业务主线中的点，这些点指的就是⽅法。在⽅法执⾏的前后通过动态代理技术加⼊增强的代码。在Spring框架AOP思想的技术实现中，也只⽀持⽅法类型的连接点。 |
| Pointcut(切⼊点)  | 它指的是那些已经把增强代码加⼊到业务主线进来之后的连接点。由上图中，我们看出表现层transfer ⽅法就只是连接点，因为判断访问权限的功能并没有对其增强。 |
| Advice(通知/增强) | 它指的是切⾯类中⽤于提供增强功能的⽅法。并且不同的⽅法增强的时机是不⼀样的。⽐如，开启事务肯定要在业务⽅法执⾏之前执⾏；提交事务要在业务⽅法正常执⾏之后执⾏，⽽回滚事务要在业务⽅法执⾏产⽣异常之后执⾏等等。那么这些就是通知的类型。其分类有：前置通知 后置通知 异常通知 最终通知 环绕通知。 |
| Target(⽬标对象)  | 它指的是代理的⽬标对象。即被代理对象。                       |
| Proxy(代理)       | 它指的是⼀个类被AOP织⼊增强后，产⽣的代理类。即代理对象。    |
| Weaving(织⼊)     | 它指的是把增强应⽤到⽬标对象来创建新的代理对象的过程。spring采⽤动态代理织⼊，⽽AspectJ采⽤编译期织⼊和类装载期织⼊。 |
| Aspect(切⾯)      | 它指定是增强的代码所关注的⽅⾯，把这些相关的增强代码定义到⼀个类中，这个类就是切⾯类。例如，事务切⾯，它⾥⾯定义的⽅法就是和事务相关的，像开启事务，提交事务，回滚事务等等，不会定义其他与事务⽆关的⽅法。TrasnactionManager 就是⼀个切⾯。 |

**连接点：**⽅法开始时、结束时、正常运⾏完毕时、⽅法异常时等这些特殊的时机点，我们称之为连接点，项⽬中每个⽅法都有连接点，连接点是⼀种候选点

**切⼊点：**指定AOP思想想要影响的具体⽅法是哪些，描述感兴趣的⽅法

**Advice增强：**

1. 指的是横切逻辑

 	2. ⽅位点（在某⼀些连接点上加⼊横切逻辑，那么这些连接点就叫做⽅位点，描述的是具体的特殊时机）

**Aspect切⾯：**切⾯概念是对上述概念的⼀个综合

​	Aspect切⾯= 切⼊点+增强
​						= 切⼊点（锁定⽅法） + ⽅位点（锁定⽅法中的特殊时机）+ 横切逻辑

**众多的概念，⽬的就是为了锁定要在哪个地⽅插⼊什么横切逻辑代码**

### 2、Spring中AOP的代理选择

Spring 实现AOP思想使⽤的是动态代理技术。

默认情况下，Spring会根据被代理对象是否实现接⼝来选择使⽤JDK还是CGLIB。当被代理对象没有实现任何接⼝时，Spring会选择CGLIB。当被代理对象实现了接⼝，Spring会选择JDK官⽅的代理技术，不过我们可以通过配置的⽅式，让Spring强制使⽤CGLIB。

### 3、Spring中AOP使用

#### 通知类型

- **前置通知**

  在切⼊点⽅法（业务核⼼⽅法）执⾏之前执⾏。

  前置通知可以获取切⼊点⽅法的参数，并对其进⾏增强

  配置方式：

  1. 通过xml

     ``` xml
     <aop:before method="printLog" pointcut-ref="pointcut1"></aop:before>
     ```

  2. 通过注解

     @before

- **正常执⾏时通知**

  正常执行后通知

  配置方式：

  1. 通过xml

     ``` xml
     <aop:after-returning method="afterReturningPrintLog" pointcutref="pt1"></aop:after-returning>
     ```

  2. 通过注解

     @AfterReturning

- **异常通知**

  异常通知的执⾏时机是在切⼊点⽅法（业务核⼼⽅法）执⾏产⽣异常之后，异常通知执⾏。如果切⼊点⽅法执⾏没有产⽣异常，则异常通知不会执⾏。

  异常通知不仅可以获取切⼊点⽅法执⾏的参数，也可以获取切⼊点⽅法执⾏产⽣的异常信息.

  配置方式：

  1. 通过xml

     ``` xml
     <aop:after-throwing method="afterThrowingPrintLog" pointcut-ref="pt1"></aop:after-throwing>
     ```

  2. 通过注解

     @AfterThrowing

- **最终通知**

  ⽆论切⼊点⽅法执⾏是否产⽣异常，它都会在返回之前执⾏。

  最终通知执⾏时，可以获取到通知⽅法的参数。同时它可以做⼀些清理操作.

  配置方式：

  1. 通过xml

     ``` xml
     <aop:after method="afterPrintLog" pointcut-ref="pt1"></aop:after>
     ```

  2. 通过注解

     @After

- **环绕通知**

  是Spring框架为我们提供的⼀种可以通过编码的⽅式，控制增强代码何时执⾏的通知类型。它⾥⾯借助的ProceedingJoinPoint接⼝及其实现类，实现⼿动触发切⼊点⽅法的调⽤.

  配置方式：

  1. 通过xml

     ``` xml
     <aop:around method="aroundPrintLog" pointcut-ref="pt1"></aop:around>
     ```

  2. 通过注解

     @Around

#### 相关依赖

``` xml
<dependency>
  <groupId>org.springframework</groupId>
  <artifactId>spring-aop</artifactId>
  <version>5.1.12.RELEASE</version>
</dependency>
<dependency>
  <groupId>org.aspectj</groupId>
  <artifactId>aspectjweaver</artifactId>
  <version>1.9.4</version>
</dependency>
```

#### 使用XML模式

1. 配置xml

   ``` xml
   <!--
   Spring基于XML的AOP配置前期准备：
   在spring的配置⽂件中加⼊aop的约束
   xmlns:aop="http://www.springframework.org/schema/aop"
   http://www.springframework.org/schema/aop
   https://www.springframework.org/schema/aop/spring-aop.xsd-->
   <!--把通知bean交给spring来管理-->
   <bean id="logUtil" class="com.lagou.utils.LogUtil"></bean>
   <!--开始aop的配置-->
   <aop:config>
     <!--配置切⾯-->
     <aop:aspect id="logAdvice" ref="logUtil">
     <!--配置前置通知 method:⽤于指定后置通知的⽅法名称 pointcut:⽤于指定切⼊点表达式 pointcut-ref:⽤于指定切⼊点表达式的引⽤-->
     <aop:before method="printLog" pointcut="execution(public * com.service.impl.*.*(..))"></aop:before>
     </aop:aspect>
   </aop:config>
   ```

   **切入点表达式：**

   访问修饰符 返回值 包名.包名.包名.类名.⽅法名(参数列表)

   如：public void com.service.impl.TransferServiceImpl.updateAccountByCardNo(com.pojo.Account)

   其中访问修饰符可省略

   返回值可用*标识任意返回值

   包名可以使⽤.表示任意包

   包名可以使⽤..表示当前包及其⼦包

   类名和⽅法名，都可以使⽤.表示任意类，任意⽅法

   参数列表，可以使⽤具体类型，基本类型直接写类型名称 ： int；引⽤类型必须写全限定类名：java.lang.String

   可以使⽤*，表示任意参数类型，但是必须有参数

   参数列表可以使⽤..，表示有⽆参数均可。有参数可以是任意类型

   **改变代理方式：**

   通过以下配置强制使用CGLIB的方式进行动态代理。二选一

   ``` xml
   <aop:config proxy-target-class="true">
   或
   <!--此标签是基于XML和注解组合配置AOP时的必备标签，表示Spring开启注解配置AOP的⽀持-->
   <aop:aspectj-autoproxy proxy-target-class="true"></aop:aspectjautoproxy>
   ```

#### XML+注解模式

在xml中配置开启对注解的支持

``` xml
<!--开启spring对注解aop的⽀持-->
<aop:aspectj-autoproxy/>
```

相关注解

@Aspect

@Pointcut

@Before

@AfterReturning

@AfterThrowing

@After

@Around

``` java
@Component
@Aspect
public class LogUtil {
  /*** 第⼀步：编写⼀个⽅法
* 第⼆步：在⽅法使⽤@Pointcut注解
* 第三步：给注解的value属性提供切⼊点表达式
* 细节：
* 1.在引⽤切⼊点表达式时，必须是⽅法名+()，例如"pointcut()"。
* 2.在当前切⾯中使⽤，可以直接写⽅法名。在其他切⾯中使⽤必须是全限定⽅法名。
*/
  @Pointcut("execution(* com.lagou.service.impl.*.*(..))")
  public void pointcut(){}
  @Before("pointcut()")
  public void beforePrintLog(JoinPoint jp){
    Object[] args = jp.getArgs();
    System.out.println("前置通知：beforePrintLog，参数是："+Arrays.toString(args));
  }
  @AfterReturning(value = "pointcut()",returning = "rtValue")
  public void afterReturningPrintLog(Object rtValue){
  	System.out.println("后置通知：afterReturningPrintLog，返回值是："+rtValue);
  }
  @AfterThrowing(value = "pointcut()",throwing = "e")
  public void afterThrowingPrintLog(Throwable e){
  	System.out.println("异常通知：afterThrowingPrintLog，异常是："+e);
  }
  @After("pointcut()")
  public void afterPrintLog(){
  	System.out.println("最终通知：afterPrintLog");
  }
  /**
  * 环绕通知
  * @param pjp
  * @return
  */
  @Around("pointcut()")
  public Object aroundPrintLog(ProceedingJoinPoint pjp){
    //定义返回值
    Object rtValue = null;
    try{
      //前置通知
      System.out.println("前置通知");
      //1.获取参数
      Object[] args = pjp.getArgs();
        //2.执⾏切⼊点⽅法
      rtValue = pjp.proceed(args);
      //后置通知
      System.out.println("后置通知");
    }catch (Throwable t){
      //异常通知
      System.out.println("异常通知");
      t.printStackTrace();
    }finally {
      //最终通知
      System.out.println("最终通知");
    }
    	return rtValue;
    }
  }
```

#### 使用注解

在配置类中使用@EnableAspectJAutoProxy注解

``` java
@EnableAspectJAutoProxy //开启spring对注解AOP的⽀持
public class SpringConfiguration {
}
```

### 4、Spring对事务支持

#### 事务概念：

事务指逻辑上的⼀组操作，组成这组操作的各个单元，要么全部成功，要么全部不成功

#### 事务的四⼤特性：

**原⼦性（Atomicity）** 

原⼦性是指事务是⼀个不可分割的⼯作单位，事务中的操作要么都发⽣，要么都不发⽣。

**⼀致性（Consistency）** 

事务必须使数据库从⼀个⼀致性状态变换到另外⼀个⼀致性状态。

**隔离性（Isolation）**

事务的隔离性是多个⽤户并发访问数据库时，数据库为每⼀个⽤户开启的事务，每个事务不能被其他事务的操作数据所⼲扰，多个并发事务之间要相互隔离。

**持久性（Durability）**
持久性是指⼀个事务⼀旦被提交，它对数据库中数据的改变就是永久性的，接下来即使数据库发⽣故障也不应该对其有任何影响。

#### 事务隔离级别

脏读：⼀个线程中的事务读到了另外⼀个线程中未提交的数据。

不可重复读：⼀个线程中的事务读到了另外⼀个线程中已经提交的update的数据（前后内容不⼀样）

虚读（幻读）：⼀个线程中的事务读到了另外⼀个线程中已经提交的insert或者delete的数据（前后条数不⼀样）

数据库共定义了四种隔离级别：

Serializable（串⾏化）：可避免脏读、不可重复读、虚读情况的发⽣。（串⾏化） 最⾼

Repeatable read（可重复读）：可避免脏读、不可重复读情况的发⽣。(幻读有可能发⽣) 第⼆该机制下会对要update的⾏进⾏加锁

Read committed（读已提交）：可避免脏读情况发⽣。不可重复读和幻读⼀定会发⽣。 第三

Read uncommitted（读未提交）：最低级别，以上情况均⽆法保证。(读未提交) 最低

MySQL的默认隔离级别是：REPEATABLE READ
查询当前使⽤的隔离级别： select @@tx_isolation;
设置MySQL事务的隔离级别： set session transaction isolation level xxx; （设置的是当前mysql连接会话的，并不是永久改变的）

#### 事务传播行为

事务往往在service层进⾏控制，如果出现service层⽅法A调⽤了另外⼀个service层⽅法B，A和B⽅法本身都已经被添加了事务控制，那么A调⽤B的时候，就需要进⾏事务的⼀些协商，这就叫做事务的传播⾏为。

| PROPAGATION_REQUIRED      | 如果当前没有事务，就新建⼀个事务，如果已经存在⼀个事务中，加⼊到这个事务中。这是最常⻅的选择。 |
| ------------------------- | ------------------------------------------------------------ |
| PROPAGATION_SUPPORTS      | ⽀持当前事务，如果当前没有事务，就以⾮事务⽅式执⾏。         |
| PROPAGATION_MANDATORY     | 使⽤当前的事务，如果当前没有事务，就抛出异常。               |
| PROPAGATION_REQUIRES_NEW  | 新建事务，如果当前存在事务，把当前事务挂起。                 |
| PROPAGATION_NOT_SUPPORTED | 以⾮事务⽅式执⾏操作，如果当前存在事务，就把当前事务挂起。   |
| PROPAGATION_NEVER         | 以⾮事务⽅式执⾏，如果当前存在事务，则抛出异常。             |
| PROPAGATION_NESTED        | 如果当前存在事务，则在嵌套事务内执⾏。如果当前没有事务，则执⾏与PROPAGATION_REQUIRED类似的操作。 |



# 代理模式

**静态代理及动态代理区别：有没有代理类**

动态代理可以使用JDK动态代理，和CGLIB动态代理扩展

JDK动态代理委托对象必须实现接口，CGLIB而不需要