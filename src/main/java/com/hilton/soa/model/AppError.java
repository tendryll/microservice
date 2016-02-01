package com.hilton.soa.model;

import java.util.Objects;

public class AppError {
  private String msg;

  public AppError() {
  }

  public AppError(String msg) {
    this.msg = msg;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    final AppError appError = (AppError) obj;
    return Objects.equals(msg, appError.msg);
  }

  @Override
  public int hashCode() {
    return Objects.hash(msg);
  }
}
