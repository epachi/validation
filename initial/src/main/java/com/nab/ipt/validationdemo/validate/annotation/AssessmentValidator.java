package com.nab.ipt.validationdemo.validate.annotation;

/**
 * Created by User on 12/01/2017.
 */
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.nab.ipt.validationdemo.domain.Assessment;
import com.nab.ipt.validationdemo.domain.BankerOverride;
import com.nab.ipt.validationdemo.domain.Broker;
import com.nab.ipt.validationdemo.domain.Customer;
//import org.apache.commons.beanutils.BeanUtils;

public class AssessmentValidator
        implements ConstraintValidator<AssessmentValid, Object> {

    @Override
    public void initialize(final AssessmentValid assessmentValid) {
    }

    @Override
    public boolean isValid(
            final Object t, final ConstraintValidatorContext cvc) {
        try {
            Assessment assessment = (Assessment) t;
            Customer customer = assessment.getCustomer();

            BankerOverride bankerOverride = assessment.getBankerOverride();
            Broker broker = assessment.getBroker();

            if (customer == null) {
                throw new Exception("Unexpected Error. Customer is null");
            }

            if ("PROP".equals(customer.getChannelCode())) {
                return ((bankerOverride != null) && (broker == null));
            } else if ("BROK".equals(customer.getChannelCode())) {
                return ((bankerOverride == null) && (broker != null));
            }
            throw new Exception("Unexpected Error. Unknown Channel Code");

        } catch (final Exception e) {
//            throw new RuntimeException(e.getMessage(), e);
            // May log the message at this point.
            return false;
        }
    }
}
