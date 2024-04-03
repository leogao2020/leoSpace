package com.demo.thinkquery.domain.customer.gateway;

import com.demo.thinkquery.domain.customer.Credit;

//Assume that the credit info is in another distributed Service
public interface CreditGateway {
    Credit getCredit(String customerId);
}
