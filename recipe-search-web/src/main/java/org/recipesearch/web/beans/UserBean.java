// Copyright 2006-2007 The Parancoe Team
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package org.recipesearch.web.beans;

import java.util.LinkedList;
import java.util.List;
import org.parancoe.plugins.security.User;
import org.springmodules.validation.bean.conf.loader.annotation.handler.CascadeValidation;
import org.springmodules.validation.bean.conf.loader.annotation.handler.Expression;
import org.springmodules.validation.bean.conf.loader.annotation.handler.Length;
import org.springmodules.validation.bean.conf.loader.annotation.handler.Validator;

/**
 * A bean for editing a user.
 *
 * @author Lucio Benfante
 */
@Validator(value = UserBeanAuthoritiesValidator.class)
public class UserBean {

    @CascadeValidation
    private User user;
    @Length(min=4, max=40, applyIf="newPassword != ''")
    private String newPassword;
    @Expression("confirmPassword == newPassword")
    private String confirmPassword;
    List<AuthorityCheckBox> authorityCheckBoxes = new LinkedList<AuthorityCheckBox>();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public List<AuthorityCheckBox> getAuthorityCheckBoxes() {
        return authorityCheckBoxes;
    }

    public void setAuthorityCheckBoxes(List<AuthorityCheckBox> authorityCheckBoxes) {
        this.authorityCheckBoxes = authorityCheckBoxes;
    }

}
