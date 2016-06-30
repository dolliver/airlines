//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.06.29 at 07:57:56 PM BRT 
//


package com.mttnow;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Flight" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="CarrierCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="FlightDesignator" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="OriginAirport" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="DestinationAirport" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="DepartureDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *                   &lt;element name="ArrivalDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *                   &lt;element name="Fares"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="Fare" maxOccurs="unbounded" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="BasePrice" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                                       &lt;element name="Fees" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                                       &lt;element name="Tax" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                                     &lt;/sequence&gt;
 *                                     &lt;attribute name="class" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "flight"
})
@XmlRootElement(name = "Availability")
public class Availability {

    @XmlElement(name = "Flight")
    protected List<Availability.Flight> flight;

    /**
     * Gets the value of the flight property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the flight property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFlight().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Availability.Flight }
     * 
     * 
     */
    public List<Availability.Flight> getFlight() {
        if (flight == null) {
            flight = new ArrayList<Availability.Flight>();
        }
        return this.flight;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="CarrierCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="FlightDesignator" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="OriginAirport" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="DestinationAirport" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="DepartureDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
     *         &lt;element name="ArrivalDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
     *         &lt;element name="Fares"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="Fare" maxOccurs="unbounded" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="BasePrice" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                             &lt;element name="Fees" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                             &lt;element name="Tax" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                           &lt;/sequence&gt;
     *                           &lt;attribute name="class" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "carrierCode",
        "flightDesignator",
        "originAirport",
        "destinationAirport",
        "departureDate",
        "arrivalDate",
        "fares"
    })
    public static class Flight {

        @XmlElement(name = "CarrierCode", required = true)
        protected String carrierCode;
        @XmlElement(name = "FlightDesignator", required = true)
        protected String flightDesignator;
        @XmlElement(name = "OriginAirport", required = true)
        protected String originAirport;
        @XmlElement(name = "DestinationAirport", required = true)
        protected String destinationAirport;
        @XmlElement(name = "DepartureDate", required = true)
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar departureDate;
        @XmlElement(name = "ArrivalDate", required = true)
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar arrivalDate;
        @XmlElement(name = "Fares", required = true)
        protected Availability.Flight.Fares fares;

        /**
         * Gets the value of the carrierCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCarrierCode() {
            return carrierCode;
        }

        /**
         * Sets the value of the carrierCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCarrierCode(String value) {
            this.carrierCode = value;
        }

        /**
         * Gets the value of the flightDesignator property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFlightDesignator() {
            return flightDesignator;
        }

        /**
         * Sets the value of the flightDesignator property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFlightDesignator(String value) {
            this.flightDesignator = value;
        }

        /**
         * Gets the value of the originAirport property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOriginAirport() {
            return originAirport;
        }

        /**
         * Sets the value of the originAirport property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOriginAirport(String value) {
            this.originAirport = value;
        }

        /**
         * Gets the value of the destinationAirport property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDestinationAirport() {
            return destinationAirport;
        }

        /**
         * Sets the value of the destinationAirport property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDestinationAirport(String value) {
            this.destinationAirport = value;
        }

        /**
         * Gets the value of the departureDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDepartureDate() {
            return departureDate;
        }

        /**
         * Sets the value of the departureDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDepartureDate(XMLGregorianCalendar value) {
            this.departureDate = value;
        }

        /**
         * Gets the value of the arrivalDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getArrivalDate() {
            return arrivalDate;
        }

        /**
         * Sets the value of the arrivalDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setArrivalDate(XMLGregorianCalendar value) {
            this.arrivalDate = value;
        }

        /**
         * Gets the value of the fares property.
         * 
         * @return
         *     possible object is
         *     {@link Availability.Flight.Fares }
         *     
         */
        public Availability.Flight.Fares getFares() {
            return fares;
        }

        /**
         * Sets the value of the fares property.
         * 
         * @param value
         *     allowed object is
         *     {@link Availability.Flight.Fares }
         *     
         */
        public void setFares(Availability.Flight.Fares value) {
            this.fares = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="Fare" maxOccurs="unbounded" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="BasePrice" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *                   &lt;element name="Fees" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *                   &lt;element name="Tax" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *                 &lt;/sequence&gt;
         *                 &lt;attribute name="class" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *       &lt;/sequence&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "fare"
        })
        public static class Fares {

            @XmlElement(name = "Fare")
            protected List<Availability.Flight.Fares.Fare> fare;

            /**
             * Gets the value of the fare property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the fare property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getFare().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Availability.Flight.Fares.Fare }
             * 
             * 
             */
            public List<Availability.Flight.Fares.Fare> getFare() {
                if (fare == null) {
                    fare = new ArrayList<Availability.Flight.Fares.Fare>();
                }
                return this.fare;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;complexContent&gt;
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *       &lt;sequence&gt;
             *         &lt;element name="BasePrice" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
             *         &lt;element name="Fees" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
             *         &lt;element name="Tax" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
             *       &lt;/sequence&gt;
             *       &lt;attribute name="class" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
             *     &lt;/restriction&gt;
             *   &lt;/complexContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "basePrice",
                "fees",
                "tax"
            })
            public static class Fare {

                @XmlElement(name = "BasePrice", required = true)
                protected String basePrice;
                @XmlElement(name = "Fees", required = true)
                protected String fees;
                @XmlElement(name = "Tax", required = true)
                protected String tax;
                @XmlAttribute(name = "class")
                protected String clazz;

                /**
                 * Gets the value of the basePrice property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getBasePrice() {
                    return basePrice;
                }

                /**
                 * Sets the value of the basePrice property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setBasePrice(String value) {
                    this.basePrice = value;
                }

                /**
                 * Gets the value of the fees property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getFees() {
                    return fees;
                }

                /**
                 * Sets the value of the fees property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setFees(String value) {
                    this.fees = value;
                }

                /**
                 * Gets the value of the tax property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getTax() {
                    return tax;
                }

                /**
                 * Sets the value of the tax property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setTax(String value) {
                    this.tax = value;
                }

                /**
                 * Gets the value of the clazz property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getClazz() {
                    return clazz;
                }

                /**
                 * Sets the value of the clazz property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setClazz(String value) {
                    this.clazz = value;
                }

            }

        }

    }

}
