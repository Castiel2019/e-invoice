package com.demo.service;


import com.demo.entity.InvoiceToken;

public interface InvoiceTokenService {

    int insert(InvoiceToken invoiceToken);

    InvoiceToken selectByPrimaryKey(Integer id);
    
    int updateByPrimaryKey(InvoiceToken invoiceToken);


}
