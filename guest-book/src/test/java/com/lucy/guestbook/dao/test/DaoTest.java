package com.lucy.guestbook.dao.test;

import java.util.List;
import java.util.Scanner;

import com.lucy.guestbook.dao.Dao;
import com.lucy.guestbook.model.GuestVo;

public class DaoTest {
	public static void createTest() {
		Dao dao = new Dao();
		dao.create(new GuestVo("daotest", "pw", "from daotest"));
		
	}
	public static void selectAllTest() {
		List<GuestVo> l = new Dao().selectAll();
		for (GuestVo g : l ) System.out.println(g.toString());
	}
	public static void deleteTest() {
		System.out.print("enter [id password] >> : ");
		Scanner in = new Scanner(System.in);
		new Dao().delete(in.nextInt(), in.next());
	}
	public static void main(String[] args) {
		createTest();
		selectAllTest();
		deleteTest();
		selectAllTest();
	}
}
