/**
 * 
 */
/**
 * 和message表相关的数据库操作
 *
 */
package com.imooc.dao;

import java.io.IOException;
import java.util.ArrayList;
/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;*/
import java.util.List;



import org.apache.ibatis.session.SqlSession;

import com.imooc.bean.Message;
import com.imooc.db.DBAccess;

    public class MessageDao {
    	/*
    	 * 根据查询条件查询消息列表
    	 */
    	
        //以Mybatis方式链接
    	public List<Message> queryMessageList(String command,String description) {
    		DBAccess dbAccess = new DBAccess();
    		List<Message> messageList = new ArrayList<Message>();
    		SqlSession sqlSession = null;
    		try {
    			sqlSession = dbAccess.getSqlSession();
    			//通过sqlSession执行SQL语句
    			messageList = sqlSession.selectList("Message.queryMessageList");
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} finally {
				if(sqlSession != null){
					sqlSession.close();
				}
			}
    		return messageList;
    	}
    	
    	
       //以jdbc方式链接
/*    	public List<Message> queryMessageList(String command,String description) {
    		List<Message> messageList = new ArrayList<Message>();
    	    // MySQL的JDBC URL编写方式：jdbc:mysql://主机名称：连接端口/数据库的名称?参数=值
            // 避免中文乱码要指定useUnicode和characterEncoding
            // 执行数据库操作之前要在数据库管理系统上创建一个数据库，名字自己定，
    		String url ="jdbc:mysql://localhost:3306/wechatchating?"+"user=root&password=090722ms&useUnicode=true&characterEncoding=UTF8";
    		try{
        		// 之所以要用下面的的语句，是因为要使用MYSQL的驱动，所以我们要把它驱动起来
    	    	// 可以通过Class.forName把它加载进去，也可以通过初始化驱动器起来，下面三种形式都可以
    			Class.forName("com.mysql.jdbc.Driver");  
    			// or:
    			// com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
    			// or:
    			// new com.mysql.jdbc.Driver();
   
    		    System.out.println("成功加载MySQL驱动程序");
    	       
    		    // 一个Connection代表一个数据库连接
    	        Connection conn = DriverManager.getConnection(url);
    	       
    	        // String sql;
    	        // sql = "select ID,COMMAND,DESCRIPTION,CONTENT from message";
    	        // String 是不可变的对象, 因此在每次对 String 类型进行改变的时候其实都等同于生成了一个新的 String 对象，然后将指针指向新的 String 对象，所以经常改变内容的字符串最好不要用 String
    	        StringBuilder sql = new StringBuilder("select ID,COMMAND,DESCRIPTION,CONTENT from message where 1=1");
    	        // PreparedStatement里面带有很多方法，比如executeUpdate可以实现插入，更新和删除等
    	        
    	        List<String> paramList = new ArrayList<String>();
    	        if(command != null && !"".equals(command.trim())){
    	        	sql.append(" and COMMAND=?");
    	        	paramList.add(command);
    	        	System.out.println(sql);
    	        }
    	        if(description != null && !"".equals(description.trim())){
    	        	sql.append(" and DESCRIPTION LIKE '%' ? '%' ");
    	        	paramList.add(description);
    	        }
    	        
    	        PreparedStatement statement = conn.prepareStatement(sql.toString());
    	        // PreparedStatement statement = conn.prepareStatement(sql)
    	        // Statement statement = conn.createStatement()
    	        // 以上两句的区别？
    	        // 无论从代码的可读性和可维护性，还是从提高性能方面，或者说避免xss攻击方面，都应该使用prepareStatement
    	        
    	        for(int i = 0;i < paramList.size();i++){
    	        	statement.setString(i+1,paramList.get(i));
    	        }
    	        
    	        ResultSet rs = statement.executeQuery();// executeQuery会返回结果的集合，否则返回空值
    	        
    		    while(rs.next()){
    		    	Message message = new Message();
    		    	messageList.add(message);
    		    	message.setId(rs.getString("ID"));
    		    	message.setCommand(rs.getString("COMMAND"));
    		    	message.setDescription(rs.getString("DESCRIPTION"));
    		    	message.setContent(rs.getString("CONTENT"));
        	    }
    		} catch (ClassNotFoundException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		return messageList;
    	}*/
    }
