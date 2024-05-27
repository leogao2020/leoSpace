package com.alibaba.craftsman.api;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.craftsman.dto.*;
import com.alibaba.craftsman.dto.clientobject.ATAMetricCO;

/**
 * MetricsServiceI 接口定义了与度量指标相关的服务操作。
 * 该接口提供了添加和删除不同类型度量指标的方法，以及查询特定类型度量指标的功能。
 */
public interface MetricsServiceI {
    /**
     * 添加ATAMetric（ ATA度量指标 ）。
     * @param cmd 包含要添加的ATA度量指标数据的命令对象。
     * @return 添加操作的响应结果。
     */
    Response addATAMetric(ATAMetricAddCmd cmd);

    /**
     * 添加SharingMetric（共享度量指标）。
     * @param cmd 包含要添加的共享度量指标数据的命令对象。
     * @return 添加操作的响应结果。
     */
    Response addSharingMetric(SharingMetricAddCmd cmd);

    /**
     * 添加PatentMetric（专利度量指标）。
     * @param cmd 包含要添加的专利度量指标数据的命令对象。
     * @return 添加操作的响应结果。
     */
    Response addPatentMetric(PatentMetricAddCmd cmd);

    /**
     * 添加PaperMetric（论文度量指标）。
     * @param cmd 包含要添加的论文度量指标数据的命令对象。
     * @return 添加操作的响应结果。
     */
    Response addPaperMetric(PaperMetricAddCmd cmd);

    /**
     * 添加RefactoringMetric（重构度量指标）。
     * @param cmd 包含要添加的重构度量指标数据的命令对象。
     * @return 添加操作的响应结果。
     */
    Response addRefactoringMetric(RefactoringMetricAddCmd cmd);

    /**
     * 添加MiscMetric（其他杂项度量指标）。
     * @param cmd 包含要添加的其他杂项度量指标数据的命令对象。
     * @return 添加操作的响应结果。
     */
    Response addMiscMetric(MiscMetricAddCmd cmd);

    /**
     * 添加CodeReviewMetric（代码审查度量指标）。
     * @param cmd 包含要添加的代码审查度量指标数据的命令对象。
     * @return 添加操作的响应结果。
     */
    Response addCodeReviewMetric(CodeReviewMetricAddCmd cmd);

    /**
     * 删除度量指标。
     * @param cmd 包含要删除的度量指标标识的命令对象。
     * @return 删除操作的响应结果。
     */
    Response deleteMetric(MetricDeleteCmd cmd);

    /**
     * 查询ATAMetrics（ATA度量指标列表）。
     * @param ataMetricQry 包含查询ATA度量指标所需的条件的查询对象。
     * @return 包含多个ATA度量指标结果的响应对象。
     */
    MultiResponse<ATAMetricCO> listATAMetrics(ATAMetricQry ataMetricQry);
}

