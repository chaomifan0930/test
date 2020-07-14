package com.sc.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class BgTaskTarget implements Serializable {
    private Long targetId;

    private String taskTarget;

    private String targetRemark;

    private Long companyId;

    @DateTimeFormat(pattern="yyyy-mm-dd hh:mm:ss")
    private Date lastModifyDate;

    private static final long serialVersionUID = 1L;

    public BgTaskTarget(Long targetId, String taskTarget, String targetRemark, Long companyId, Date lastModifyDate) {
        this.targetId = targetId;
        this.taskTarget = taskTarget;
        this.targetRemark = targetRemark;
        this.companyId = companyId;
        this.lastModifyDate = lastModifyDate;
    }

    public BgTaskTarget() {
        super();
    }

    public Long getTargetId() {
        return targetId;
    }

    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }

    public String getTaskTarget() {
        return taskTarget;
    }

    public void setTaskTarget(String taskTarget) {
        this.taskTarget = taskTarget == null ? null : taskTarget.trim();
    }

    public String getTargetRemark() {
        return targetRemark;
    }

    public void setTargetRemark(String targetRemark) {
        this.targetRemark = targetRemark == null ? null : targetRemark.trim();
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Date getLastModifyDate() {
        return lastModifyDate;
    }

    public void setLastModifyDate(Date lastModifyDate) {
        this.lastModifyDate = lastModifyDate;
    }

	@Override
	public String toString() {
		return "BgTaskTarget [targetId=" + targetId + ", taskTarget=" + taskTarget + ", targetRemark=" + targetRemark
				+ ", companyId=" + companyId + ", lastModifyDate=" + lastModifyDate + "]";
	}
    
}