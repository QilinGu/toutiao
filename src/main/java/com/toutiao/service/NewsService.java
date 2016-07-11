package com.toutiao.service;

import com.toutiao.dao.NewsDao;
import com.toutiao.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MengHan on 2016/7/11.
 */
@Service
public class NewsService {

    @Autowired
    private NewsDao newsDao;

    public List<News> getLatestNews(int userId, int offset, int limit) {
        return newsDao.selectByUserIdAndOffset(userId, offset, limit);
    }


}
