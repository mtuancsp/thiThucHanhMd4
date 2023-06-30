package com.example.thithuchanhmd4.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @ManyToOne
    @JoinColumn(name = "nationId", referencedColumnName = "id")
    private Nation nation;

    @DecimalMin(value = "0.01", message = "Area must be greater than 0")
    private double area;

    @Min(value = 0, message = "Population must be greater than or equal to 0")
    private int population;

    @Min(value = 0, message = "GDP must be greater than or equal to 0")
    private int GDP;

    @NotBlank(message = "Description is required")
    private String description;

    public City() {}

    public City(String name, Nation nation, double area, int population, int GDP, String description) {
        this.name = name;
        this.nation = nation;
        this.area = area;
        this.population = population;
        this.GDP = GDP;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Nation getNation() {
        return nation;
    }

    public void setNation(Nation nation) {
        this.nation = nation;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getGDP() {
        return GDP;
    }

    public void setGDP(int GDP) {
        this.GDP = GDP;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
