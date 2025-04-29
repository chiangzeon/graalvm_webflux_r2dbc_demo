package com.example.demo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Table("multi_agent_service_log")
public class MultiAgentServiceLog {

    @Id
    private Long id;

    @Column("is_deleted")
    private String isDeleted;

    @Column("creator")
    private String creator;

    @Column("gmt_created")
    private Date gmtCreated;

    @Column("modifier")
    private String modifier;

    @Column("gmt_modified")
    private Date gmtModified;

    @Column("agent_code")
    private String agentCode;

    @Column("request_id")
    private String requestId;

    @Column("system_code")
    private String systemCode;

    @Column("exception_info")
    private String exceptionInfo;

    @Column("request_body")
    private String requestBody;

    @Column("response_body")
    private String responseBody;

    @Column("start_time")
    private Date startTime;

    @Column("end_time")
    private Date endTime;

    @Column("time_consuming")
    private BigDecimal timeConsuming;

    @Column("extra_info")
    private String extraInfo;
}
