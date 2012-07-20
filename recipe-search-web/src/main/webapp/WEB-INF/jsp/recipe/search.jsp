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
	<div id="searchTitle">
		<spring:message code="search_title" />
	</div>
	<div class="form-container">

		<form:form
			modelAttribute="<%= org.recipesearch.web.controllers.RecipeController.SEARCH_ATTR_NAME %>"
			name="searchForm" method="GET" action="">
			<div>
				<div>
					<form:label path="searchText">
						<spring:message code="search_text" text="?search_text?" />:</form:label>
					<form:input path="searchText" tabindex="1" />
				</div>
				<form:errors path="searchText" cssClass="error" />
			</div>
			<div class="buttonrow">
				<input id="submit" name="submit" type="submit" value="<spring:message code='search_submit'  text='?search_submit?'/>" tabindex="2" />
				<!-- onclick="launchSearch"  -->
			</div>
		</form:form>

	</div>
	<c:if test="${not empty param.searchText}">
		<div class="displaytag">
			<display:table id="recipe" name="recipes" sort="list" pagesize="20"
				defaultsort="1" defaultorder="ascending" requestURI="">
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
