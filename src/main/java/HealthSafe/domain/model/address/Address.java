package HealthSafe.domain.model.address;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {

    private String street;
    private String number;
    private String city;
    private String state;
    private String zipCode;

    public Address() {}

    public Address(AddressDto dto) {
        this.street = dto.street();
        this.number = dto.number();
        this.city = dto.city();
        this.state = dto.state();
        this.zipCode = dto.zipCode();
    }


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void update(AddressDto dto) {
        if (dto.street() != null) {
            this.street = dto.street();
        }
        if (dto.number() != null) {
            this.number = dto.number();
        }
        if (dto.city() != null) {
            this.city = dto.city();
        }
        if (dto.state() != null) {
            this.state = dto.state();
        }
        if (dto.zipCode() != null) {
            this.zipCode = dto.zipCode();
        }
    }
}
