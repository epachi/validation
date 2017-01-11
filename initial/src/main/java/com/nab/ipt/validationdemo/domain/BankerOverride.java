package com.nab.ipt.validationdemo.domain;

import com.nab.ipt.validationdemo.validate.validationgroups.ValidationGroups;

import javax.validation.constraints.NotNull;

/**
 * Created by User on 11/01/2017.
 */
public class BankerOverride {
    @NotNull(message="bankerOverride buid cannot be null",
            groups={ValidationGroups.VersionOne.class})
    private String buid;

    @NotNull(message="bankerOverride firstname cannot be null",
            groups={ValidationGroups.VersionOne.class})
    private String firstname;

    @NotNull(message="bankerOverride surname cannot be null",
            groups={ValidationGroups.VersionOne.class})
    private String surname;

    public String getBuid() {
        return buid;
    }

    public void setBuid(String buid) {
        this.buid = buid;
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
}
