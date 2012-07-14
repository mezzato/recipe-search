<%--

    Copyright (C) 2009 Lucio Benfante <lucio.benfante@gmail.com>

    This file is part of minimark Web Application.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

--%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ include file="/WEB-INF/jsp/common.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
    <head>
        <link rel="stylesheet" href="${cp}/templates/clarity/css/1.css" type="text/css" media="screen,projection" />
        <link rel="stylesheet" href="${cp}/templates/clarity/sifr/sifr.css" type="text/css" media="screen,projection" />
        <%@ include file="/WEB-INF/jsp/head.jspf" %>
        <script src="${cp}/templates/clarity/sifr/sifr.js" type="text/javascript"></script>
        <script src="${cp}/templates/clarity/sifr/sifr-config.js" type="text/javascript"></script>
    </head>

    <body>

        <div id="header">
            <tiles:insertAttribute name="header"/>
            <tiles:insertAttribute name="menu"/>
        </div>

        <div id="container">

            <div id="content" class="fullWidth">
                <p:flash type="notice"/>
                <p:flash type="error"/>
                <tiles:insertAttribute name="main"/>
            </div>
<%--
            <div id="sidebar">
                <tiles:insertAttribute name="sidebar"/>
            </div>
--%>
        </div>

        <div id="footer">
            <p class="validate"><a href="http://validator.w3.org/check?uri=referer">XHTML</a> | <a href="http://jigsaw.w3.org/css-validator/">CSS</a><br /><a href="#">Top</a></p>

            <!-- Please leave this line intact -->
            <p>Template design by <a href="http://www.sixshootermedia.com">Six Shooter Media</a>.<br />
                <!-- you can delete below here -->
                <a href="http://wwww.parancoe.org"><img src="${cp}/images/powered_parancoe.png" alt="Parancoe powered" style="border: 0"/></a> &copy; <a href="http://www.recipe-search.com">recipe-search</a></p>
        </div>

        <% if (!BaseConf.isProduction()) {%>
        <jsp:include page="/WEB-INF/jsp/debug.jsp" />
        <% }%>

    </body>
</html>