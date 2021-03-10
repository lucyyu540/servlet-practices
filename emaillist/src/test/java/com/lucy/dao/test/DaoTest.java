package com.lucy.dao.test;

import java.util.List;

import com.lucy.dao.Dao;
import com.lucy.model.EmailListVo;

public class DaoTest {
	public static void testSelectAll() {
		List<EmailListVo> l = new Dao().selectAll();
		for (EmailListVo e : l) System.out.println(e.toString());
	}
	public static void main(String[] args) {
		testSelectAll();
	}

}
