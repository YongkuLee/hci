<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Castmuv</title>
    <meta name="viewport"
          content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width, height=device-height">

    <script src="http://code.jquery.com/jquery-1.10.1.min.js"
            type="text/javascript"></script>

</head>
<body>
<form name="facebook_form" action="/signin/facebook" method="POST">
    <input type="hidden" name="scope"
           value="email,publish_stream,offline_access">

    <a onclick="$(facebook_form).submit();return false;" href="#">
        <span>HCI 페이스북 로그인</span>
    </a>
</form>
</body>
</html>