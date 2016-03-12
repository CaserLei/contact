package com.caserlei.contact;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
public class ContactOperatorImpl implements ContactOperator{

	/**
	 * 添加联系人
	 */
	@Override
	public void addContact(Contact contact) {
		
		
		org.dom4j.Document doc=null;
		Element rootElem=null;
		try {
			
			File file=new File("./src/com/caserlei/contact.xml");
			if(!file.exists()){
				//创建xml文件
				 doc=DocumentHelper.createDocument();
				//创建根标签
				 rootElem=doc.addElement("contactList");
			}else{
				doc=XMLUtil.getDocumnet();
				//读取根标签
				rootElem=doc.getRootElement();
			}
			/**
			 * 需求：把contact对象保存到xml文档中
			 */
			
			
			/**
			 <contact id="1">
			    <name></name>
			    <gender></gender>
			    <age></age>
			    <phone></phone>
			    <email></email>
			    <qq></qq>
			 </contact>
			 */
			
			Element contactElem=rootElem.addElement("contact");
			contactElem.addAttribute("id", contact.getId());
			contactElem.addElement("name").setText(contact.getName());
			contactElem.addElement("gender").setText(contact.getGender());
			contactElem.addElement("age").setText(contact.getAge()+"");
			contactElem.addElement("phone").setText(contact.getPhone());
			contactElem.addElement("email").setText(contact.getEmail());
			contactElem.addElement("qq").setText(contact.getQq());
			
			
			//把Document写出到xml文件
			FileOutputStream out=new FileOutputStream("./src/com/caserlei/contact.xml");
			OutputFormat format=OutputFormat.createPrettyPrint();
			format.setEncoding("UTF-8");
			XMLWriter writer=new XMLWriter(out,format);
			writer.write(doc);
			writer.close();
	
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 修改联系人
	 */
	@Override
	public void updateContact(Contact contact) {
		/**
		 * 需求：修改id值为2的联系人
		 * 1）查询id值为2的contact标签
		 * 2）修改contact标签的内容
		 */
		//1.读取xml文件
		try {
			org.dom4j.Document doc=XMLUtil.getDocumnet();
			Element contactElem=(Element)doc.selectSingleNode("//contact[@id='"+contact.getId()+"']");
			//2.修改contact标签内容
			contactElem.element("name").setText(contact.getName());
			contactElem.element("gender").setText(contact.getGender());
			contactElem.element("age").setText(contact.getAge()+"");
			contactElem.element("phone").setText(contact.getPhone());
			contactElem.element("email").setText(contact.getEmail());
			contactElem.element("qq").setText(contact.getQq());
			
			
			//把Document写出到xml文件
			XMLUtil.write2xml(doc);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		
	}

	/**
	 * 删除联系人
	 */
	@Override
	public void deleteContact(String id) {
		try{
			//1.读取xml文件
			org.dom4j.Document doc=XMLUtil.getDocumnet();
			//查询需要删除id的contact
			Element contactElem=(Element)doc.selectSingleNode("//contact[@id='"+id+"']");
			contactElem.detach();
			//把Document写出到xml文件
			XMLUtil.write2xml(doc);
		}catch (Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public List<Contact> findAll() {
		//读取xml文件
		org.dom4j.Document doc=XMLUtil.getDocumnet();
		
		//2.创建contact标签
		List<Contact> list=new ArrayList<Contact>();
		//3.读取contact标签
		List<Element> contactList=(List<Element>)doc.selectNodes("//contact");
		for (Element e: contactList) {
			//创建contact 对象
			Contact c=new Contact();
			c.setId(e.attributeValue("id"));
			c.setName(e.elementText("name"));
			c.setGender(e.elementText("gender"));
			c.setAge(Integer.parseInt(e.elementText("age")));
			c.setEmail(e.elementText("email"));
			c.setPhone(e.elementText("phone"));
			c.setQq(e.elementText("qq"));
			list.add(c);
		}
		return list;
	}

}
