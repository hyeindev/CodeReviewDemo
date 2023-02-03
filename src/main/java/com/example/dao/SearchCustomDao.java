package com.example.dao;

import com.example.dto.SearchCustomDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SearchCustomDao {
    int countByUrlAndTableName(String urlAndTableName);

    List<SearchCustomDto> selectSearchCustomUsable(String requestURI);
}
