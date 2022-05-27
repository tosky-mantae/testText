package com.example.demo.service;

import com.example.demo.dto.Board;
import com.example.demo.model.dao.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TestService {
    @Autowired
    TestMapper testMapper;

    public List<Board> getAllDataList(Map<String, Integer> param){
        List<Board> result = testMapper.getAllDataList(param);
        return result;
    }

    public int setAllDataList(Map<String, String> param){
        int result = testMapper.setAllDataList(param);
        return result;
    }

    public Board getData(int CRUD_idx) {
        Board board = testMapper.getData(CRUD_idx);
        return board;
    }

    public int updateData(Map<String, String> param){
        int result =testMapper.updateData(param);
        return result;
    }

    public int delData(Map<String, String> param){
        int result = testMapper.delData(param);
        return result;
    }

    public int pageSlid(){
        int result = testMapper.pageSlid();
        return result;
    }


}
