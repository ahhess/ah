package bwbv.rlt.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Detail implements Serializable {
  private String id;
  private String displayName;
  
  public Detail() {
    new Detail("0", "");
  }

  public Detail(String id, String displayName) {
    this.id = id;
    this.displayName = displayName;
  }
  
  public String getId() { return id; }
  public void setId(String id) { this.id = id; }
  public String getDisplayName() { return displayName; }
  public void setDisplayName(String displayName) { this.displayName = displayName; } 
}
