package com.example.groupproject;

public class FlightInfo {
    Integer QuoteId;
    Integer MinPrice;
    Boolean Direct;
    String Carrier;
    Integer OriginId;
    Integer DestinationId;
    String DepartureDate;
    String QuoteDateTime;

    public FlightInfo(Integer quoteId, Integer minPrice, Boolean direct, String carrier, Integer originId, Integer destinationId, String departureDate, String quoteDateTime) {
        QuoteId = quoteId;
        MinPrice = minPrice;
        Direct = direct;
        Carrier = carrier;
        OriginId = originId;
        DestinationId = destinationId;
        DepartureDate = departureDate;
        QuoteDateTime = quoteDateTime;
    }

    public FlightInfo() {
    }

    public Integer getQuoteId() {
        return QuoteId;
    }

    public void setQuoteId(Integer quoteId) {
        QuoteId = quoteId;
    }

    public Integer getMinPrice() {
        return MinPrice;
    }

    public void setMinPrice(Integer minPrice) {
        MinPrice = minPrice;
    }

    public Boolean getDirect() {
        return Direct;
    }

    public void setDirect(Boolean direct) {
        Direct = direct;
    }

    public String getCarrier() {
        return Carrier;
    }

    public void setCarrier(String carrier) {
        Carrier = carrier;
    }

    public Integer getOriginId() {
        return OriginId;
    }

    public void setOriginId(Integer originId) {
        OriginId = originId;
    }

    public Integer getDestinationId() {
        return DestinationId;
    }

    public void setDestinationId(Integer destinationId) {
        DestinationId = destinationId;
    }

    public String getDepartureDate() {
        return DepartureDate;
    }

    public void setDepartureDate(String departureDate) {
        DepartureDate = departureDate;
    }

    public String getQuoteDateTime() {
        return QuoteDateTime;
    }

    public void setQuoteDateTime(String quoteDateTime) {
        QuoteDateTime = quoteDateTime;
    }
}
