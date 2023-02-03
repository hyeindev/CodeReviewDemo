package com.example.service;

import com.example.dao.SearchCustomDao;
import com.example.dto.SearchCustomDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.List;

@EnableCaching
@Service
public class CacheService {

    @Autowired
    SearchCustomDao searchCustomDao;

    /**
     * 사용자 검색 사용 시 해당 화면에서 접근 가능한 테이블인지에 대한 사용 여부 반환
     */
    @Cacheable(cacheNames = "searchCustom", key="#url.toString().concat(#tableName)")
    public boolean isAccessibleTableInUrl(String url,String tableName) {
        int rowCount = searchCustomDao.countByUrlAndTableName(url+tableName);
        if (rowCount>0) {
            return true;
        }
        return false;
    }

    @Cacheable(cacheNames = "searchCustom", key="#requestURI")
    public Object searchCustomByUrl(String requestURI) {
        List<SearchCustomDto> searchCustomDtoList = searchCustomDao.selectSearchCustomUsable(requestURI);
        for (int i = 0; i < searchCustomDtoList.size(); i++) {
            System.out.println(searchCustomDtoList.get(i).toString());
        }
        return null; /** 여기서 클라이언트 커스텀 가능한 구조로 변환해서 전송 */
    }
}
