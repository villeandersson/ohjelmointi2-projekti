<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
</head>
<body>
	<h1>All artists</h1>
	
	<form method="post">
		<input name="Name" required type="text"
			placeholder=" type item here... " autofocus /> <input type="submit"
			value="Add artist" />
	</form>

	<ol>
		<c:forEach items="${ artists }" var="artist">
			<li><a href="albums?ArtistId=${ artist.getId() }"><c:out value="${ artist.getName() }" /></a></li>
		</c:forEach>
	</ol>
</body>
</html>