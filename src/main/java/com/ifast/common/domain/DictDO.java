package com.ifast.common.domain;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <pre>
 * </pre>
 * <small> 2018年3月23日 | Aron</small>
 */
@TableName("sys_dict")
@Data
public class DictDO extends Model<DictDO> implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @TableField(exist = false)
    public final static DictDO dao = new DictDO();
    
    // 编号
    @TableId
    private Long id;
    // 标签名
    @NotBlank(message = "标签名称不允许为空")
    @Length(max=10, message="请输入小于10个字符")
    private String name;
    // 数据值
    @NotBlank(message = "数据值不允许为空")
    private String value;
    // 类型
    @NotBlank(message = "类型不允许为空")
    private String type;
    // 描述
    @NotBlank(message = "描述不允许为空")
    @Length(max=200, message="请输入小于200个字符")
    private String description;
    // 排序（升序）
    private BigDecimal sort;
    // 父级编号
    private Long parentId;
    // 创建者
    private Integer createBy;
    // 创建时间
    private Date createDate;
    // 更新者
    private Long updateBy;
    // 更新时间
    private Date updateDate;
    // 备注信息
    private String remarks;
    // 删除标记
    private String delFlag;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getSort() {
        return sort;
    }

    public void setSort(BigDecimal sort) {
        this.sort = sort;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}
