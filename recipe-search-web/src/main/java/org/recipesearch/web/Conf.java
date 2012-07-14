package org.recipesearch.web;

import org.parancoe.util.BaseConf;

/**
 * here you can put configuration specific getters
 */
public class Conf extends BaseConf  {

    public String getMyParam() {
        return getConfiguration().getString("myparam");
    }
}
