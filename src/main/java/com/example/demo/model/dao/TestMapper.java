package com.example.demo.model.dao;


import com.example.demo.Criteria;
import com.example.demo.dto.Board;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface TestMapper {
    public List<Board> getAllDataList(Map<String,Integer> param);

    public int setAllDataList(Map<String, String> param);

    public Board getData(int CRUD_idx);

    public int updateData(Map<String,String> param);

    public int delData(Map<String, String> param);

    public int pageSlid();

//    public List<Map<String, Object>> boardList(Criteria cri);
//
//    public int boardListCnt();

}
