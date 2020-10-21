package com.demo.service.impl;


import com.demo.entity.InvoiceToken;
import com.demo.mapper.InvoiceTokenMapper;
import com.demo.service.InvoiceTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InvoiceTokenServiceImpl implements InvoiceTokenService {

    @Autowired
    private InvoiceTokenMapper invoiceTokenMapper;


    @Override
    public int insert(InvoiceToken invoiceToken) {
        return invoiceTokenMapper.insert(invoiceToken);
    }

    @Override
    public InvoiceToken selectByPrimaryKey(Integer id) {
        InvoiceToken invoiceToken = invoiceTokenMapper.selectByPrimaryKey(id);
        return invoiceToken;
    }

    @Override
    public int updateByPrimaryKey(InvoiceToken invoiceToken) {
        return invoiceTokenMapper.updateByPrimaryKey(invoiceToken);
    }
}
