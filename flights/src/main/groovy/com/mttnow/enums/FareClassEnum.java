package com.mttnow.enums;

public enum FareClassEnum {

  FIRST("FIF"), BUSINESS("CIF"), ECONOMY("YIF");

  private String code;

  private FareClassEnum(final String code) {
    this.code = code;
  }

  public String code() {
    return code;
  }
}
