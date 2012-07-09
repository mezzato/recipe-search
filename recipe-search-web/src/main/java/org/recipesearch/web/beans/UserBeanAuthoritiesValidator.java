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

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * A validator for the authorities checkboxes of a UserBean.
 * 
 * @author Lucio Benfante
 */
public class UserBeanAuthoritiesValidator implements Validator {

    public boolean supports(Class clazz) {
        return UserBean.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        UserBean userBean = (UserBean) target;
        boolean noneChecked = true;
        for (AuthorityCheckBox authorityCheckBox : userBean.getAuthorityCheckBoxes()) {
            if (authorityCheckBox.isChecked()) {
                noneChecked = false;
                break;
            }
        }
        if (noneChecked) {
            errors.rejectValue("authorityCheckBoxes", "noCheckedAuthorities",
                    "At least one authority must be checked!");
        }
    }
}
