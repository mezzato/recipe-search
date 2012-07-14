
<%@ include file="common.jspf"%>
<div id="footer">
    <div id="validators">&nbsp;</div>
    <div id="copyright">&#169; 2010, ${url}<br/><a href="mailto:info@recipe-search.com">info@recipe-search.com</a></div>
    <div id="references"><a href="http://wwww.parancoe.org"><img src="${cp}/images/powered_parancoe.png" alt="Parancoe powered" border="0"/></a></div>
</div>

<% if (!BaseConf.isProduction()) { %>
<jsp:include page="debug.jsp" />
<% } %>