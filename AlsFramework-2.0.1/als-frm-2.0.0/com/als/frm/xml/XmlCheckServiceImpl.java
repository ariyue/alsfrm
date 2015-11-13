package com.als.frm.xml;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XmlCheckServiceImpl
  implements IXmlChecker
{
  private Logger log = Logger.getLogger(super.getClass());

  public XmlCheckServiceImpl()
  {
    /*String mb_bankcode = MbfeConstants.MB_BANKCODE;
    if (mb_bankcode.equalsIgnoreCase(""))
      return;
    this.log.info("加载配置文件属性完成");*/
  }

  public String validate(byte[] xsd, byte[] xml)
  {
    String ret = null;
    try
    {
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

      dbf.setNamespaceAware(true);
      dbf.setIgnoringComments(true);
      DocumentBuilder builder = dbf.newDocumentBuilder();

      Document doc = builder.parse(new ByteArrayInputStream(xml));

      SchemaFactory constraintFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");

      Source constraints = new StreamSource(new ByteArrayInputStream(xsd));
      Schema schema = constraintFactory.newSchema(constraints);

      Validator validator = schema.newValidator();

      validator.validate(new DOMSource(doc));
    }
    catch (SAXException e)
    {
      e.printStackTrace();
      ret = "报文格式检查失败";
      this.log.error("格式检查失败", e);
    }
    catch (IOException e)
    {
      e.printStackTrace();
      ret = "报文格式检查失败";
      this.log.error("格式检查失败", e);
    }
    catch (Exception e)
    {
      ret = "报文格式检查失败";
      this.log.error("格式检查失败", e);
    }
    return ret;
  }

  public static void main(String[] args) throws Exception
  {
    byte[] xsd = readFile("d:\\005.xsd");
    //如果<?xml version="1.0" encoding="UTF-8" standalone="no" ?>前面还有别的元素的话
    //例如，电子商业汇票中还有报文头,此时检查时，要把这个“头”先分离出来，然后再进行检查
    //{H:011000        CD        9074510006  CD        9968        9074510006  20120926195832005                 9968ENPC2587715613  000000000000000099013N0000226210e4af140ccc2cd80f1271ef41e1ce1a        }
    //<?xml version="1.0" encoding="UTF-8" standalone="no" ?>

    byte[] xml = readFile("d:\\005.xml");
    IXmlChecker chk = new XmlCheckServiceImpl();
    String ret = chk.validate(xsd, xml);
    System.out.println(ret);
  }

  private static byte[] readFile(String filename) throws Exception
  {
    InputStream is = new FileInputStream(filename);
    byte[] bs = new byte[is.available()];
    is.read(bs);
    is.close();

    return bs;
  }
}