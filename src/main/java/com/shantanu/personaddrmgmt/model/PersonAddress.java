package com.shantanu.personaddrmgmt.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

/**
 * PersonAddress
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-02-09T06:18:00.153Z[GMT]")

@Entity
@Table(name = "person_address")
public class PersonAddress
{

    @JsonProperty("id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id = null;

    @JsonProperty("address1")
    @NotEmpty(message = "Address1 cannot be null or empty")
    @Column(name = "address1")
    private String address1 = null;

    @JsonProperty("address2")
    @Column(name = "address2")
    @NotEmpty(message = "Address2 cannot be null or empty")
    private String address2 = null;

    @JsonProperty("area")
    @NotEmpty(message = "Area cannot be null or empty")
    @Column(name = "area")
    private String area = null;

    @JsonProperty("city")
    @NotEmpty(message = "City cannot be null or empty")
    @Column(name = "city")
    private String city = null;

    @JsonProperty("postalCode")
    @NotEmpty(message= "Postal code cannot be null or empty")
    @Size(max = 10, min = 6, message = "Postal code must be between 6 and 10 characters in length")
    @Column(name = "postalCode")
    private String postalCode = null;

    @JsonProperty("state")
    @NotEmpty(message= "State cannot be null or empty")
    @Size(min = 2, message = "State name must be minimum 2 characters in length")
    @Column(name = "state")
    private String state = null;

    @JsonProperty("country")
    @Column(name = "country")
    @NotEmpty(message= "Country cannot be null or empty")
    @Size(min = 2, message = "Country name must be minimum 2 characters in length")
    private String country = null;

    public PersonAddress id(Integer id)
    {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
   *
     */
    @Schema(description = "")

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public PersonAddress address1(String address1)
    {
        this.address1 = address1;
        return this;
    }

    /**
     * Get address1
     *
     * @return address1
   *
     */
    @Schema(description = "")

    public String getAddress1()
    {
        return address1;
    }

    public void setAddress1(String address1)
    {
        this.address1 = address1;
    }

    public PersonAddress address2(String address2)
    {
        this.address2 = address2;
        return this;
    }

    /**
     * Get address2
     *
     * @return address2
   *
     */
    @Schema(description = "")

    public String getAddress2()
    {
        return address2;
    }

    public void setAddress2(String address2)
    {
        this.address2 = address2;
    }

    public PersonAddress area(String area)
    {
        this.area = area;
        return this;
    }

    /**
     * Get area
     *
     * @return area
   *
     */
    @Schema(description = "")

    public String getArea()
    {
        return area;
    }

    public void setArea(String area)
    {
        this.area = area;
    }

    public PersonAddress city(String city)
    {
        this.city = city;
        return this;
    }

    /**
     * Get city
     *
     * @return city
   *
     */
    @Schema(description = "")

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public PersonAddress postalCode(String postalCode)
    {
        this.postalCode = postalCode;
        return this;
    }

    /**
     * Get postalCode
     *
     * @return postalCode
   *
     */
    @Schema(description = "")

    public String getPostalCode()
    {
        return postalCode;
    }

    public void setPostalCode(String postalCode)
    {
        this.postalCode = postalCode;
    }

    public PersonAddress state(String state)
    {
        this.state = state;
        return this;
    }

    /**
     * Get state
     *
     * @return state
   *
     */
    @Schema(description = "")

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public PersonAddress country(String country)
    {
        this.country = country;
        return this;
    }

    /**
     * Get country
     *
     * @return country
   *
     */
    @Schema(description = "")

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    @Override
    public boolean equals(java.lang.Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        PersonAddress personAddress = (PersonAddress) o;
        return Objects.equals(this.id, personAddress.id)
                && Objects.equals(this.address1, personAddress.address1)
                && Objects.equals(this.address2, personAddress.address2)
                && Objects.equals(this.area, personAddress.area)
                && Objects.equals(this.city, personAddress.city)
                && Objects.equals(this.postalCode, personAddress.postalCode)
                && Objects.equals(this.state, personAddress.state)
                && Objects.equals(this.country, personAddress.country);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, address1, address2, area, city, postalCode, state, country);
    }

    @Override
    public String toString()
    {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch(Exception e) {
            return "";
        }
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o)
    {
        if (o == null)
        {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
