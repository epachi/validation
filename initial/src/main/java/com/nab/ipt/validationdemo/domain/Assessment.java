package com.nab.ipt.validationdemo.domain;

import com.nab.ipt.validationdemo.validate.annotation.AssessmentValid;
import com.nab.ipt.validationdemo.validate.validationgroups.ValidationGroups;

import javax.validation.Valid;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * Created by User on 11/01/2017.
 */
@AssessmentValid.List(value = {
        @AssessmentValid(
                message="Invalid Assessment the presence of BankerOverride and/or Broker does not match Channel Type",
                groups={ValidationGroups.VersionTwo.class})
})
public class Assessment {

    @NotNull(message="Customer cannot be null",
            groups={ValidationGroups.VersionOne.class,
                    ValidationGroups.VersionTwo.class})
    @Valid
    private Customer customer;

    @NotNull(message="BankerOverride cannot be null",
            groups={ValidationGroups.VersionOne.class})
    @Valid
    private BankerOverride bankerOverride;

    @Null(message="Broker should be null",
            groups={ValidationGroups.VersionOne.class})
    @Valid
    private Broker broker;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BankerOverride getBankerOverride() {
        return bankerOverride;
    }

    public void setBankerOverride(BankerOverride bankerOverride) {
        this.bankerOverride = bankerOverride;
    }

    public Broker getBroker() {
        return broker;
    }

    public void setBroker(Broker broker) {
        this.broker = broker;
    }
}
