// Copyright 2006-2008 The Parancoe Team
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
package org.recipesearch.web;

import org.parancoe.plugins.security.Authority;
import org.parancoe.plugins.security.User;

/**
 * A context listener that initialize the database of the application (if not
 * initialized yet)
 *
 * @author Jacopo Murador
 * @author Lucio Benfante
 */
public class PopulateInitialDataContextListener extends org.parancoe.web.PopulateInitialDataContextListener {

    public PopulateInitialDataContextListener() {
        // Add here to the clazzToPopulate collection the entity classes you need to populate
        clazzToPopulate.add(Authority.class);
        clazzToPopulate.add(User.class);
    }

}
