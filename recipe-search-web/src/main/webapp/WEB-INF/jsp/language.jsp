<%@ include file="common.jspf" %>
<%@ page import="java.util.List" %>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="org.parancoe.util.Utils" %>
<%
Map paramMap = request.getParameterMap();
Map tmp = new HashMap(paramMap);
tmp.remove("language");
tmp.put("null", "null");
List<String> paramKeyValuesList = Utils.convertToNameValueList(tmp, true);
String queryString = "?" + StringUtils.join(paramKeyValuesList.iterator(), "&amp;");
%>
<span id="language">
    <!-- lang: ${requestScope.lang} -->
    <!-- locale: ${requestScope.requestContext.locale} -->
    <c:forEach var="supportedLanguage" items="${conf.supportedLanguages}" varStatus="status">
        <a href="<%=queryString%>&amp;language=${supportedLanguage}" title="${supportedLanguage}">
            <c:choose>
                <c:when test="${requestScope.requestContext.locale eq supportedLanguage}">
                    <b><spring:message code="${supportedLanguage}" text="?${supportedLanguage}?"/></b>                
                </c:when>
                <c:otherwise>
                    <spring:message code="${supportedLanguage}" text="?${supportedLanguage}?"/>                
                </c:otherwise>
            </c:choose>
        </a>
        <c:if test="${status.count % 2 == 0}"><br/></c:if>
    </c:forEach>
</span>
