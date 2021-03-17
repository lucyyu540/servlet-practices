<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSTL foreach tag test</h1>

<c:set var="count" value='${fn:length(list) }'/>

<c:forEach items='${list}' var='vo' varStatus='status'>
	[${status.index}: ${status.count}] ${vo.name}<br/>
</c:forEach>

<strong>${fn:length(list) }</strong>

<table border='1' cellspacing ='0'>
	<c:forEach begin="0" end="${param.r-1 }" var="i"step="1">
		<tr>
			<c:forEach begin="0" end="${param.c-1 }" var="k"step="1">
				<td>( ${i}, ${j})</td>
			</c:forEach>
		</tr>
	</c:forEach>



</table>

</body>
</html>