<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>News</title>
    <meta name="viewport"
          content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width, height=device-height">

    <script src="http://code.jquery.com/jquery-1.10.1.min.js"
            type="text/javascript"></script>
    <link rel="stylesheet" href="/resources/blueprint/screen.css" type="text/css" media="screen, projection">
    <link rel="stylesheet" href="/resources/blueprint/print.css" type="text/css" media="print">
    <!--[if lt IE 8]>
    <link rel="stylesheet" href="/resources/blueprint/ie.css" type="text/css" media="screen, projection">
    <![endif]-->
    <link rel="stylesheet" href="/resources/blueprint/plugins/fancy-type/screen.css" type="text/css"
          media="screen, projection">
</head>
<body>
<div class="container">
    <h1>뉴스 페이지</h1>
    <hr/>
    <h2 class="alt">
        <a href="/news">전체 뉴스</a>
        <c:forEach items="${types}" var="type">
            <a href="/news/${type}">${type}</a>
        </c:forEach>
    </h2>

    <div class="span-10 prepend-1 colborder">
        <c:forEach items="${newses}" var="news">
            <p>
                <label>${news.type}</label>
                <a href="/news/${news.type}/${news.id.number}/${news.id.title}"><span>${news.id.title}</span></a>
            </p>
            <br/>
        </c:forEach>
    </div>
    <!--
    <div class="span-11 last">
        <form action="/news/add" method="post">
            <p>
                <input type="text" name="title" class="text" placeholder="Title"/>
            </p>

            <p>
                <textarea name="content" placeholder="Content"></textarea>
            </p>
            <select name="type">
                <c:forEach items="${types}" var="type">
                    <option value="${type}">${type}</option>
                </c:forEach>
            </select>
            <input type="submit" value="입력"/>
        </form>
    </div>
    -->
</div>
</body>
</html>