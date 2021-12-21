<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
</head>
<body>
	<h1>Albums</h1>

	<ol>
		<c:forEach items="${ albums }" var="album">
			<li><c:out value="${ album.getTitle() }" /></li>
		</c:forEach>
	</ol>
</body>
</html>