package com.caserlei.contact;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ContactOperatorImplTest {

	ContactOperator operator=null;
	/**
	 *初始化对象实例
	 */
	@Before
	public void init(){
		operator=new ContactOperatorImpl();
	}
	
	public void testAddContact(){
		Contact contact=new Contact();
		contact.setId("2");
		contact.setName("李磊");
		contact.setGender("男");
		contact.setAge(23);
		contact.setPhone("2324524");
		contact.setEmail("1341324@qq.com");
		contact.setQq("43443335");
		operator.addContact(contact);
	}

	
	public void testUpdateContact(){
		Contact contact=new Contact();
		contact.setId("2");
		contact.setName("王霞");
		contact.setGender("女");
		contact.setAge(20);
		contact.setPhone("2324524");
		contact.setEmail("zhaangldadf@qq.com");
		contact.setQq("43443335");
		operator.updateContact(contact);
	}
	
	@Test
	public void testDeleteContact(){
		operator.deleteContact("2");
	}
	
	public void testFindAll(){
		List<Contact> list=operator.findAll();
		for (Contact contact : list) {
			System.out.println(contact);
		}
	}

}
