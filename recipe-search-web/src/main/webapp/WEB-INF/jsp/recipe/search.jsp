<%@ include file="../common.jspf"%>
<%-- this form-search-page. --%>
<script type="text/javascript">
	function launchSearch() {

		var h = $H({
			searchText : $('searchText').getValue()
		});
		window.location = "?" + h.toQueryString();
		return false;
	}
</script>
<div id="searchBox">
	<div id="loginTitle">
		<spring:message code="search_title" />
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

		<form name="searchForm" method="GET" action="">
			<div>
				<label for="searchText"><spring:message code="search_text" /></label>
				<input id="searchText" type='text' name='searchText' tabindex="1"
					value='<c:choose><c:when test="${not empty param.searchText}">${param.searchText}</c:when><c:otherwise>weiﬂwurst</c:otherwise></c:choose>' />
			</div>
			<div class="buttonrow">
				<input id="submit" name="submit" type="submit"
					value="<spring:message code='search'/>" tabindex="4" />
				<!-- onclick="launchSearch"  -->
			</div>
		</form>
	</div>
	<c:if test="${not empty param.searchText}">
		<div class="displaytag">
			<display:table id="recipe" name="recipes" sort="list" pagesize="20"
				defaultsort="5" defaultorder="ascending" requestURI="">
				<!-- author, title, text  -->
				<display:column titleKey="author" sortable="true">
					<c:out value="${recipe.author}" />
				</display:column>
				<display:column titleKey="title" sortable="true">
					<c:out value="${recipe.title}" />
				</display:column>
				<display:column titleKey="text" sortable="false">
					<c:out value="${recipe.text}" />
				</display:column>
			</display:table>
		</div>
	</c:if>
</div>
