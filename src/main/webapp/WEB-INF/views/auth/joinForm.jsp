<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가입하기 • Instagram</title>
</head>
<link rel="shortcut icon" href="/images/insta.svg">

<!-- Style -->
<link rel="stylesheet" href="/css/layout.css">
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"/>
 <link rel="stylesheet" href="/css/join__form.css">
 
<body>

	<div class="container">
		<main class="loginMain">

			<section class="login">
				<article class="join__form__container">

					<div class="join__form">
						<h1>
							<img src="/images/instagram-logo.png" alt="인스타그램">
						</h1>

						<form class="join__input" action="/auth/join" method="post">
							<input type="text" name="username" placeholder="유저네임" required="required">
							<input type="text" name="password" placeholder="패스워드" required="required">
							<input type="text" name="useremail" placeholder="이메일" required="required">
							<input type="text" name="name" placeholder="이름" required="required">
							
							<button>가입</button>
						</form>
					</div>
					
					<div class="join__register">
					<span>계정이 있으신가요?</span>
					<a href="auth/loginForm">로그인</a>
					</div>
				</article>
			</section>
		</main>
	</div>

</body>
</html>
