package com.xue.test;

import com.xue.bean.City;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTestdemo {
    private SqlSession sqlSession;  //面试题： 讲一下 mybatis的执行流程
    private SqlSessionFactory sqlSessionFactory;
    @Before  //在进行@Test 注解之前，执行的方法， 提取重复的代码的
    public void before() throws Exception {
        //加载并读取xml
        String path="SqlMapConfig.xml";
        InputStream is = Resources.getResourceAsStream(path);
        // sql 连接的 工厂类
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
        sqlSession = sqlSessionFactory.openSession();
        System.out.println("sqlSession = " + sqlSession);
    }

    // 写出 1 对多的动态sql  城市的
    @Test
    public void test01(){
        Map map=new HashMap();
        map.put("cname","郑州");
        map.put("qname","金水区");

        List<City> cities = sqlSession.selectList("com.xue.dao.CityDAO.selectAndCantonal", map);
        for (City city : cities) {
            System.out.println("city = " + city);
        }
        sqlSession.close();
    }
}
