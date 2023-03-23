package com.example.demo.utils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.reflection.SunUnsafeReflectionProvider;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import java.util.StringJoiner;

/**
 * @Auther: zhuxianghui
 * @Date: 2023/2/20-02-20-14:43
 * @Description: com.zxh.demo.annotion
 * @version: 1.0
 */
public class XmlUtils {
    private static final XStream xstream = XStreamFactory.getXStream();

    /**
     * 实体转xml
     * @param obj 对象
     * @param hasHead 是否添加头
     * @return
     */
    public static String beantoXml(Object obj,Class<?> clazz, boolean hasHead) {

        String head = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>";

        // DomDriver
        //XStream xstream = new XStream(new DomDriver());
        xstream.autodetectAnnotations(true);
        xstream.processAnnotations(clazz);
        // xstream 的安全框架没有初始化，xstream 容易受攻击,此处设置默认安全防护,同时设置允许的类
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypeHierarchy(clazz);
        xstream.setClassLoader(Thread.currentThread().getContextClassLoader());
        // 未定义字段不接收
        xstream.ignoreUnknownElements();
        //输出空值的标签
        xstream.registerConverter(new NullConverter(xstream.getMapper(), new SunUnsafeReflectionProvider()), XStream.PRIORITY_VERY_LOW);
        String xml = xstream.toXML(obj);
        xml = hasHead ? buildHead(xml,head) : xml;

        return underlineDoubleToOne(xml);
    }
    /**
     * 添加xml信息头
     * @param<?xml version="1.0" encoding="UTF-8" ?>
     * @return
     */
    public static String buildHead(String xml,String head){
        StringJoiner stringJoiner = new StringJoiner("\n");
        stringJoiner.add(head);
        stringJoiner.add(xml);
        return  stringJoiner.toString();
    }

    /**
     * XStream将java对象转换为xml时，对象字段中的下划线“_”，转换后变成了两个的解决办法
     * @return
     */
    public static String underlineDoubleToOne(String xml){
        xml = xml.replace("__", "_");
        return  xml;
    }


    public static Object xmltoBean(Class<?> clazz, String xml) {

        // DomDriver
        //应用传过来的类的注解
        xstream.processAnnotations(clazz);
        xstream.addPermission(AnyTypePermission.ANY);
        //自动检测注解
        xstream.autodetectAnnotations(true);
        // xstream 的安全框架没有初始化，xstream 容易受攻击,此处设置默认安全防护,同时设置允许的类
        XStream.setupDefaultSecurity(xstream);
        //使用了默认安全框架,此处为必须项
        xstream.allowTypeHierarchy(clazz);
        // 两个类的相等性取决于类名和加载器,XStream必须使用不同的类加载器,防止ClassCastException的快速解决方案是设置当前线程使用的相同类加载器
        xstream.setClassLoader(Thread.currentThread().getContextClassLoader());
        // 未定义字段不接收
        xstream.ignoreUnknownElements();
        xstream.registerConverter(new NullConverter(xstream.getMapper(), new SunUnsafeReflectionProvider()), XStream.PRIORITY_VERY_LOW);

        Object xmlObject= xstream.fromXML(xml);

        return xmlObject;
    }
}
