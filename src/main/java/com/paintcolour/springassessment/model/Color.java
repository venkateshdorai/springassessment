package com.paintcolour.springassessment.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
public class Color {
	
	@Id
	@Column(length = 32, nullable = false)
	private String name;
	@Column(length = 3, scale = 0, precision = 3)
	private Integer red;
	@Column(length = 3, scale = 0, precision = 3)
	private Integer green;
	@Column(length = 3, scale = 0, precision = 3)
	private Integer blue;
	
	/**
	   * Default constructor
	   * @deprecated Use {@link Color#Color(String, Integer, Integer, Integer)}
	   */
	  @Deprecated
	  public Color() {
	    super();
	  }

	  /**
	   * Constructor with only required parameters
	   */
	  public Color(String name, Integer r, Integer g, Integer b) {
	    this.name = name;
	    this.red = r;
	    this.green = g;
	    this.blue = b;
	  }

	  public Color name(String name) {
	    this.name = name;
	    return this;
	  }

	  /**
	   * Name of the color
	   * @return name
	  */
	  @NotNull 
	  @Size(max = 32) 
	  @JsonProperty("name")
	  public String getName() {
	    return name;
	  }

	  public void setName(String name) {
	    this.name = name;
	  }

	  public Color red(Integer r) {
	    this.red = r;
	    return this;
	  }

	  /**
	   * red component of color
	   * minimum: 0
	   * maximum: 255
	   * @return r
	  */
	  @NotNull @Min(0) @Max(255) 
	  @JsonProperty("r")
	  public Integer getRed() {
	    return red;
	  }

	  public void setRed(Integer r) {
	    this.red = r;
	  }

	  public Color green(Integer g) {
	    this.green = g;
	    return this;
	  }

	  /**
	   * green component of color
	   * minimum: 0
	   * maximum: 255
	   * @return g
	  */
	  @NotNull @Min(0) @Max(255) 
	  @JsonProperty("g")
	  public Integer getGreen() {
	    return green;
	  }

	  public void setGreen(Integer g) {
	    this.green = g;
	  }

	  public Color blue(Integer b) {
	    this.blue = b;
	    return this;
	  }

	  /**
	   * blue component of color
	   * minimum: 0
	   * maximum: 255
	   * @return b
	  */
	  @NotNull 
	  @Min(0) 
	  @Max(255) 
	  @JsonProperty("b")
	  public Integer getBlue() {
	    return blue;
	  }

	  public void setBlue(Integer b) {
	    this.blue = b;
	  }

	  @Override
	  public boolean equals(Object o) {
	    if (this == o) {
	      return true;
	    }
	    if (o == null || getClass() != o.getClass()) {
	      return false;
	    }
	    Color color = (Color) o;
	    return Objects.equals(this.name, color.name) &&
	        Objects.equals(this.red, color.red) &&
	        Objects.equals(this.green, color.green) &&
	        Objects.equals(this.blue, color.blue);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(name, red, green, blue);
	  }

	  @Override
	  public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("class Color {\n");
	    sb.append("    name: ").append(toIndentedString(name)).append("\n");
	    sb.append("    r: ").append(toIndentedString(red)).append("\n");
	    sb.append("    g: ").append(toIndentedString(green)).append("\n");
	    sb.append("    b: ").append(toIndentedString(blue)).append("\n");
	    sb.append("}");
	    return sb.toString();
	  }

	  /**
	   * Convert the given object to string with each line indented by 4 spaces
	   * (except the first line).
	   */
	  private String toIndentedString(Object o) {
	    if (o == null) {
	      return "null";
	    }
	    return o.toString().replace("\n", "\n    ");
	  }
}
