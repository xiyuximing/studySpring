package com.cy.edu.factory;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.xml.parsers.SAXParser;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Yang on 2020/10/5.
 * 工厂类，生产对象（使用反射）
 */
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
