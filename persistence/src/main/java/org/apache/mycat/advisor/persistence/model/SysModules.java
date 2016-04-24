package org.apache.mycat.advisor.persistence.model;

import javax.persistence.*;

/**
 * Created by cjl on 2016/3/20.
 */
@Table(name = "sys_modules")
public class SysModules {
    @Id
    @Column(name = "MODULE_ID", nullable = false, insertable = true, updatable = true)
    private Long moduleId;
    private String moduleName;
    private String moduleDesc;
    private String moduleType;
    private Long parent;
    private String tplUrl;
    private String dataUrl;
    private Integer leaf;
    private String application;
    private String controller;
    private Integer enable;
    private Integer priority;
    @Transient
    private String check;

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    @Basic
    @Column(name = "MODULE_NAME", nullable = false, insertable = true, updatable = true, length = 100)
    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    @Basic
    @Column(name = "MODULE_DESC", nullable = true, insertable = true, updatable = true, length = 200)
    public String getModuleDesc() {
        return moduleDesc;
    }

    public void setModuleDesc(String moduleDesc) {
        this.moduleDesc = moduleDesc;
    }

    @Basic
    @Column(name = "MODULE_TYPE", nullable = true, insertable = true, updatable = true, length = 100)
    public String getModuleType() {
        return moduleType;
    }

    public void setModuleType(String moduleType) {
        this.moduleType = moduleType;
    }

    @Basic
    @Column(name = "PARENT", nullable = true, insertable = true, updatable = true)
    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }



    @Basic
    @Column(name = "TPL_URL", nullable = true, insertable = true, updatable = true, length = 100)
    public String getTplUrl() {
        return tplUrl;
    }

    public void setTplUrl(String tplUrl) {
        this.tplUrl = tplUrl;
    }



    @Basic
    @Column(name = "data_url", nullable = true, insertable = true, updatable = true)
    public String getDataUrl() {
        return dataUrl;
    }

    public void setDataUrl(String dataUrl) {
        this.dataUrl = dataUrl;
    }

    @Basic
    @Column(name = "LEAF", nullable = true, insertable = true, updatable = true)
    public Integer getLeaf() {
        return leaf;
    }

    public void setLeaf(Integer leaf) {
        this.leaf = leaf;
    }

    @Basic
    @Column(name = "APPLICATION", nullable = true, insertable = true, updatable = true, length = 100)
    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    @Basic
    @Column(name = "CONTROLLER", nullable = true, insertable = true, updatable = true, length = 100)
    public String getController() {
        return controller;
    }

    public void setController(String controller) {
        this.controller = controller;
    }

    @Basic
    @Column(name = "ENABLE", nullable = true, insertable = true, updatable = true)
    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    @Basic
    @Column(name = "PRIORITY", nullable = true, insertable = true, updatable = true)
    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysModules that = (SysModules) o;

        if (moduleId != null ? !moduleId.equals(that.moduleId) : that.moduleId != null) return false;
        if (moduleName != null ? !moduleName.equals(that.moduleName) : that.moduleName != null) return false;
        if (moduleDesc != null ? !moduleDesc.equals(that.moduleDesc) : that.moduleDesc != null) return false;
        if (moduleType != null ? !moduleType.equals(that.moduleType) : that.moduleType != null) return false;
        if (parent != null ? !parent.equals(that.parent) : that.parent != null) return false;
        if (tplUrl != null ? !tplUrl.equals(that.tplUrl) : that.tplUrl != null) return false;
        if (dataUrl != null ? !dataUrl.equals(that.dataUrl) : that.dataUrl != null) return false;
        if (leaf != null ? !leaf.equals(that.leaf) : that.leaf != null) return false;
        if (application != null ? !application.equals(that.application) : that.application != null) return false;
        if (controller != null ? !controller.equals(that.controller) : that.controller != null) return false;
        if (enable != null ? !enable.equals(that.enable) : that.enable != null) return false;
        if (priority != null ? !priority.equals(that.priority) : that.priority != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = moduleId != null ? moduleId.hashCode() : 0;
        result = 31 * result + (moduleName != null ? moduleName.hashCode() : 0);
        result = 31 * result + (moduleDesc != null ? moduleDesc.hashCode() : 0);
        result = 31 * result + (moduleType != null ? moduleType.hashCode() : 0);
        result = 31 * result + (parent != null ? parent.hashCode() : 0);
        result = 31 * result + (tplUrl != null ? tplUrl.hashCode() : 0);
        result = 31 * result + (dataUrl != null ? dataUrl.hashCode() : 0);
        result = 31 * result + (leaf != null ? leaf.hashCode() : 0);
        result = 31 * result + (application != null ? application.hashCode() : 0);
        result = 31 * result + (controller != null ? controller.hashCode() : 0);
        result = 31 * result + (enable != null ? enable.hashCode() : 0);
        result = 31 * result + (priority != null ? priority.hashCode() : 0);
        return result;
    }
}
