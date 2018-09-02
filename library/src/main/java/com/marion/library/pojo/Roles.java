package com.marion.library.pojo;


import java.util.Date;

public class Roles {

  private long id;
  private String name;
  private Date createdTime;
  private Date modifiedTime;


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

  public Date getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
  }

  public Date getModifiedTime() {
    return modifiedTime;
  }

  public void setModifiedTime(Date modifiedTime) {
    this.modifiedTime = modifiedTime;
  }

  @Override
  public String toString() {
    return "Roles{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", createdTime=" + createdTime +
            ", modifiedTime=" + modifiedTime +
            '}';
  }
}
