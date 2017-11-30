package com.anzy.bussiness.comm;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;

import org.apache.commons.beanutils.PropertyUtils;


public abstract class AbstractBaseEntity implements Serializable {

//    @TableField(exist = false)
//    private static final long serialVersionUID = 1L;
//
//    @TableField("createBy")
//    private String createBy;
//
//    @TableField("createDt")
//    private Date createDt;
//
//    @TableField("updateBy")
//    private String updateBy;
//
//    @TableField("updateDt")
//    private Date updateDt;
//
//    @TableField("deleteBy")
//    private String deleteBy;
//
//    @TableField("actByType")
//    private String actByType = "B";
//
//    @TableField(exist = false)
//    private Integer version = 0;
//
//    @TableField(exist = false)
//    private String lastSortFieldName;
//
//    @TableField(exist = false)
//    private String sortByAD;
//
//    /**
//     * 返回lastSortFieldName
//     * 
//     * @return lastSortFieldName
//     */
//    public String getLastSortFieldName() {
//        return lastSortFieldName;
//    }
//
//    /**
//     * 设定lastSortFieldName
//     * 
//     * @param lastSortFieldName
//     */
//    public void setLastSortFieldName(String lastSortFieldName) {
//        this.lastSortFieldName = lastSortFieldName;
//    }
//
//    /**
//     * 返回sortByAD
//     * 
//     * @return sortByAD
//     */
//    public String getSortByAD() {
//        return sortByAD;
//    }
//
//    /**
//     * 设定sortByAD
//     * 
//     * @param sortByAD
//     */
//    public void setSortByAD(String sortByAD) {
//        this.sortByAD = sortByAD;
//    }
//
//    public Integer getVersion() {
//        return version;
//    }
//
//    public void setVersion(Integer version) {
//        this.version = version;
//    }
//
//    public String getCreateBy() {
//        return createBy;
//    }
//
//    public void setCreateBy(String createBy) {
//        this.createBy = createBy == null ? null : createBy.trim();
//    }
//
//    public Date getCreateDt() {
//        return createDt;
//    }
//
//    public void setCreateDt(Date createDt) {
//        this.createDt = createDt;
//    }
//
//    public Date getUpdateDt() {
//        return updateDt;
//    }
//
//    public void setUpdateDt(Date updateDt) {
//        this.updateDt = updateDt;
//    }
//
//    public String getUpdateBy() {
//        return updateBy;
//    }
//
//    public void setUpdateBy(String updateBy) {
//        this.updateBy = updateBy == null ? null : updateBy.trim();
//    }
//
//    public String getDeleteBy() {
//        return deleteBy;
//    }
//
//    public void setDeleteBy(String deleteBy) {
//        this.deleteBy = deleteBy == null ? null : deleteBy.trim();
//    }
//
//    public String getActByType() {
//        return actByType;
//    }
//
//    public void setActByType(String actByType) {
//        this.actByType = actByType == null ? null : actByType.trim();
//    }
//
//    /**
//     * Returns a multi-line String with key=value pairs.
//     * 
//     * @return a String representation of this class.
//     */
//    public String toString() {
//        StringBuffer sb = new StringBuffer();
//        sb.append("\n");
//        sb.append("\t" + this.getClass().getName() + " {\n");
//        Class<?> cls = this.getClass();
//        Field[] fields = cls.getDeclaredFields();
//        for (int i = 0; i < fields.length; i++) {
//            String propertyName = fields[i].getName();
//            if (PropertyUtils.isReadable(this, propertyName)) {
//                try {
//                    Object obj = PropertyUtils.getProperty(this, propertyName);
//                    sb.append("\t\t" + propertyName);
//                    sb.append("=[");
//                    if (obj != null) {
//                        sb.append(obj.toString());
//                    }
//                    sb.append("]\n");
//                }
//                catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        sb.append("\t}");
//        return sb.toString();
//    }
//
//    /**
//     * Compares object equality. When using Hibernate, the primary key should
//     * not be a part of this comparison.
//     * 
//     * @param o
//     *            object to compare to
//     * @return true/false based on equality tests
//     */
//    public boolean equals(Object o) {
//        return super.equals(o);
//    }
//
//    /**
//     * When you override equals, you should override hashCode. See "Why are
//     * equals() and hashCode() importation" for more information:
//     * http://www.hibernate.org/109.html
//     * 
//     * @return hashCode
//     */
//    public int hashCode() {
//        return super.hashCode();
//    }

}
