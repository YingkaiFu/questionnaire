package com.questionnaire.demo.dao;

import com.questionnaire.demo.entity.QuestionEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface QuestionDao {

    List<QuestionEntity> getData();
}