package org.java.uitl;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

/**
 * jdbc工具类
 */
public class JdbcUtil {

    private static DataSource ds;

    static{
        try{
            //加载属性文件
            InputStream in = JdbcUtil.class.getClassLoader().getResourceAsStream("druid.properties");
            //创建属性类
            Properties prop = new Properties();
            //用属性类加载输入流的数据
            prop.load(in);

            //产生数据源
           ds = DruidDataSourceFactory.createDataSource(prop);


        }catch (Exception ex){
            ex.printStackTrace();
        }



    }

    public static DataSource getDataSource(){
        return ds;
    }
}
