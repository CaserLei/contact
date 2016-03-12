package com.caserlei.contact;

import java.util.List;

/**
 * 该接口用于存放来形容相关操作的方法。
 * @author Administrator
 *
 */
public interface ContactOperator {
	public void addContact(Contact contact);//增加联系人
	public void updateContact(Contact contact);//修改联系人
	public void deleteContact(String id);//删除联系人
	public List<Contact> findAll();//查询所有联系人

}
