package io.pestakit.surveys.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Question
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-11-10T10:14:34.627+01:00")

public class Question   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("title")
  private String title = null;

  @JsonProperty("used")
  private Integer used = null;

  @JsonProperty("enabled")
  private Integer enabled = null;

  @JsonProperty("choices")
  private String choices = null;

  public Question id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Question title(String title) {
    this.title = title;
    return this;
  }

   /**
   * Get title
   * @return title
  **/
  @ApiModelProperty(value = "")


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Question used(Integer used) {
    this.used = used;
    return this;
  }

   /**
   * Get used
   * @return used
  **/
  @ApiModelProperty(value = "")


  public Integer getUsed() {
    return used;
  }

  public void setUsed(Integer used) {
    this.used = used;
  }

  public Question enabled(Integer enabled) {
    this.enabled = enabled;
    return this;
  }

   /**
   * Get enabled
   * @return enabled
  **/
  @ApiModelProperty(value = "")


  public Integer getEnabled() {
    return enabled;
  }

  public void setEnabled(Integer enabled) {
    this.enabled = enabled;
  }

  public Question choices(String choices) {
    this.choices = choices;
    return this;
  }

   /**
   * Get choices
   * @return choices
  **/
  @ApiModelProperty(value = "")


  public String getChoices() {
    return choices;
  }

  public void setChoices(String choices) {
    this.choices = choices;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Question question = (Question) o;
    return Objects.equals(this.id, question.id) &&
        Objects.equals(this.title, question.title) &&
        Objects.equals(this.used, question.used) &&
        Objects.equals(this.enabled, question.enabled) &&
        Objects.equals(this.choices, question.choices);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, used, enabled, choices);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Question {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    used: ").append(toIndentedString(used)).append("\n");
    sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
    sb.append("    choices: ").append(toIndentedString(choices)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

