package com.example.service;

import com.example.dao.SearchCustomDao;
import com.example.dto.SearchCustomDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class SearchCustomService {

    @Autowired
    CacheService cacheService;

    @Autowired
    SearchCustomDao searchCustomDao;

    /**
     * 캐시로 테이블 접근 가능 여부 확인
     */
    public boolean checkAccessibleTableList(String requestURI, List<String> tableList) {
        for (String tableName : tableList) {
            boolean isAccessibleTableInUrl = cacheService.isAccessibleTableInUrl(requestURI,tableName);
            if(!isAccessibleTableInUrl) {
                    return false;
            };
        }
        return true;
    }

    /**
     * 캐시로 화면에서 커스텀 가능한 테이블,컬럼,검색조건 전송
     */
    public List<SearchCustomDto> getSearchCustomInfo(HttpServletRequest httpServletRequest) {
        String requestURI = httpServletRequest.getRequestURI();
        cacheService.searchCustomByUrl(requestURI);
        return null;
    }

}
