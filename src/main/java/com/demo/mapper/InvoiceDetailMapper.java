package com.demo.mapper;

import com.demo.entity.InvoiceDetail;

public interface InvoiceDetailMapper {
    int deleteByPrimaryKey(Integer invoiceId);

    int insert(InvoiceDetail record);

    int insertSelective(InvoiceDetail record);

    InvoiceDetail selectByPrimaryKey(Integer invoiceId);

    int updateByPrimaryKeySelective(InvoiceDetail record);

    int updateByPrimaryKey(InvoiceDetail record);
}