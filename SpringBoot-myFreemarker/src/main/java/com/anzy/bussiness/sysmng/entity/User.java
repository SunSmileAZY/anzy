package com.anzy.bussiness.sysmng.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.anzy.bussiness.comm.AbstractBaseEntity;

public class User extends AbstractBaseEntity{

	private static final long serialVersionUID = 1L;

	private BigDecimal userId;

	private String username;

	private String gender;

	private Short age;

	private String loginAccount;

	private String loginPwd;

	private String idNo;

	private String mobilePhone;

	private String email;

	private String weixin;

	private String curState;

	private BigDecimal loginAmount;

	private BigDecimal deptId;

	private String userNo;

	private String address;

	private String remark;

	private String createBy;

	private Date createDt;

	private Date updateDt;

	private String updateBy;

	private String deleteBy;

	private String actByType;

	private String ccNo;

	private String authType;

    private List<String> roleList;
    
    private String skin;
    
    private String  dingtaskId;

	public BigDecimal getUserId() {
		return userId;
	}

	public void setUserId(BigDecimal userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender == null ? null : gender.trim();
	}

	public Short getAge() {
		return age;
	}

	public void setAge(Short age) {
		this.age = age;
	}

	public String getLoginAccount() {
		return loginAccount;
	}

	public void setLoginAccount(String loginAccount) {
		this.loginAccount = loginAccount == null ? null : loginAccount.trim();
	}

	public String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd == null ? null : loginPwd.trim();
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo == null ? null : idNo.trim();
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public String getCurState() {
		return curState;
	}

	public void setCurState(String curState) {
		this.curState = curState == null ? null : curState.trim();
	}

	public BigDecimal getLoginAmount() {
		return loginAmount;
	}

	public void setLoginAmount(BigDecimal loginAmount) {
		this.loginAmount = loginAmount;
	}

	public BigDecimal getDeptId() {
		return deptId;
	}

	public void setDeptId(BigDecimal deptId) {
		this.deptId = deptId;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo == null ? null : userNo.trim();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy == null ? null : createBy.trim();
	}

	public Date getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	public Date getUpdateDt() {
		return updateDt;
	}

	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy == null ? null : updateBy.trim();
	}

	public String getDeleteBy() {
		return deleteBy;
	}

	public void setDeleteBy(String deleteBy) {
		this.deleteBy = deleteBy == null ? null : deleteBy.trim();
	}

	public String getActByType() {
		return actByType;
	}

	public void setActByType(String actByType) {
		this.actByType = actByType == null ? null : actByType.trim();
	}

	public String getWeixin() {
		return weixin;
	}

	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}

	public String getCcNo() {
		return ccNo;
	}

	public void setCcNo(String ccNo) {
		this.ccNo = ccNo;
	}

	public String getAuthType() {
		return authType;
	}

	public void setAuthType(String authType) {
		this.authType = authType;
	}

	public List<String> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<String> roleList) {
		this.roleList = roleList;
	}

	public String getSkin() {
		return skin;
	}

	public void setSkin(String skin) {
		this.skin = skin;
	}

    public String getDingtaskId() {
        return dingtaskId;
    }

    public void setDingtaskId(String dingtaskId) {
        this.dingtaskId = dingtaskId;
    }
	


}
