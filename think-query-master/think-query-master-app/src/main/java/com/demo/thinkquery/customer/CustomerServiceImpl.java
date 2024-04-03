package com.demo.thinkquery.customer;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.catchlog.CatchAndLog;
import com.demo.thinkquery.api.CustomerServiceI;
import com.demo.thinkquery.dto.CustomerAddCmd;
import com.demo.thinkquery.dto.CustomerListByNameQry;
import com.demo.thinkquery.dto.data.CustomerDTO;
import org.springframework.stereotype.Service;

import com.demo.thinkquery.customer.executor.CustomerAddCmdExe;
import com.demo.thinkquery.customer.executor.query.CustomerListByNameQryExe;

import javax.annotation.Resource;


@Service
@CatchAndLog
public class CustomerServiceImpl implements CustomerServiceI {

    @Resource
    private CustomerAddCmdExe customerAddCmdExe;

    @Resource
    private CustomerListByNameQryExe customerListByNameQryExe;

    public Response addCustomer(CustomerAddCmd customerAddCmd) {
        return customerAddCmdExe.execute(customerAddCmd);
    }

    @Override
    public MultiResponse<CustomerDTO> listByName(CustomerListByNameQry customerListByNameQry) {
        return customerListByNameQryExe.execute(customerListByNameQry);
    }

}