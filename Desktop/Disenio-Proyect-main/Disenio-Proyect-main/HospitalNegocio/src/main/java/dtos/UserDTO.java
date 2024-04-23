/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

/**
 *
 * @author TeLesheo
 */
public class UserDTO {
    
    private String user;
    
    private String password;
    
    private NewPatientDTO patientDTO;
    
    private NewDoctorDTO doctorDTO;

    public UserDTO() {
    }

    public UserDTO(String user, String password, NewPatientDTO patientDTO) {
        this.user = user;
        this.password = password;
        this.patientDTO = patientDTO;
    }
    
     public UserDTO(String user, String password, NewDoctorDTO doctorDTO) {
        this.user = user;
        this.password = password;
        this.doctorDTO = doctorDTO;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public NewPatientDTO getPatientDTO() {
        return patientDTO;
    }

    public void setPatientDTO(NewPatientDTO patientDTO) {
        this.patientDTO = patientDTO;
    }
    
    
    
}
