package org.recipesearch.web.beans;

import org.recipesearch.core.po.User;
import org.recipesearch.web.validation.AtLeastOneAuthorityChecked;
import org.parancoe.validator.constraints.NewPassword;
import java.util.LinkedList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * A bean for editing a user.
 *
 * @author Lucio Benfante
 */
@NewPassword
public class UserBean implements NewPasswordSupport {

    private User user;
    private String newPassword;
    private String confirmPassword;
    List<AuthorityCheckBox> authorityCheckBoxes = new LinkedList<AuthorityCheckBox>();

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

    @NotNull
    @AtLeastOneAuthorityChecked
    public List<AuthorityCheckBox> getAuthorityCheckBoxes() {
        return authorityCheckBoxes;
    }

    public void setAuthorityCheckBoxes(List<AuthorityCheckBox> authorityCheckBoxes) {
        this.authorityCheckBoxes = authorityCheckBoxes;
    }

}
