package com.hong.template2.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 清分表实体类
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrClearingEntity implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 自增主键
     */
    private Long serialNo;

    /**
     * 贷款编号
     */
    private String pactNo;

    /**
     * 还款流水号
     * 还款流水AcLnSetlmtLog表traceNo
     */
    private String repaymentTransNo;

    /**
     * 还款计划编号
     */
    private String returnPlanSerialNo;

    /**
     * 项目编号
     */
    private String projectNo;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 产品编码
     */
    private String prdtNo;

    /**
     * 客户编号
     */
    private String customerNo;

    /**
     * 客户名称
     */
    private String customerName;

    /**
     * 还款期次
     */
    private Integer termNo;

    /**
     * 清分状态，0:初始   1:清分中   2:清分结束   4:清分异常，5：作废
     * ClearStatus
     */
    private String status;

    /**
     * 清分金额
     */
    private BigDecimal amount;

    /**
     * 息费编号
     */
    private String feeItemGroupNo;

    /**
     * 记息开始时间
     */
    private LocalDate startTime;

    /**
     * 记息截止时间
     */
    private LocalDate endTime;

    /**
     * 审核状态，0:未审核   1：审核通过  2：审核拒绝
     */
    private String auditStatus;

    /**
     * 是否需要划款，Y：是   N:否
     */
    private String needTransfer;

    /**
     * 清分结果
     */
    private String result;

    /**
     * 审批批次号
     */
    private Long batchNo;

    /**
     * 流程实例ID
     */
    private String processInstanceId;

    /**
     * 审核结果
     */
    private String auditResult;

    /**
     * 审核意见
     */
    private String auditRemark;

    //创建时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    //修改时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    /**
     * 还款日期
     */
    private LocalDateTime repayDate;

    /**
     * 应还款日期
     */
    private LocalDate dueDate;

    /**
     * 清分日期
     */
    private LocalDateTime clearTime;

}
