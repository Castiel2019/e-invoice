package com.demo.mapper;

import com.demo.entity.InvoiceToken;

public interface InvoiceTokenMapper {

    int insert(InvoiceToken invoiceToken);

    InvoiceToken selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(InvoiceToken invoiceToken);


}
