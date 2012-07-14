package org.recipesearch.web.beans;

import org.recipesearch.core.po.User;
import org.parancoe.validator.constraints.NewPassword;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * A bean for editing a user.
 *
 * @author Lucio Benfante
 */
@NewPassword
public class UserProfileBean implements NewPasswordSupport {

    private User user;
    private String newPassword;
    private String confirmPassword;

    @Valid
    @NotNull
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String getNewPassword() {
        return newPassword;
    }

    @Override
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    @Override
    public String getConfirmPassword() {
        return confirmPassword;
    }

    @Override
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

}
