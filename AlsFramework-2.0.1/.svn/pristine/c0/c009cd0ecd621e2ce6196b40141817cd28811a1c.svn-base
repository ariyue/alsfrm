package com.als.frm.comm.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.CDATA;
import org.jdom.DataConversionException;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class XmlUtil {
    
    /**
     * 从xml文件对象获取documen对象
     * @param file  文件对象
     * @return
     * @throws JDOMException
     */
    public static Document parseByFile(File file) 
        throws JDOMException, IOException
    {
        SAXBuilder parse = new SAXBuilder();
        Document doc = parse.build(file);
        return doc;
    }

    /**
     * 从输入流文件对象获取documen对象
     * @param in
     * @return
     * @throws JDOMException
     */
    public static Document parseByInputStream(InputStream in) 
        throws JDOMException , IOException
    {
        SAXBuilder parse = new SAXBuilder();
        Document doc = parse.build(in);
        return doc;
    }

    /**
     * 从文件路径对象获取documen对象
     * @param file
     * @return
     * @throws JDOMException
     */
    public static Document parseByFilePath(String file) 
        throws JDOMException , IOException
    {
        SAXBuilder parse = new SAXBuilder();
        Document doc = parse.build(file);
        return doc;
    }
    
    /**
     * 从reader对象获取documen对象
     * @param reader
     * @return
     * @throws JDOMException
     */
    public static Document parseByReader(Reader reader) 
        throws JDOMException , IOException
    {
        SAXBuilder parse = new SAXBuilder();
        Document doc = parse.build(reader);
        return doc;
    }
    
    /**
     * 构造Document对象
     * @param root
     * @return
     */
    public static Document getDocument(Element root) {
        return new Document(root);
    }
    
    /**
     * 获取子节点
     * @param element
     * @param name
     * @return
     */
    public static Element getChild(Element element, String name) {
        if(element == null || name == null) {
            return null;
        }
        return element.getChild(name);
    }
    
    
    /**
     * 设置标签元素的值
     * @param doc1
     * @param current
     * @param tagvalue
     * @param editvalue
     */
    public static void setElementValue(Document doc,Element current,
            String tagvalue,String editvalue)
    {
        Element editchild=null;
      
        if (current==null) {
            current=doc.getRootElement();
        }
      
        if ((editchild=current.getChild(tagvalue))!=null)
        {
            editchild.setText(editvalue);
            return;
        }

        List children =current.getChildren();
        Iterator iterator = children.iterator();
      
        while (iterator.hasNext())
        {
            Element child = (Element) iterator.next();
            setElementValue(doc,child,tagvalue,editvalue);
        }
    }
    
   /**
    * 在指定XML的Document中寻找标签为tagvalue的结点
    * @param doc
    * @param current
    * @param tagvalue
    * @return
    */
    public static String getElementValue(Document doc, 
            Element current, String tagvalue)
    {
        Element editchild=null;
        if (current==null) {
            current=doc.getRootElement();
        }
        if ((editchild = current.getChild(tagvalue))!=null) {
            return editchild.getTextTrim();
        }
      
        List children =current.getChildren();
        Iterator iterator = children.iterator();
        String returnvalue = "";
        while (iterator.hasNext())
        {
            Element child = (Element) iterator.next();
            returnvalue=getElementValue(doc , child , tagvalue);
            if (returnvalue.trim().length()>0) {
                return returnvalue;
            }
        }
        
        return null;
    }
    
    /**
     * 获取元素的值
     * @param element
     * @return
     */
    public static String getElementText(Element element)
    {
        if( element == null ) {
            return null;
        }
        return element.getText().trim();
    }
 
    /**
     * 获取节点的指定子节点的值(该方法只针对一级子节点)
     * @param element   父节点
     * @param name      子节点名称
     * @return
     */
    public static String getChildValue(Element element, String name)
    {
        if( element == null || name == null || name.length() < 1) {
            return null;
        }
        
        Element child = element.getChild(name);
        if(child == null) {
            return null;
        } else {
            return child.getText().trim();
        }
    }
    
    /**
     * 获取元素的属性值
     * @param element   
     * @param attrName
     * @return
     */
    public static String getAttribute(Element element, String attrName)
    {
        if(element == null || attrName == null || attrName.length() < 1) {
            return null;
        }
        Attribute attribute = element.getAttribute(attrName);
        if(attribute == null) {
            return null;
        }
        return element.getAttributeValue(attrName).trim();
    }
    
    
    /**
     * 获取元素的属性值(整型)
     * @param element   
     * @param attrName
     * @return
     */
    public static int getAttributeInt(Element element, 
            String attrName, int defVal)
    {
        if(element == null || attrName == null || attrName.length() < 1) {
            return defVal;
        }
        Attribute attribute = element.getAttribute(attrName);
        if(attribute == null) {
            return defVal;
        }
        try {
            
            return attribute.getIntValue();
        } catch(DataConversionException ex) {
            ex.printStackTrace();
            return defVal;
        }
    }
    
    /**
     * 获取元素的属性值(布尔型)
     * @param element   
     * @param attrName
     * @return
     */
    public static boolean getAttributeBool(Element element, 
            String attrName, boolean defBool)
    {
        if(element == null || attrName == null || attrName.length() < 1) {
            return defBool;
        }
        Attribute attribute = element.getAttribute(attrName);
        if(attribute == null) {
            return defBool;
        }
        try {
            return attribute.getBooleanValue();
        } catch(DataConversionException ex) {
            ex.printStackTrace();
            return defBool;
        }
    }
    
    /**
     * 获取元素的属性值(浮点类型)
     * @param element   
     * @param attrName
     * @return
     */
    public static double getAttributeDouble(Element element, 
            String attrName, double defDouble)
    {
        if(element == null || attrName == null || attrName.length() < 1) {
            return defDouble;
        }
        Attribute attribute = element.getAttribute(attrName);
        try {
            return attribute.getDoubleValue();
        } catch(DataConversionException ex) {
            ex.printStackTrace();
            return defDouble;
        }
    }
    
    /**
     * 获取元素的属性值(浮点类型)
     * @param element   
     * @param attrName
     * @return
     */
    public static long getAttributeLong(Element element, 
            String attrName, long defLong)
    {
        if(element == null || attrName == null || attrName.length() < 1) {
            return defLong;
        }
        Attribute attribute = element.getAttribute(attrName);
        try {
            return attribute.getLongValue();
        } catch(DataConversionException ex) {
            ex.printStackTrace();
            return defLong;
        }
    }
    
    
    /**
     * 添加孩子节点
     * @param parent
     * @param child
     */
    public static void addChild(Element parent , Element child)
    {
        parent.addContent(child);
    }
    
    /**
     * 添加孩子节点
     * @param parent
     * @param name
     * @param value
     */
    public static Element addChild(Element parent , String name , String value)
    {
        Element ele = new Element(name);
        ele.setText(value);
        parent.addContent(ele);
        return ele;
    }
    
    /**
     * 设置节点值
     * @param parent
     * @param name
     * @param value
     */
    public static void setChildValue(Element parent , String name , String value)
    {
        Element child = null;
        if(value == null) {
            return;
        }
        child = parent.getChild(name);
        if(child != null) {
            child.setText(value);
        } else {
            addChild(parent , name , value);
        }
    }
    
    /**
     * 设置节点值
     * @param parent
     * @param name
     * @param value
     */
    public static void setChildCDATAValue(Element parent , String name , String value)
    {
        Element child = null;
        if(value == null) {
            return;
        }
        child = parent.getChild(name);
        if(child != null) {
            parent.removeChild(name);
        }
        
        Element element = new Element(name);
        CDATA cData = new CDATA(value);
        element.addContent(cData);
        parent.addContent(element);
    }
    
    
    /**
     * 把xml格式文档转变成字符串
     * @param document      document对象
     * @param indent        分割符
     * @param newLine       是否使用分行模式
     * @param encoding      转变后的直接编码
     * @return              xml字符串
     * @throws IOException  读写异常
     */
    public static String getXmlString(Document document) throws IOException
    {
        Format format = Format.getPrettyFormat();
        XMLOutputter output = new XMLOutputter(format);
        return output.outputString(document);
    }
}