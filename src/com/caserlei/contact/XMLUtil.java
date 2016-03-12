package com.caserlei.contact;

import java.io.File;
import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * xml操作的工具类
 * @author Administrator
 *
 */
public class XMLUtil {
	/**
	 * 用于读取xml文件
	 * @return
	 */
	public static org.dom4j.Document getDocumnet(){
		try{
			org.dom4j.Document doc=new SAXReader().read(new File("./src/com/caserlei/contact.xml"));
			
			return doc;
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	/**
	 * 写出xml文件
	 */
	public static void write2xml(Document doc){
		try {
			//把Document写出到xml文件
			FileOutputStream out=new FileOutputStream("./src/com/caserlei/contact.xml");
			OutputFormat format=OutputFormat.createPrettyPrint();
			format.setEncoding("UTF-8");
			XMLWriter writer=new XMLWriter(out,format);
			writer.write(doc);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
