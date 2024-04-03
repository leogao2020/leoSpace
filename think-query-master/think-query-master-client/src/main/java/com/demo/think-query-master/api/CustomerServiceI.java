package com.demo.think-query-master.api;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.demo.think-query-master.dto.CustomerAddCmd;
import com.demo.think-query-master.dto.CustomerListByNameQry;
import com.demo.think-query-master.dto.data.CustomerDTO;

public interface CustomerServiceI {

    Response addCustomer(CustomerAddCmd customerAddCmd);

    MultiResponse<CustomerDTO> listByName(CustomerListByNameQry customerListByNameQry);
}
