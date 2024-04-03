package com.alibaba.craftsman.web;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.craftsman.api.MetricsServiceI;
import com.alibaba.craftsman.dto.ATAMetricAddCmd;
import com.alibaba.craftsman.dto.ATAMetricQry;
import com.alibaba.craftsman.dto.clientobject.ATAMetricCO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController //定义为RESTful控制器
public class MetricsController {

    @Autowired //自动注入MetricsServiceI接口的实现
    private MetricsServiceI metricsService;

    /**
     * 查询ATA指标列表
     * @param ownerId 所有者ID，用于过滤指标数据
     * @return 返回一个包含多个ATA指标的响应对象
     */
    @GetMapping(value = "/metrics/ata")
    public MultiResponse<ATAMetricCO> listATAMetrics(@RequestParam String ownerId){
        ATAMetricQry ataMetricQry = new ATAMetricQry(); //构建查询请求对象
        ataMetricQry.setOwnerId(ownerId); //设置查询条件
        return metricsService.listATAMetrics(ataMetricQry); //调用服务层方法，返回指标列表
    }

    /**
     * 添加ATA指标
     * @param ataMetricAddCmd 添加ATA指标的命令对象，包含指标的详细信息
     * @return 返回一个表示操作结果的响应对象
     */
    @PostMapping(value = "/metrics/ata")
    public Response addATAMetric(@RequestBody ATAMetricAddCmd ataMetricAddCmd){
        return metricsService.addATAMetric(ataMetricAddCmd); //调用服务层方法，添加指标
    }
}
