package com.demo.mapper;

import com.demo.entity.Invoice;

public interface InvoiceMapper {
    int deleteByPrimaryKey(Integer invoiceId);

    int insert(Invoice record);

    int insertSelective(Invoice record);

    Invoice selectByPrimaryKey(Integer invoiceId);

    int updateByPrimaryKeySelective(Invoice record);

    int updateByPrimaryKey(Invoice record);
}