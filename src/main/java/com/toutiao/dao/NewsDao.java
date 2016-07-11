package com.toutiao.dao;

import com.toutiao.model.News;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by MengHan on 2016/7/10.
 */
public interface NewsDao {

    String TABLE_NAME = "news";
    String INSERT_FIELDS = " title, link, image, like_count, comment_count, created_date, user_id ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS,
            ") values (#{title},#{link},#{image},#{likeCount},#{commentCount},#{createdDate},#{userId})"})
    int addNews(News news);

    List<News> selectByUsrIdAndOffset(@Param("userId")int userId, @Param("offset") int offset,
                                      @Param("limit") int limit);

}
