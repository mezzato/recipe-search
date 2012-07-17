<%@ include file="../common.jspf"%>
<%-- this form-search-page. --%>
<div id="loginBox">
	<div id="loginTitle">
		<spring:message code="searchTitle" />
	</div>
	<div id="loginMessageBox">
		<p>Type in some text to look for a recipe.</p>
		<c:if test="${not empty param.search_error}">
			<font color="red"> Your search attempt was not successful, try
				again.<br />
			</font>
		</c:if>
	</div>
	<div class="form-container">

		<form name="searchForm" method="POST"
			action="${cpr}/search/${person.id}">
			<div>
				<label for="search_text"><spring:message code="search_text" /></label>
				<input id="search_text" type='text' name='search_text' tabindex="1"
					value="weißwurst" />
			</div>
			<div class="buttonrow">
				<input id="submit" name="submit" type="submit"
					value="<spring:message code='search'/>" tabindex="4" />
			</div>
		</form>
	</div>
</div>
