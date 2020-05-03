package com.ye.mapper;

import com.ye.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

//整合1
public class UserMapperImpl implements UserMapper{
    SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }
    @Override
    public List<User> selectUser() {
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        return mapper.selectUser();
    }
}
