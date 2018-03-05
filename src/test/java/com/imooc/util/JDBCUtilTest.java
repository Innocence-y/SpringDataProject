package com.imooc.util;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

/**
 * 描述:测试类
 *
 * @author 闫文强
 * @create 2018-03-05 21:44
 */
public class JDBCUtilTest {
	@Test
	public void testGetConnection() throws Exception{
		Connection connection=JDBCUtil.getConnection();
		Assert.assertNotNull(connection);
	}
}
