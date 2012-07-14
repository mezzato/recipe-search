package org.recipesearch.web.beans;

import org.recipesearch.core.po.User;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.parancoe.web.test.BaseTest;

/**
 * A test case for the UserBean usage (for UserBean validation, etc.)
 *
 * @author Lucio Benfante
 */
public class UserBeanTest extends BaseTest {

    public void testValidUserBean() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        UserBean userBean = buildValidUserBean();
        Set<ConstraintViolation<UserBean>> result = validator.validate(userBean);
        assertSize(0, result);
    }

    public void testFailedPasswordValidationUserBean() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        UserBean userBean = buildValidUserBean();
        userBean.setNewPassword("password");
        userBean.setConfirmPassword("different");
        Set<ConstraintViolation<UserBean>> result = validator.validate(userBean);
        assertSize(1, result);
        assertEquals("{org.parancoe.validator.constraints.NewPassword.message}", result.
                iterator().next().getMessageTemplate());
    }

    public void testFailedAuthorityCheckboxesValidationUserBean() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        UserBean userBean = buildValidUserBean();
        for (AuthorityCheckBox authorityCheckBox : userBean.getAuthorityCheckBoxes()) {
            authorityCheckBox.setChecked(false);
        }
        Set<ConstraintViolation<UserBean>> result = validator.validate(userBean);
        assertSize(1, result);
        assertEquals("{org.recipesearch.validation.atleastoneauthoritychecked}", result.
                iterator().next().getMessageTemplate());
    }

    private UserBean buildValidUserBean() {
        UserBean userBean = new UserBean();
        final User user = new User();
        user.setUsername("username");
        user.setPassword("password");
        userBean.setUser(user);
        AuthorityCheckBox authorityCheckBox = new AuthorityCheckBox();
        authorityCheckBox.setChecked(true);
        userBean.getAuthorityCheckBoxes().add(authorityCheckBox);
        return userBean;
    }
}
