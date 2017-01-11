package com.nab.ipt.validationdemo.domain;

import com.nab.ipt.validationdemo.validate.validationgroups.ValidationGroups;

import javax.validation.constraints.NotNull;

/**
 * Created by User on 11/01/2017.
 */
public class Broker {

    @NotNull(message="broker spid cannot be null",
            groups={ValidationGroups.VersionTwo.class})
    private String spid;

    @NotNull(message="broker firstname cannot be null",
            groups={ValidationGroups.VersionTwo.class})
    private String firstname;

    @NotNull(message="broker surname cannot be null",
            groups={ValidationGroups.VersionTwo.class})
    private String surname;

    public String getSpid() {
        return spid;
    }

    public void setSpid(String spid) {
        this.spid = spid;
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
