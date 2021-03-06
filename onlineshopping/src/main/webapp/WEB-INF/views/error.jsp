<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url var="css" value="/resources/css" ></spring:url>
<spring:url var="js" value="/resources/js" ></spring:url>
<spring:url var="images" value="/resources/images" ></spring:url>

<c:set var="contextRoot" value="${pageContext.request.contextPath }"></c:set>


<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Shopping - ${title}</title>

<!-- Bootstrap core CSS -->
 <link href="${css}/bootstrap.min.css" rel="stylesheet">  

<link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">
<link href="${css}/shop-homepage.css" rel="stylesheet">


<!-- datatable bootstrap css -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">

<script>
window.menu= '${title}' ;
window.contextRoot='${contextRoot}' ; 
</script>

</head>

<body>

<div class="wrapper">
<div class="row">
<h2 ><a class="navbar-brand col-md-offset-3" href="${contextRoot}/home">Home</a></h2>
</div>

<div class="row">
<div class="col-xs-12 col-md-offset-2 col-md-9">
<div class="jumbotron">

<h1>${errorTitle}</h1>
<hr/>

<blockquote>
${errorDescription}
</blockquote>
<hr/>

<h3>

If you feel something is missing that should be here, <a  href="${contextRoot}/contact">contact Us</a></h2>.
</h3>


</div>


</div>
	
	
	
</div>


	<!-- footer -->
	<%@ include file="./shared/footer.jsp" %>
	

	<!-- Bootstrap core JavaScript -->
	<script src="${js}/jquery.js"></script>
	<script src="${js}/bootstrap.min.js"></script>
	
	
	<!-- datatables plugin-->
     <script src="${js}/jquery.dataTables.js"></script>
     <!-- datatables bootstrap.js-->
     <script src="${js}/dataTables.bootstrap.js"></script>
     
     
    <!-- self coded javascript -->
    
    <script src="${js}/myapp.js"></script>
    
</div>
</body>

</html>
