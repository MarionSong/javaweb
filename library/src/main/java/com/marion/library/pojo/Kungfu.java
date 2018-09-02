package com.marion.library.pojo;


import java.util.Date;

public class Kungfu {

  private long id;
  private String name;
  private long parentId;
  private String description;
  private String note;
  private Date createTime;
  private Date updateTime;

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

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public long getParentId() {
    return parentId;
  }

  public void setParentId(long parentId) {
    this.parentId = parentId;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }


  @Override
  public String toString() {
    return "Kungfu{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", parentId=" + parentId +
            ", description='" + description + '\'' +
            ", note='" + note + '\'' +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            '}';
  }
}
