package com.demo.thinkquery.api;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.demo.thinkquery.dto.CustomerAddCmd;
import com.demo.thinkquery.dto.CustomerListByNameQry;
import com.demo.thinkquery.dto.data.CustomerDTO;

public interface CustomerServiceI {

    Response addCustomer(CustomerAddCmd customerAddCmd);

    MultiResponse<CustomerDTO> listByName(CustomerListByNameQry customerListByNameQry);
}
