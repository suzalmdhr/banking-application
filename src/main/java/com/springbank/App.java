package com.springbank;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.empDao.EmpDao;
import com.springbank.entities.Employee;
import com.spring.empDao.EmpDaoImpl;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        ApplicationContext ctx=new ClassPathXmlApplicationContext("com/springbank/config.xml");
        EmpDaoImpl emps = (EmpDaoImpl) ctx.getBean("empDao");
        
        Scanner scan=new Scanner(System.in);
        
        Boolean so=true;
        
        while(so) {
        	
        	System.out.println("1:WITHDRAW the amount");
        	System.out.println("2:TRANSFER the amount");
        	System.out.println("3:CHECK YOUR BALANCE");
        	System.out.println("4.DEPOSIT");
        	
        	try{
        		System.out.println("Enter the option");
        		int opt=scan.nextInt();
        		
        		switch(opt) {
        		
        		case 1:
        			System.out.println("Enter pin number");
        			int pinNo=scan.nextInt();
        			
 
        			
        			System.out.println("Enter amount you want to withdraw");
        			int amt=scan.nextInt();
        			
        			Employee emp=emps.getEmployee(pinNo);
        			int a= emp.getAmount();
        			
        			
        			int amount=a-amt;
        			emp.setAmount(amount);
        		
        			System.out.println(amount + " is remaining");
        			
        			Employee lel=new Employee();
        			lel.setAmount(amount);
        			lel.setPinNum(pinNo);
        			
        			int result=emps.change(lel);
        			System.out.println(result + "changed");
        			
        			
        			//Employee e=new Employee();
        			//int a= e.getAmount();
        			//System.out.println(a);
        			//int amount=a-amt;
        			//e.setPinNum(pinNo);
        			//e.setAmount(amount);
        			
        			//int change=emps.change(e);
        			//System.out.println("Amount debited"+ change);
        			
        			
        			break;
        			
        		case 2:
        			System.out.println("Enter pin number");
        			int pid=scan.nextInt();
        			
        			System.out.println("Enter pin that where you want to transfer");
        			int trans=scan.nextInt();
        			
        			System.out.println("Enter the amount that you want to transfer");
        			int am=scan.nextInt();
        			
        			//collect database bata amount of user and process
        			Employee collectEm= emps.getEmployee(pid);
        			int UserKoAmt= collectEm.getAmount();
        			int UserKoLastAmt=UserKoAmt-am;
        			
        			
        			//object banaera update garyo
        			Employee finEm=new Employee();
        			finEm.setAmount(UserKoLastAmt);
        			finEm.setPinNum(pid);
        			
        			//Debited PARTTT
        			
        			int userKoResult= emps.change(finEm);
        			System.out.println("Debited gandu");
        			System.out.println(userKoResult+ " changed");
        			
        			//jasko ma transfer garnu thyo tesko amount database bata liera process garyo
        			Employee storeEm=emps.getEmployee(trans);
        			int clientKoAmt=storeEm.getAmount();
        			int clientKoFinalAmt=am+clientKoAmt;
        			
        			Employee finClientValue=new Employee();
        			finClientValue.setAmount(clientKoFinalAmt);
        			finClientValue.setPinNum(trans);
        			
        			
        			//Credited part
        			//object banaera value update garyo
        			int ClientKoResult=emps.change(finClientValue);
        			//System.out.println("Credited gandu");
        			//System.out.println(ClientKoResult +" changed");
        			
        			
        			break;
        			
        		case 3:
        			System.out.println("Enter the number");
        			int chkPin=scan.nextInt();
        			
        			Employee chck=emps.getEmployee(chkPin);
        			System.out.println("Yout balance is:" + chck.getAmount());
        			 so=false;
        			
        			break;
        			
        		case 4:
        			System.out.println("Input pin");
        			int pin=scan.nextInt();
        			System.out.println("Enter your name");
        			String name=scan.next();
        			System.out.println("Enter your amount");
        			int amounts=scan.nextInt();
        			
        			System.out.println(pin);
        			System.out.println(name);
        			System.out.println(amounts);
        			
        			Employee empss=new Employee();
        			empss.setName(name);
        			empss.setPinNum(pin);
        			empss.setAmount(amounts);
        			
        			
        		int insert = emps.insert(empss);
        		System.out.println("ok inserted"+ insert);
        		
        		}
        		
        	}
        	catch(Exception e) {
        		System.out.print("wrong input");
        		System.out.print(e.getMessage());
        	}
        }
        
    }
}
