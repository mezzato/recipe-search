package org.recipesearch.web.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Validation annotation for the setting of a new password.
 *
 * @author Lucio Benfante
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AtLeastOneAuthorityCheckedValidator.class)
@Documented
public @interface AtLeastOneAuthorityChecked {

    String message() default "{org.recipesearch.validation.atleastoneauthoritychecked}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
