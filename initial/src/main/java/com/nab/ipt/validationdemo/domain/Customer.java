package com.nab.ipt.validationdemo.domain;

import com.nab.ipt.validationdemo.validate.validationgroups.ValidationGroups;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;

/**
 * Created by User on 11/01/2017.
 */
public class Customer {
    // Optional field
    private String customerNumber;

    // Optional field
    private String firstname;

    // Optional field
    private String surname;

    @NotNull(message="channel code cannot be null",
            groups={ValidationGroups.VersionTwo.class})
    @Pattern(regexp="PROP|BROK", message="channel code can either be proprietary(PROP) or broker(BROK)",
            groups={ ValidationGroups.VersionTwo.class})
    @Null(message="channel code should be null",
            groups={ValidationGroups.VersionOne.class})
    private String channelCode;

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }
}
