<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${result > 0 }">
	<script type="text/javascript">
		alert("주문 등록 완료");
		location.href="order1List.do";
	</script>
</c:if>

<c:if test="${result == 0 }">
	<script type="text/javascript">
		alert("오류 : 다시 입력해주세요");
		location.href="order1Form.do";
	</script>

</c:if>

</body>
</html>