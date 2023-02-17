package com.example.travels.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="travels")
public class Travel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min=1,message="must include expense")
    private String expenseName;

    @NotBlank
    @Size(min=1,message="Must include a vendor")
    private String vendor;

    private Double ammount;

    @NotBlank
    @Size(min=1,message="must include a description")
    private String description;

    public Travel(){

    }

    public Travel(String expenseName, String vendor, Double ammount,String description){
        this.expenseName = expenseName;
        this.vendor = vendor;
        this.ammount = ammount;
        this.description = description;
    }



    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExpenseName() {
        return this.expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public String getVendor() {
        return this.vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Double getAmmount() {
        return this.ammount;
    }

    public void setAmmount(Double ammount) {
        this.ammount = ammount;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }




}
