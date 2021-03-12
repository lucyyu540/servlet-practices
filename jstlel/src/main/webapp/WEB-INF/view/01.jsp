<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>retrieve values</h1>
${iVal}<br/>
${lVal}<br/>
${fVal}<br/>
${bVal}<br/>
${sVal}<br/>
<h1>object</h1>
${o.name}<br/><br/>
<h1>arithm</h1>
${3*10+5} <br/><br/>
<h1>bool</h1>
${obj == null} <br/>
${empty obj } <br/>
${not empty obj } <br/>
${param}<br/>
${param.email}<br/><br/>
<h1>map</h1>
${map.ival}<br/>
${map.lval}<br/>
${map.bval}<br/>
${map.sval}<br/>
${map.fval}<br/>

</body>
</html>