package com.demo.think-query-master.domain.customer.gateway;

import com.demo.think-query-master.domain.customer.Customer;

public interface CustomerGateway {
    Customer getByById(String customerId);
}
