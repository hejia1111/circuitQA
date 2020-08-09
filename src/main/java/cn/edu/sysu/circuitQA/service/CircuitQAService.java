package cn.edu.sysu.circuitQA.service;

import cn.edu.sysu.circuitQA.dao.circuitQaMapper;
import cn.edu.sysu.circuitQA.model.circuitQa;
import cn.edu.sysu.circuitQA.model.circuitQaExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

public class CircuitQAService {
    @Autowired
    private circuitQaMapper circuitQaMapper;

    @Autowired
    public static List<circuitQa> questions;

    @Scheduled(cron="0 0 1 * * ?")
    public void importQuestions() {
        circuitQaExample circuitQaExample = new circuitQaExample();
        circuitQaExample.Criteria criteria = circuitQaExample.createCriteria();
        questions = circuitQaMapper.selectByExample(circuitQaExample);
    }

    public void updateQuestion(int id, String parentId, String childrenID) {
        circuitQa record = new circuitQa();
        record.setChildid(childrenID);
        record.setParentid(parentId);
        circuitQaExample circuitQaExample = new circuitQaExample();
        circuitQaExample.Criteria criteria = circuitQaExample.createCriteria();
        criteria.andQuestionidEqualTo(id);
        circuitQaMapper.updateByExampleSelective(record, circuitQaExample);
    }
}
