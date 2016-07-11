package com.toutiao;

import com.toutiao.dao.LoginTicketDao;
import com.toutiao.dao.NewsDao;
import com.toutiao.dao.UserDao;
import com.toutiao.model.LoginTicket;
import com.toutiao.model.News;
import com.toutiao.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.Random;

/**
 * Created by MengHan on 2016/7/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ToutiaoApplication.class)
public class InitDatabase {

    @Autowired
    UserDao userDao;

    @Autowired
    NewsDao newsDao;

    @Autowired
    LoginTicketDao loginTicketDao;

    @Test
    public void contextLoads(){
        Random random = new Random();
        for(int i=1;i<11;i++){
            User user = new User();
            user.setHeadUrl(String.format("http://images.nowcoder.com/head/%dt.png", random.nextInt(1000)));
            user.setName(String.format("USER%d", i));
            user.setPassword("");
            user.setSalt("");
            userDao.addUser(user);

            News news = new News();
            news.setCommentCount(i);
            Date date = new Date();
            date.setTime(date.getTime() + 1000*3600*5*i);
            news.setCreatedDate(date);
            news.setImage(String.format("http://images.nowcoder.com/head/%dm.png", random.nextInt(1000)));
            news.setLikeCount(i+1);
            news.setUserId(user.getId());
            news.setTitle(String.format("TITLE{%d}", i));
            news.setLink(String.format("http://www.nowcoder.com/%d.html", i));
            newsDao.addNews(news);

            user.setPassword("newPassword");
            userDao.updatePassword(user);

            LoginTicket ticket = new LoginTicket();
            ticket.setStatus(0);
            ticket.setUserId(user.getId());
            ticket.setExpired(date);
            ticket.setTicket(String.format("TICKET%d",i+1));
            loginTicketDao.addTicket(ticket);
        }
    }
}
