package com.demo.thinkquery.domain.customer.gateway;

import com.demo.thinkquery.domain.customer.Customer;

public interface CustomerGateway {
    Customer getByById(String customerId);
}
