package com.hcj.abstractrouting.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 用户表(TfCUser)实体类
 *
 * @author makejava
 * @since 2021-08-10 00:50:41
 */
public class TfCUser implements Serializable {
    private static final long serialVersionUID = -62071593184831665L;
    /**
     * 编号
     */
    private Long id;
    /**
     * 用户名
     */
    private String name;
    /**
     * 密码
     */
    private String pwd;
    /**
     * 别名
     */
    private String alias;
    /**
     * 身份证号码
     */
    private String certificateNum;
    /**
     * 是否有效:0,无效,1,效果
     */
    private String status;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getCertificateNum() {
        return certificateNum;
    }

    public void setCertificateNum(String certificateNum) {
        this.certificateNum = certificateNum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
