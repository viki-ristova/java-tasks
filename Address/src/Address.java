public class Address {
    private String street;
    private Integer streetNumber;
    private String city;
    private Integer zipCode;

    public Address() {
    }

    public Address(String street, Integer streetNumber, String city, Integer zipCode) throws InvalidZipCodeException {
        setStreet(street);
        setStreetNumber(streetNumber);
        setCity(city);
        setZipCode(zipCode);
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) throws InvalidZipCodeException {
        if (isValidZipCode(zipCode)) {
            this.zipCode = zipCode;
        } else {
            throw new InvalidZipCodeException("The zip code is invalid. It should consist of 5 or 9 digits.");
        }
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", streetNumber=" + streetNumber +
                ", city='" + city + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }

    public boolean isValidZipCode(Integer number) {
        return String.valueOf(number).length() == 5 || String.valueOf(number).length() == 9;
    }
}
