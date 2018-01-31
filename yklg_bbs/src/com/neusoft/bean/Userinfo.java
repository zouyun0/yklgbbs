package com.neusoft.bean;
import java.util.*;
import com.tgb.lk.annotation.*;

@AutoBean(alias = "Userinfo",table="tab_bbs_userinfo")
public class Userinfo {

  @AutoField(alias = "���", column = "id", isKey = true , isRequired = true , type="Integer", length=0)
  @ExcelVOAttribute(name = "id", column = "A")
  private int id;

  @AutoField(alias = "email", column = "email", isRequired = true, length = 50)
  @ExcelVOAttribute(name = "email", column = "B")
  private String email;

  @AutoField(alias = "nickname", column = "nickname", isRequired = true, length = 30)
  @ExcelVOAttribute(name = "nickname", column = "C")
  private String nickname;

  @AutoField(alias = "city", column = "city", isRequired = true, length = 50)
  @ExcelVOAttribute(name = "city", column = "D")
  private String city;

  @AutoField(alias = "sex", column = "sex", isRequired = true, type = "Integer", combo = {"��","Ů"})
  @ExcelVOAttribute(name = "sex", column = "E")
  private int sex;

  @AutoField(alias = "headUrl", column = "head_url", isRequired = true, length = 100)
  @ExcelVOAttribute(name = "head_url", column = "F")
  private String headUrl;

  @AutoField(alias = "password", column = "password", isRequired = true, length = 64)
  @ExcelVOAttribute(name = "password", column = "G")
  private String password;

  @AutoField(alias = "signContent", column = "sign_content", isRequired = true, length = 500)
  @ExcelVOAttribute(name = "sign_content", column = "H")
  private String signContent;

  @AutoField(alias = "kissNum", column = "kiss_num", isRequired = true, type = "Integer")
  @ExcelVOAttribute(name = "kiss_num", column = "I")
  private int kissNum;


  public int getId() {
    return id;
  }
  public void setId(int id){
    this.id = id;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email){
    this.email = email;
  }
  public String getNickname() {
    return nickname;
  }
  public void setNickname(String nickname){
    this.nickname = nickname;
  }
  public String getCity() {
    return city;
  }
  public void setCity(String city){
    this.city = city;
  }
  public int getSex() {
    return sex;
  }
  public void setSex(int sex){
    this.sex = sex;
  }
  public String getHeadUrl() {
    return headUrl;
  }
  public void setHeadUrl(String headUrl){
    this.headUrl = headUrl;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password){
    this.password = password;
  }
  public String getSignContent() {
    return signContent;
  }
  public void setSignContent(String signContent){
    this.signContent = signContent;
  }
  public int getKissNum() {
    return kissNum;
  }
  public void setKissNum(int kissNum){
    this.kissNum = kissNum;
  }
}
