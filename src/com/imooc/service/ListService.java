package com.imooc.service;

import java.util.List;

import com.imooc.bean.Message;
import com.imooc.dao.MessageDao;

/*
 * �б���ص�ҵ����
 * ��dao�������Ľ�����ظ�servlet
 */
public class ListService {
	public List<Message> queryMessageList(String command,String description) {
		MessageDao messageDao = new MessageDao();
		return messageDao.queryMessageList(command,description);
	}
}
