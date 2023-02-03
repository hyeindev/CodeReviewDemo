package com.example.dto;

import lombok.Data;

@Data
public class SearchCustomDto {

    private int URL_MAPP_TABLE_UID;
    private String URL;
    private String URL_PAGE_NM;
    private String TABLE_NM;
    private String COLUMN_NM;
    private String COLUMN_ALIAS;
    private String IS_USE_FILTER;
    private String IS_USE_COLUMN_VIEW;

}
