<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1 class="my-4">Shop Name</h1>
<div class="list-group">

	<c:forEach items="${listCat}" var="category">
		<a href="${contextRoot}/show/category/${category.id}/products" class="list-group-item">${category.name}</a>

	</c:forEach>









</div>