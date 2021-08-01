package dao.db;


import dao.UserInfoDao;
import models.UserInfo;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Random;

public class UserInfoTest{
    static UserInfoDao userInfoDao = new UserInfoDao();

    /**
     * 添加不存在的用户
     */
    @Test
    public void add_test() throws SQLException {
        UserInfo userInfo = new UserInfo();
        Random random = new Random();

        userInfo.setUsername("a"+random.nextInt(50)+1);
        userInfo.setPassword("a"+random.nextInt(50)+1);
        boolean flag = userInfoDao.add(userInfo);
        Assert.assertTrue(flag);
    }

    /**
     * 添加null用户
     */
    @Test
    public void add_test1() throws SQLException {
        boolean flag = userInfoDao.add(null);
        Assert.assertFalse(flag);
    }

    /**
     * 添加已经存在的用户
     */
    @Test
    public void add_test2() throws SQLException {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("xw");
        userInfo.setPassword("123");
        boolean flag = userInfoDao.add(userInfo);
        Assert.assertFalse(flag);
    }

    /**
     * 添加用户名为空的用户
     */
    @Test
    public void add_test3() throws SQLException {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("");
        userInfo.setPassword("123");
        boolean flag = userInfoDao.add(userInfo);
        Assert.assertFalse(flag);
    }

    /**
     * 添加密码为空的用户
     */
    @Test
    public void add_test4() throws SQLException {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("asd");
        userInfo.setPassword("");
        boolean flag = userInfoDao.add(userInfo);
        Assert.assertFalse(flag);
    }

    /**
     * 添加null用户
     */
    @Test
    public void add_test7() throws SQLException {
        boolean flag = userInfoDao.add(null);
        Assert.assertFalse(flag);
    }

    /**
     * 添加用户名长度大于5的用户
     */
    @Test
    public void add_test5() throws SQLException {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("asdaaa");
        userInfo.setPassword("");
        boolean flag = userInfoDao.add(userInfo);
        Assert.assertFalse(flag);
    }

    /**
     * 添加密码长度大于5的用户
     */
    @Test
    public void add_test6() throws SQLException {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("asd");
        userInfo.setPassword("asdasd");
        boolean flag = userInfoDao.add(userInfo);
        Assert.assertFalse(flag);
    }

    /**
     * 测试查找存在的用户
     */
    @Test
    public void getUserInfo_test() throws SQLException {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("xw");
        userInfo.setPassword("123");
        UserInfo userInfo1 = userInfoDao.getUserInfo(userInfo);
        Assert.assertNotEquals(0,userInfo1.getId());
    }

    /**
     * 测试查找不存在的用户
     */
    @Test
    public void getUserInfo_test1() throws SQLException {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("zzzzzzzzzzzzzzz");
        userInfo.setPassword("zzzzzzzzzzzzzzz");
        UserInfo userInfo1 = userInfoDao.getUserInfo(userInfo);
        Assert.assertEquals(0,userInfo1.getId());
    }
}
