package com.demo.service;


import com.demo.entity.Invoice;

import java.util.List;
import java.util.Map;

public interface InvoiceService {

    int insert(Invoice invoice);

    Invoice selectByPrimaryKey(Integer id);
    
    int updateByPrimaryKey(Invoice invoice);

    Map<String, Object> getAllInvoiceInfoByFlowNo(String flowNo);


}
