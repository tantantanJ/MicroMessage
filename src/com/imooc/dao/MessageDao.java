/**
 * 
 */
/**
 * ��message����ص����ݿ����
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
    	 * ���ݲ�ѯ������ѯ��Ϣ�б�
    	 */
    	
        //��Mybatis��ʽ����
    	public List<Message> queryMessageList(String command,String description) {
    		DBAccess dbAccess = new DBAccess();
    		List<Message> messageList = new ArrayList<Message>();
    		SqlSession sqlSession = null;
    		try {
    			sqlSession = dbAccess.getSqlSession();
    			//ͨ��sqlSessionִ��SQL���
    			messageList = sqlSession.selectList("Message.queryMessageList");
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			} finally {
				if(sqlSession != null){
					sqlSession.close();
				}
			}
    		return messageList;
    	}
    	
    	
       //��jdbc��ʽ����
/*    	public List<Message> queryMessageList(String command,String description) {
    		List<Message> messageList = new ArrayList<Message>();
    	    // MySQL��JDBC URL��д��ʽ��jdbc:mysql://�������ƣ����Ӷ˿�/���ݿ������?����=ֵ
            // ������������Ҫָ��useUnicode��characterEncoding
            // ִ�����ݿ����֮ǰҪ�����ݿ����ϵͳ�ϴ���һ�����ݿ⣬�����Լ�����
    		String url ="jdbc:mysql://localhost:3306/wechatchating?"+"user=root&password=090722ms&useUnicode=true&characterEncoding=UTF8";
    		try{
        		// ֮����Ҫ������ĵ���䣬����ΪҪʹ��MYSQL����������������Ҫ������������
    	    	// ����ͨ��Class.forName�������ؽ�ȥ��Ҳ����ͨ����ʼ������������������������ʽ������
    			Class.forName("com.mysql.jdbc.Driver");  
    			// or:
    			// com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
    			// or:
    			// new com.mysql.jdbc.Driver();
   
    		    System.out.println("�ɹ�����MySQL��������");
    	       
    		    // һ��Connection����һ�����ݿ�����
    	        Connection conn = DriverManager.getConnection(url);
    	       
    	        // String sql;
    	        // sql = "select ID,COMMAND,DESCRIPTION,CONTENT from message";
    	        // String �ǲ��ɱ�Ķ���, �����ÿ�ζ� String ���ͽ��иı��ʱ����ʵ����ͬ��������һ���µ� String ����Ȼ��ָ��ָ���µ� String �������Ծ����ı����ݵ��ַ�����ò�Ҫ�� String
    	        StringBuilder sql = new StringBuilder("select ID,COMMAND,DESCRIPTION,CONTENT from message where 1=1");
    	        // PreparedStatement������кܶ෽��������executeUpdate����ʵ�ֲ��룬���º�ɾ����
    	        
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
    	        // �������������
    	        // ���۴Ӵ���Ŀɶ��ԺͿ�ά���ԣ����Ǵ�������ܷ��棬����˵����xss�������棬��Ӧ��ʹ��prepareStatement
    	        
    	        for(int i = 0;i < paramList.size();i++){
    	        	statement.setString(i+1,paramList.get(i));
    	        }
    	        
    	        ResultSet rs = statement.executeQuery();// executeQuery�᷵�ؽ���ļ��ϣ����򷵻ؿ�ֵ
    	        
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
