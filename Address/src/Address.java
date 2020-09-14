public class Address {
    private String street;
    private Integer streetNumber;
    private String city;
    private Integer zipCode;

    public Address() {
    }

    public Address(String street, Integer streetNumber, String city, Integer zipCode) throws InvalidZipCodeException {
        this.street = street;
        this.streetNumber = streetNumber;
        this.city = city;
        if(getNumberOfDigitsForNumber(zipCode) == 5 || getNumberOfDigitsForNumber(zipCode) == 9) {
            this.zipCode = zipCode;
        } else
        {
            throw new InvalidZipCodeException("The zip code is invalid. It should consist 5 or 9 digits.");
        }
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
        if(getNumberOfDigitsForNumber(zipCode) == 5 || getNumberOfDigitsForNumber(zipCode) == 9) {
            this.zipCode = zipCode;
        } else {
            throw new InvalidZipCodeException("The zip code is invalid. It should consist 5 or 9 digits.");
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

    public int getNumberOfDigitsForNumber(Integer number){
        int digitsNumber =0;
        for(digitsNumber = 0;number!=0;digitsNumber++){
            number/=10;
        }
        return digitsNumber;
    }
}