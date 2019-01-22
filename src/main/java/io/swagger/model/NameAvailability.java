package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Gets or Sets NameAvailability
 */
public enum NameAvailability {
  
  LAB_TAKEN("lab_taken"),
  
  MINENAME_TAKEN("minename_taken"),
  
  BOTH_TAKEN("both_taken"),
  
  FREE("free");

  private String value;

  NameAvailability(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static NameAvailability fromValue(String text) {
    for (NameAvailability b : NameAvailability.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}

