package com.example.groupproject;

public class FlightInfo {
    String QuoteId;
    String MinPrice;
    String Direct;
    String CarrierIds;
    String OriginId;
    String DestinationId;
    String DepartureDate;
    String QuoteDateTime;


    public FlightInfo(String quoteId, String minPrice, String direct, String carrierIds, String originId, String destinationId, String departureDate, String quoteDateTime) {
        QuoteId = quoteId;
        MinPrice = minPrice;
        Direct = direct;
        CarrierIds = carrierIds;
        OriginId = originId;
        DestinationId = destinationId;
        DepartureDate = departureDate;
        QuoteDateTime = quoteDateTime;
    }

    public FlightInfo() {
    }

    public String getQuoteId() {
        return QuoteId;
    }

    public void setQuoteId(String quoteId) {
        QuoteId = quoteId;
    }

    public String getMinPrice() {
        return MinPrice;
    }

    public void setMinPrice(String minPrice) {
        MinPrice = minPrice;
    }

    public String getDirect() {
        return Direct;
    }

    public void setDirect(String direct) {
        Direct = direct;
    }

    public String getCarrierIds() {
        return CarrierIds;
    }

    public void setCarrierIds(String carrierIds) {
        CarrierIds = carrierIds;
    }

    public String getOriginId() {
        return OriginId;
    }

    public void setOriginId(String originId) {
        OriginId = originId;
    }

    public String getDestinationId() {
        return DestinationId;
    }

    public void setDestinationId(String destinationId) {
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
