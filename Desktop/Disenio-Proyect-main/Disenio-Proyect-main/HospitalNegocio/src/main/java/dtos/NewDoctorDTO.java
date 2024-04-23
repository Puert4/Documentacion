package dtos;

import pojo.Specialization;

/**
 *
 * @author Laboratorios
 */
public class NewDoctorDTO {
    
    private String name;
    private String firstName;
    private String SecondName;
    private Specialization specialization;
    private String medicalCart;

    public NewDoctorDTO() {
    }

    public NewDoctorDTO(String name, String firstName, String SecondName, Specialization specialization, String medicalCart) {
        this.name = name;
        this.firstName = firstName;
        this.SecondName = SecondName;
        this.specialization = specialization;
        this.medicalCart = medicalCart;
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
