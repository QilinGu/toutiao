package com.toutiao;

import com.toutiao.dao.UserDao;
import com.toutiao.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;

/**
 * Created by MengHan on 2016/7/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ToutiaoApplication.class)
public class InitDatabase {

    @Autowired
    UserDao userDao;

    @Test
    public void contextLoads(){
//        Random random = new Random();
//        for(int i=1;i<11;i++){
//            User user = new User();
//            user.setHeadUrl(String.format("http://images.nowcoder.com/head/%dt.png", random.nextInt(1000)));
//            user.setName(String.format("USER%d", i));
//            user.setPassword("");
//            user.setSalt("");
//            userDao.addUser(user);
//
//            user.setPassword("newPassword");
//            userDao.updatePassword(user);
//        }
        Assert.assertEquals("newPassword",userDao.selectUserById(18).getPassword());
        userDao.deleteById(17);
        Assert.assertNull(userDao.selectUserById(17));
    }
}
