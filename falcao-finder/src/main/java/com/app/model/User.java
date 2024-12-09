package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob; // Importante para campos binários como BLOB

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int u_id;

    private String username;
    private String password;
    private String confirmPassword;
    private String securityCode;

    @Lob // Indica que o campo é binário (BLOB) no banco de dados
    private byte[] profilePhoto; // Armazena foto de perfil em formato binário

    @Lob
    private byte[] coverPhoto; // Armazena foto de capa em formato binário

    // Getters e Setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getConfirmPassword() { return confirmPassword; }
    public void setConfirmPassword(String confirmPassword) { this.confirmPassword = confirmPassword; }

    public String getSecurityCode() { return securityCode; }
    public void setSecurityCode(String securityCode) { this.securityCode = securityCode; }

    public byte[] getProfilePhoto() { return profilePhoto; }
    public void setProfilePhoto(byte[] profilePhoto) { this.profilePhoto = profilePhoto; }

    public byte[] getCoverPhoto() { return coverPhoto; }
    public void setCoverPhoto(byte[] coverPhoto) { this.coverPhoto = coverPhoto; }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }
}
