package filemanage.digitalarchives.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import filemanage.digitalarchives.dao.AdviceMapper;
import filemanage.digitalarchives.pojo.Advice;
import filemanage.digitalarchives.pojo.Reply;
import filemanage.digitalarchives.service.AdviceService;
@Transactional
@Service("AdviceService")
public class AdviceServiceImpl implements AdviceService{

	@Autowired
	private AdviceMapper advicemapper;
	@Override
	public List<Advice> adviceQuery(Advice advice) {
		// TODO Auto-generated method stub
		return advicemapper.adviceQuery(advice);
	}

	@Override
	public int adviceCount(Advice advice) {
		// TODO Auto-generated method stub
		return advicemapper.adviceCount(advice);
	}

	@Override
	public Advice adviceSelect(Advice advice) {
		// TODO Auto-generated method stub
		return advicemapper.adviceSelect(advice);
	}

	@Override
	public int insertAdvice(Advice advice) {
		// TODO Auto-generated method stub
		return advicemapper.insertAdvice(advice);
	}

	@Override
	public int insertReply(Reply reply) {
		// TODO Auto-generated method stub
		return advicemapper.insertReply(reply);
	}

	@Override
	public int updateAdvice(Advice advice) {
		// TODO Auto-generated method stub
		return advicemapper.updateAdvice(advice);
	}

}
