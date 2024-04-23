/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import pojo.Specialization;

/**
 *
 * @author Laboratorios
 */
public class ExistentDoctorDTO {
    private Long id;
    private String name;
    private String firstName;
    private String SecondName;
    private Specialization specialization;
    private String medicalCart;

    public ExistentDoctorDTO() {
    }

    public ExistentDoctorDTO(Long id, String name, String firstName, String SecondName, Specialization specialization, String medicalCart) {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.SecondName = SecondName;
        this.specialization = specialization;
        this.medicalCart = medicalCart;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return SecondName;
    }

    public void setSecondName(String SecondName) {
        this.SecondName = SecondName;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public String getMedicalCart() {
        return medicalCart;
    }

    public void setMedicalCart(String medicalCart) {
        this.medicalCart = medicalCart;
    }
}
