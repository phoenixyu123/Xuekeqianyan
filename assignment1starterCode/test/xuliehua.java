package test;

import java.io.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class xuliehua{
    public class Skill{
        
    }
    public static class Student{
        private String name;
        private int age;
        private Skill skill;
        public Student(){

        }
        public Student(String name, int age){
            this.name = name;
            this.age = age;
        }
        public Skill getSkill(){
            return skill;
        }
        public void setSkill(Skill skill){
            this.skill= skill;
        }
        public String toString(){
            return  "Student [name="+name+", age="+age+", skill="+skill+"]"; 
        }


    }
    public static void main(String[] args) throws IOException , ClassNotFoundException{
        Student stu1=new Student("张三",18);
        Student stu2=new Student("李四",17);
        Student stu3=new Student("王五",16);
        Student stu4=new Student("赵六",19);
        //Arrays序列化
        ArrayList<Student> list = new ArrayList<Student>();
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);
        list.add(stu4);
        String file = "C:\\study\\Golist\\111.txt";
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(list);

        //反序列化
		ObjectInputStream ins=new ObjectInputStream(new FileInputStream(file));
		ArrayList<Student> list2=new ArrayList<Student>();
		list2=(ArrayList<Student>) ins.readObject();
		for(Student stu:list2) {
			System.out.println(stu);
		}
    }
}