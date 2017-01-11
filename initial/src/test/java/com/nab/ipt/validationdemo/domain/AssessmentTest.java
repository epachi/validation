package com.nab.ipt.validationdemo.domain;

import com.nab.ipt.validationdemo.validate.validationgroups.ValidationGroups;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;
import static org.junit.Assert.assertEquals;

/**
 * Created by User on 11/01/2017.
 */
public class AssessmentTest {

//    @Test
//    public void testWithoutGroupWithEmptyAssessment() {
//        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//        Validator validator = factory.getValidator();
//
//        Assessment assessment = new Assessment();
//        Customer customer = new Customer();;
//        assessment.setCustomer(customer);
//
//        BankerOverride bankerOverride = new BankerOverride();
//        assessment.setBankerOverride(bankerOverride);
//
//        Broker broker = new Broker();
//        assessment.setBroker(broker);
//
//        Set<ConstraintViolation<Assessment>> constraintViolations =
//                validator.validate(assessment);
//
//        assertEquals(7, constraintViolations.size());
//        printConstraintViolationMessages(constraintViolations);
//    }

    @Test
    public void testWithVersionOneGroupWithEmptyAssessment() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Assessment assessment = new Assessment();

        Set<ConstraintViolation<Assessment>> constraintViolations =
                validator.validate(assessment, ValidationGroups.VersionOne.class);

        assertEquals(2, constraintViolations.size());
        printConstraintViolationMessages(constraintViolations);
    }

    @Test
    public void testWithVersionTwoGroupWithEmptyAssessment() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Assessment assessment = new Assessment();

        Set<ConstraintViolation<Assessment>> constraintViolations =
                validator.validate(assessment, ValidationGroups.VersionTwo.class);

        assertEquals(2, constraintViolations.size());
        printConstraintViolationMessages(constraintViolations);
    }

    @Test
    public void testWithVersionOneGroupWithCustomerWithChannelCodeInAssessment() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Assessment assessment = new Assessment();
        Customer customer = new Customer();
        customer.setChannelCode("PROP");
        assessment.setCustomer(customer);

        BankerOverride bankerOverride = new BankerOverride();
        assessment.setBankerOverride(bankerOverride);

        Set<ConstraintViolation<Assessment>> constraintViolations =
                validator.validate(assessment, ValidationGroups.VersionOne.class);

        assertEquals(4, constraintViolations.size());
        printConstraintViolationMessages(constraintViolations);
    }

    @Test
    public void testWithVersionTwoGroupWithCustomerWithChannelCodePROPInAssessment() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Assessment assessment = new Assessment();
        Customer customer = new Customer();
        customer.setChannelCode("PROP");
        assessment.setCustomer(customer);

        BankerOverride bankerOverride = new BankerOverride();
        bankerOverride.setBuid("SomeBuid");
        bankerOverride.setFirstname("bankerFirstname");
        bankerOverride.setSurname("bankerSurname");
        assessment.setBankerOverride(bankerOverride);


        Set<ConstraintViolation<Assessment>> constraintViolations =
                validator.validate(assessment, ValidationGroups.VersionTwo.class);

        assertEquals(0, constraintViolations.size());
        printConstraintViolationMessages(constraintViolations);
    }

    @Test
    public void testWithVersionTwoGroupWithCustomerWithChannelCodeBROKInAssessment() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Assessment assessment = new Assessment();
        Customer customer = new Customer();
        customer.setChannelCode("BROK");
        assessment.setCustomer(customer);

        BankerOverride bankerOverride = new BankerOverride();
        bankerOverride.setBuid("SomeBuid");
        bankerOverride.setFirstname("bankerFirstname");
        bankerOverride.setSurname("bankerSurname");
        assessment.setBankerOverride(bankerOverride);


        Set<ConstraintViolation<Assessment>> constraintViolations =
                validator.validate(assessment, ValidationGroups.VersionTwo.class);

        assertEquals(1, constraintViolations.size());
        printConstraintViolationMessages(constraintViolations);
    }


    private void printConstraintViolationMessages(Set<ConstraintViolation<Assessment>> constraintViolations) {
        System.out.println("******************");
        constraintViolations.stream().map(i -> i.getMessage()).forEach(System.out::println);
        System.out.println("******************");
    }
}
