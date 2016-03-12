package com.caserlei.contact;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * 主程序
 * @author Administrator
 *
 */
public class MainProgram {
	public static void main(String[] args) {
		ContactOperator operator=null;
		try {			
			while(true){
				//看到菜单
				printMenu();
				//2.接收用户输入命令
				//Scanner scanner=new Scanner(System.in);
				//String command=scanner.next();
				BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				String command=br.readLine();
				
				 operator=new ContactOperatorImpl();
				//3.根据用户不同的输入执行不同的操作！
				if("1".equals(command)){
					//获取用户输入的数据
					Contact  contact=null;
					//获取姓名
					String name=br.readLine();
					contact.setName(name);
					
					
					operator.addContact(contact);
				}else if("2".equals(command)){
					//获取输入的数据
					Contact contact=null;
					//获取姓名
					String id=br.readLine();
					String name=br.readLine();
					contact.setId(id);
					contact.setName(name);
					operator.updateContact(contact);
				}else if("3".equals(command)){
					//删除联系人
					//获取需要删除的ID
					String id=br.readLine();
					
					operator.deleteContact(id);
				}else if("4".equals(command)){
					//查询所有联系人
					List<Contact> list=operator.findAll();
					//打印输出
					for (Contact contact : list) {
						System.out.println(contact);
					}
				}else if("Q".equals(command)){
					break;
				}else{
					System.out.println("输入的命令有误！");
				}
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void printMenu() {
		//看到菜单
		System.out.println("=======================");
		System.out.println("[1]添加联系人");
		System.out.println("[2]修改联系人");
		System.out.println("[3]删除联系人");
		System.out.println("[4]查看所有联系人");
		System.out.println("[Q]退出系统");
		System.out.println("===========================");
	}

}
