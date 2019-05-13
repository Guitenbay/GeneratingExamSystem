/**
 * Lu Haoyang
 */

package com.software.test.generatingexam.serviceTest;

import com.software.test.generatingexam.baseTest.SpringTestCase;
import com.software.test.generatingexam.bean.Syllabus;
import com.software.test.generatingexam.bean.User;
import com.software.test.generatingexam.service.SyllabusService;
import com.software.test.generatingexam.service.UserService;
import com.software.test.generatingexam.service.impl.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceTest extends SpringTestCase {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;

    @Test
    public void testFindAllUser(){
        List<User> userList = userService.findAll();
        logger.info(String.format("尝试取出第一个实例的username：%s", userList.get(0).getUsername()));
        Assert.assertTrue(userList.size() > 0);
    }

    @Test
    public void testFindById(){
        User user = userService.selectUserById(774);
        Assert.assertEquals("zhuxiaoning", user.getUsername());
    }

    @Test
    public void testUpdateUsername(){
        User user = userService.selectUserById(828);
        user.setUsername("test_name");
        userService.update("username", user);
        user = userService.selectUserById(user.getId());
        Assert.assertEquals("test_name", user.getUsername());
    }

    @Test
    public void testUpdateEmail(){
        User user = userService.selectUserById(828);
        user.setEmail("test_email");
        userService.update("email", user);
        user = userService.selectUserById(user.getId());
        Assert.assertEquals("test_email", user.getEmail());
    }

    @Test
    public void testUpdatePhone(){
        User user = userService.selectUserById(828);
        user.setPhone("test_phone");
        userService.update("phone", user);
        user = userService.selectUserById(user.getId());
        Assert.assertEquals("test_phone", user.getPhone());
    }

    @Test
    public void testUpdateFullname(){
        User user = userService.selectUserById(828);
        user.setFull_name("test_fullname");
        userService.update("fullname", user);
        user = userService.selectUserById(user.getId());
        Assert.assertEquals("test_fullname", user.getFull_name());
    }

    @Test
    public void testUpdateAdmin(){
        User user = userService.selectUserById(828);
        user.setAdmin(true);
        userService.update("admin", user);
        user = userService.selectUserById(user.getId());
        Assert.assertTrue(user.isAdmin());
    }

    @Test
    public void testUpdateEnabled(){
        User user = userService.selectUserById(828);
        user.setEnabled(true);
        userService.update("enabled", user);
        user = userService.selectUserById(user.getId());
        Assert.assertTrue(user.isEnabled());
    }

    @Test
    public void testUpdateNothing(){
        User user = userService.selectUserById(828);
        user.setEmail("test");
        userService.update("asffadgdsag", user);
        user = userService.selectUserById(user.getId());
        Assert.assertNotEquals("test", user.getEmail());
    }

    @Test
    public void testForNoSuchId(){
        User user = userService.selectUserById(100000);
        Assert.assertNull(user);
    }
}
