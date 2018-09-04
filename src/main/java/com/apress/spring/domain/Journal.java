package com.apress.spring.domain;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "Journals")
@Data
public class Journal {

  @Id
  private String id;
  private String title;
  private Date created;
  private String summary;

  @Transient
  private SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

  public Journal() {
  }
  
  public Journal(String title, String summary, String created) throws ParseException {
    this.title = title;
    this.summary = summary;
    this.created = format.parse(created);
  }

  public Journal(String title, String summary, Date created) {
    this.title = title;
    this.summary = summary;
    this.created = created;
  }

  @Override
  public String toString() {
    StringBuilder value = new StringBuilder("* JournalEntry(");
    value.append("Id: ");
    value.append(id);
    value.append(",Title: ");
    value.append(title);
    value.append(",Summary: ");
    value.append(summary);
    value.append(",Created: ");
    value.append(getCreatedAsShort());
    value.append(")");
    return value.toString();                                                                      
  }

  private String getCreatedAsShort(){
    return format.format(created);
  }
}