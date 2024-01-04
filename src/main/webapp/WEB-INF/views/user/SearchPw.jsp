<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />

<html>
<head>
</head>
<body oncontextmenu="return false" ondragstart="return false" onselectstart="return false">
	<%@include file="../include/header.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<div class="logo">
					<img src="../resources/logo/logo.png" class="logo-detail" />
				</div>
				<div class="box-header">
					<span class="box-title">비밀번호 찾기</span>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
	<section class="content">
		<form method="post">
		<table class="search-table">
			<tr class="input-tr">
				<td class="input-title">아이디</td>
				<td class="input-info"><input type="text" name="userid" id="userid" class="searchid-box"/><br></td>
			</tr>
			<tr class="input-tr">
				<td class="input-title">생년월일</td>
				<td class="input-info"><input type="text" name="birth" id="birth" class="searchid-box"/><br></td>
			</tr>
			<tr class="input-tr">
				<td class="input-title">연락처</td>
				<td class="input-info"><input type="text" name="phone" id="phone" class="searchid-box"/><br></td>
			</tr>
		</table>
				<input type="button" value="비밀번호 찾기" id="btnSearchPw" class="login-button"/>
				<button type="button" class="search-button">로그인으로 이동</button>
				<div id="answer"></div>
		</form>

	</section>
	<br>
	<br>
	</div>
	</div>
	</div>
	<div id="answer"></div>

	<script>
		//ajax를 통한 아이디 찾기 결과 리턴 
		$(document).ready(function() {
			console.log("아이디 찾기 결과 리턴페이지");

			// 비밀번호찾기 함수 정의
			$('#btnSearchPw').click(function() {
				var userid = $("#userid").val(); // function이 실행될 때 useride값을 입력 받음
				var birth = $("#birth").val();
				var phone = $("#phone").val();
				var url = "${pageContext.request.contextPath}/user/SearchPw";
				var paramData = {
					"userid" : userid,
					"birth" : birth,
					"phone" : phone
				};
				var htmls = "";
				//$.ajax({ }); : ajax를 사용하겠다는 시작 & 기본 구조
				// 1. 주소 (url : 호출할 메소드 컨트롤러 주소)
				// 2. 변수 (data : function을 정의할 때 선언한 변수를 사용 여기선 json 타입으로 선언)
				// 3. 데이터타입 (dataType : 'text', 'json', 'xml', 'json' 등의 타입 : {"key", "data"} 
				// 4. 전송방식 (type : GET / POST)
				$.ajax({
					type : "POST",
					url : url,
					data : paramData,
					dataType : 'json',
					success : function(result) { // 사용자가 정하는 임의의 변수
						console.log(result);
						Swal.fire({
							icon : 'success',
							title : '비밀번호 찾기에 성공하였습니다!',
							text : '해당 아이디의 비밀번호는 '+result+'입니다.'
							
						})
						if (result == null) { // result값의 크기를 조건으로 댓글이 있는지 확인  / 리턴된 값이 있다 => 길이가 1보다 크다
							htmls = htmls + ("<h3>입력한 정보를 확인해주세요.</h3>");
						} else {
							htmls = htmls + "<div></div>";
						}
						$("#answer").html(htmls)
					},
					error : function(msg) {
						console.log(msg);
						Swal.fire({
							icon : 'error',
							title : '비밀번호 찾기에 실패하였습니다!',
							text : '입력된 정보를 다시 한 번 확인해주세요.'
						})
						htmls = htmls + ("<div></div>");
						$("#answer").html(htmls)
					}
				});

			});
		});
		$(function(){
			$(".search-button").click(function(){
				location.href="login"
			});
		})
	</script>
	<%@include file="../include/footer.jsp"%>

</body>
</html>
