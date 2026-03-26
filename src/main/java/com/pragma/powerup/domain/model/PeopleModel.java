package com.pragma.powerup.domain.model;

public class PeopleModel {
    private String documentNumber;
    private String name;
    private String email;

    public PeopleModel() {
    }

    public PeopleModel(String documentNumber, String name, String email) {
        this.documentNumber = documentNumber;
        this.name = name;
        this.email = email;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
