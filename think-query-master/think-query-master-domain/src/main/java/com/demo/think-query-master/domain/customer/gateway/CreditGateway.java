package com.demo.think-query-master.domain.customer.gateway;

import com.demo.think-query-master.domain.customer.Credit;

//Assume that the credit info is in another distributed Service
public interface CreditGateway {
    Credit getCredit(String customerId);
}
