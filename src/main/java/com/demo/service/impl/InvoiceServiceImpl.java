package com.demo.service.impl;


import com.demo.entity.Invoice;
import com.demo.mapper.InvoiceMapper;
import com.demo.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceMapper invoiceMapper;


    @Override
    public int insert(Invoice invoice) {
        return invoiceMapper.insert(invoice);
    }

    @Override
    public Invoice selectByPrimaryKey(Integer id) {
        Invoice invoice = invoiceMapper.selectByPrimaryKey(id);
        return invoice;
    }

    @Override
    public int updateByPrimaryKey(Invoice invoice) {
        return invoiceMapper.updateByPrimaryKey(invoice);
    }
}
