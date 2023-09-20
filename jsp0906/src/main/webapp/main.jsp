<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Main</title>

<!-- Meta -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<meta name="description"
	content="Portal - Bootstrap 5 Admin Dashboard Template For Developers">
<meta name="author" content="Xiaoying Riley at 3rd Wave Media">
<link rel="shortcut icon" href="favicon.ico">

<!-- FontAwesome JS-->
<script defer src="assets/plugins/fontawesome/js/all.min.js"></script>

<!-- App CSS -->
<link id="theme-style" rel="stylesheet" href="assets/css/portal.css">

</head>

<body class="app">
	<header class="app-header fixed-top">
		<div class="app-header-inner">
			<div class="container-fluid py-2">
				<div class="app-header-content">
					<div class="row justify-content-between align-items-center">

						<div class="col-auto">
							<a id="sidepanel-toggler"
								class="sidepanel-toggler d-inline-block d-xl-none" href="#">
								<svg xmlns="http://www.w3.org/2000/svg" width="30" height="30"
									viewBox="0 0 30 30" role="img">
									<title>Menu</title><path stroke="currentColor"
										stroke-linecap="round" stroke-miterlimit="10" stroke-width="2"
										d="M4 7h22M4 15h22M4 23h22"></path></svg>
							</a>
						</div>
						
						<!-- 검색 -->
						<div class="search-mobile-trigger d-sm-none col">
							<i
								class="search-mobile-trigger-icon fa-solid fa-magnifying-glass"></i>
						</div>
						<!-- 검색 input -->
						<div class="app-search-box col">
							<form class="app-search-form">
								<input type="text" placeholder="Search..." name="search"
									class="form-control search-input">
								<button type="submit" class="btn search-btn btn-primary"
									value="Search">
									<i class="fa-solid fa-magnifying-glass"></i>
								</button>
							</form>
						</div>
						<!-- 검색 끝 -->
						
						<!-- 상태 바 시작  -->
						<div class="app-utilities col-auto">
							
							<!--  회원 상태 -->							
							<div class="app-utility-item app-user-dropdown dropdown">
								<a class="dropdown-toggle" id="user-dropdown-toggle"
									data-bs-toggle="dropdown" href="#" role="button"
									aria-expanded="false"> 

									<!-- 회원 이미지 --> 
									<img src="images/12.jpg" alt="user profile">
								
								</a>

								<ul class="dropdown-menu" aria-labelledby="user-dropdown-toggle">
									<li><a class="dropdown-item" href="account.html">정보조회</a></li>
									<li><hr class="dropdown-divider"></li>
									<li><a class="dropdown-item" href="login.html">Log Out</a></li>
								</ul>
							</div>
							
						<!--  -->	
						</div>
						<!-- 상태 바 끝 -->
						
					</div>
				</div>
			</div>
		</div>
		
		
		<!--//app-header-inner-->
		<div id="app-sidepanel" class="app-sidepanel">
			<div id="sidepanel-drop" class="sidepanel-drop"></div>
			<div class="sidepanel-inner d-flex flex-column">
				<a href="#" id="sidepanel-close" class="sidepanel-close d-xl-none">&times;</a>

				<!-- 페이지명 -->
				<div class="app-branding">
					<a class="app-logo" href="main.do"><img
						class="logo-icon me-2" src="assets/images/app-logo.svg" alt="logo"><span
						class="logo-text">(주)중앙시스템</span></a>
				</div>
				
				
				<!-- 메뉴 리스트 시작 -->
				<nav id="app-nav-main" class="app-nav app-nav-main flex-grow-1">
					<ul class="app-menu list-unstyled accordion" id="menu-accordion">
						
						<!-- HOME 메뉴 시작 -->
						<li class="nav-item">
							 <a class="nav-link active" href="main.do">

								<span class="nav-icon"> <svg width="1em" height="1em"
										viewBox="0 0 16 16" class="bi bi-house-door"
										fill="currentColor" xmlns="http://www.w3.org/2000/svg">
		  <path fill-rule="evenodd"
											d="M7.646 1.146a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 .146.354v7a.5.5 0 0 1-.5.5H9.5a.5.5 0 0 1-.5-.5v-4H7v4a.5.5 0 0 1-.5.5H2a.5.5 0 0 1-.5-.5v-7a.5.5 0 0 1 .146-.354l6-6zM2.5 7.707V14H6v-4a.5.5 0 0 1 .5-.5h3a.5.5 0 0 1 .5.5v4h3.5V7.707L8 2.207l-5.5 5.5z" />
		  <path fill-rule="evenodd"
											d="M13 2.5V6l-2-2V2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5z" />
		</svg>
							</span> <span class="nav-link-text">Home</span>
						</a>
						</li>
						<!-- HOME 메뉴 끝 -->
						
									
<!-- 
						###임시메뉴 메뉴 시작 
						<li class="nav-item"><a class="nav-link" href="#">
								<span class="nav-icon">  <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-folder" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  <path d="M9.828 4a3 3 0 0 1-2.12-.879l-.83-.828A1 1 0 0 0 6.173 2H2.5a1 1 0 0 0-1 .981L1.546 4h-1L.5 3a2 2 0 0 1 2-2h3.672a2 2 0 0 1 1.414.586l.828.828A2 2 0 0 0 9.828 3v1z"/>
  <path fill-rule="evenodd" d="M13.81 4H2.19a1 1 0 0 0-.996 1.09l.637 7a1 1 0 0 0 .995.91h10.348a1 1 0 0 0 .995-.91l.637-7A1 1 0 0 0 13.81 4zM2.19 3A2 2 0 0 0 .198 5.181l.637 7A2 2 0 0 0 2.826 14h10.348a2 2 0 0 0 1.991-1.819l.637-7A2 2 0 0 0 13.81 3H2.19z"/>
</svg>
							</span> <span class="nav-link-text">### 임시메뉴</span>
						</a></li>
						임시메뉴 끝
 -->


						<!-- 회원관리 메뉴 시작-->
						<li class="nav-item has-submenu"><a
							class="nav-link submenu-toggle" href="#"
							data-bs-toggle="collapse" data-bs-target="#submenu-1"
							aria-expanded="false" aria-controls="submenu-1"> <span
								class="nav-icon">
									<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-file-person" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
	  <path fill-rule="evenodd" d="M12 1H4a1 1 0 0 0-1 1v10.755S4 11 8 11s5 1.755 5 1.755V2a1 1 0 0 0-1-1zM4 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H4z"/>
	  <path fill-rule="evenodd" d="M8 10a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
	</svg>

							</span> <!--  회원관리 대제목  --> <span class="nav-link-text">회원관리</span> <span
								class="submenu-arrow"> <svg width="1em" height="1em"
										viewBox="0 0 16 16" class="bi bi-chevron-down"
										fill="currentColor" xmlns="http://www.w3.org/2000/svg">
	  <path fill-rule="evenodd"
											d="M1.646 4.646a.5.5 0 0 1 .708 0L8 10.293l5.646-5.647a.5.5 0 0 1 .708.708l-6 6a.5.5 0 0 1-.708 0l-6-6a.5.5 0 0 1 0-.708z" />
	</svg>
							</span>



						</a> <!-- 회원관리 세부제목 -->
							<div id="submenu-1" class="collapse submenu submenu-1"
								data-bs-parent="#menu-accordion">
								<ul class="submenu-list list-unstyled">
									<li class="submenu-item"><a class="submenu-link"
										href="empList.do">회원조회</a></li>
									<li class="submenu-item"><a class="submenu-link"
										href="empForm.do">회원등록</a></li>
								</ul>
							</div></li>
					<!-- 회원 관리 메뉴 끝 -->
					
					

						<!-- 제품관리 메뉴 -->
						<li class="nav-item has-submenu"><a
							class="nav-link submenu-toggle" href="#"
							data-bs-toggle="collapse" data-bs-target="#submenu-2"
							aria-expanded="false" aria-controls="submenu-2"> <span
								class="nav-icon"> <svg width="1em" height="1em"
										viewBox="0 0 16 16" class="bi bi-columns-gap"
										fill="currentColor" xmlns="http://www.w3.org/2000/svg">
	  <path fill-rule="evenodd"
											d="M6 1H1v3h5V1zM1 0a1 1 0 0 0-1 1v3a1 1 0 0 0 1 1h5a1 1 0 0 0 1-1V1a1 1 0 0 0-1-1H1zm14 12h-5v3h5v-3zm-5-1a1 1 0 0 0-1 1v3a1 1 0 0 0 1 1h5a1 1 0 0 0 1-1v-3a1 1 0 0 0-1-1h-5zM6 8H1v7h5V8zM1 7a1 1 0 0 0-1 1v7a1 1 0 0 0 1 1h5a1 1 0 0 0 1-1V8a1 1 0 0 0-1-1H1zm14-6h-5v7h5V1zm-5-1a1 1 0 0 0-1 1v7a1 1 0 0 0 1 1h5a1 1 0 0 0 1-1V1a1 1 0 0 0-1-1h-5z" />
	</svg>
							</span>  <!-- 제품관리 대제목 --> <span class="nav-link-text">제품관리</span> <span
								class="submenu-arrow"> <svg width="1em" height="1em"
										viewBox="0 0 16 16" class="bi bi-chevron-down"
										fill="currentColor" xmlns="http://www.w3.org/2000/svg">
	  <path fill-rule="evenodd"
											d="M1.646 4.646a.5.5 0 0 1 .708 0L8 10.293l5.646-5.647a.5.5 0 0 1 .708.708l-6 6a.5.5 0 0 1-.708 0l-6-6a.5.5 0 0 1 0-.708z" />
	</svg>
							</span> 
						</a> 
							
							<!-- 제품관리 세부제목 -->
							<div id="submenu-2" class="collapse submenu submenu-2"
								data-bs-parent="#menu-accordion">
								<ul class="submenu-list list-unstyled">
									<li class="submenu-item"><a class="submenu-link"
										href="itemList.do">제품조회</a></li>
									<li class="submenu-item"><a class="submenu-link"
										href="itemForm.do">제품등록</a></li>
								</ul>
							</div></li>
						<!-- 제품관리 메뉴 끝 -->



						<!-- 주문관리 메뉴 시작  -->
						<li class="nav-item has-submenu">
						 <a class="nav-link submenu-toggle" href="#"
							data-bs-toggle="collapse" data-bs-target="#submenu-3"
							aria-expanded="false" aria-controls="submenu-3"> <span
								class="nav-icon"> <svg width="1em" height="1em"
										viewBox="0 0 16 16" class="bi bi-card-list"
										fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  <path fill-rule="evenodd"
											d="M14.5 3h-13a.5.5 0 0 0-.5.5v9a.5.5 0 0 0 .5.5h13a.5.5 0 0 0 .5-.5v-9a.5.5 0 0 0-.5-.5zm-13-1A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h13a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-13z" />
  <path fill-rule="evenodd"
											d="M5 8a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7A.5.5 0 0 1 5 8zm0-2.5a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7a.5.5 0 0 1-.5-.5zm0 5a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7a.5.5 0 0 1-.5-.5z" />
  <circle cx="3.5" cy="5.5" r=".5" />
  <circle cx="3.5" cy="8" r=".5" />
  <circle cx="3.5" cy="10.5" r=".5" />
</svg>

							</span>  <!-- 주문 관리 대제목 --> <span class="nav-link-text">주문관리</span> <span
								class="submenu-arrow"> <svg width="1em" height="1em"
										viewBox="0 0 16 16" class="bi bi-chevron-down"
										fill="currentColor" xmlns="http://www.w3.org/2000/svg">
	  <path fill-rule="evenodd"
											d="M1.646 4.646a.5.5 0 0 1 .708 0L8 10.293l5.646-5.647a.5.5 0 0 1 .708.708l-6 6a.5.5 0 0 1-.708 0l-6-6a.5.5 0 0 1 0-.708z" />
	</svg>
							</span>
						</a> 
							<!-- 주문관리 세부제목 -->
							<div id="submenu-3" class="collapse submenu submenu-3"
								data-bs-parent="#menu-accordion">
								<ul class="submenu-list list-unstyled">
									<li class="submenu-item"><a class="submenu-link"
										href="order1List.do">주문조회</a></li>
									<li class="submenu-item"><a class="submenu-link"
										href="order1Form.do">주문등록</a></li>
								</ul>
							</div>
						</li>
						<!-- 주문관리 메뉴 끝 -->

	
					<!-- 거래처 관리 메뉴 시작-->
						<li class="nav-item has-submenu"><a
							class="nav-link submenu-toggle" href="#"
							data-bs-toggle="collapse" data-bs-target="#submenu-4"
							aria-expanded="false" aria-controls="submenu-4"> <span
								class="nav-icon"> 
									<svg width="1em" height="1em" viewBox="0 0 16 16"
										class="bi bi-files" fill="currentColor"
										xmlns="http://www.w3.org/2000/svg">
	  <path fill-rule="evenodd"
											d="M4 2h7a2 2 0 0 1 2 2v10a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2zm0 1a1 1 0 0 0-1 1v10a1 1 0 0 0 1 1h7a1 1 0 0 0 1-1V4a1 1 0 0 0-1-1H4z" />
	  <path
											d="M6 0h7a2 2 0 0 1 2 2v10a2 2 0 0 1-2 2v-1a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H6a1 1 0 0 0-1 1H4a2 2 0 0 1 2-2z" />
	</svg>

							</span> <!--  거래처 관리 대제목  --> <span class="nav-link-text">거래처관리</span> <span
								class="submenu-arrow"> <svg width="1em" height="1em"
										viewBox="0 0 16 16" class="bi bi-chevron-down"
										fill="currentColor" xmlns="http://www.w3.org/2000/svg">
	  <path fill-rule="evenodd"
											d="M1.646 4.646a.5.5 0 0 1 .708 0L8 10.293l5.646-5.647a.5.5 0 0 1 .708.708l-6 6a.5.5 0 0 1-.708 0l-6-6a.5.5 0 0 1 0-.708z" />
	</svg>
							</span>


						</a> <!-- 거래처 관리 세부제목 -->
							<div id="submenu-4" class="collapse submenu submenu-4"
								data-bs-parent="#menu-accordion">
								<ul class="submenu-list list-unstyled">
									<li class="submenu-item"><a class="submenu-link"
										href="customList.do">거래처조회</a></li>
									<li class="submenu-item"><a class="submenu-link"
										href="customForm.do">거래처등록</a></li>
								</ul>
							</div></li>
					<!-- 거래처 관리 메뉴 끝 -->
	

				<!--  -->
					</ul>
				</nav>
			</div>

			<!-- 메뉴리스트 끝 -->



			<!--메뉴창 footer-->
			<div class="app-sidepanel-footer">
			
			</div>

		</div>
	</header>
	
	<!-- 메인 시작 -->
	<div class="app-wrapper">

		<div class="app-content pt-3 p-md-3 p-lg-4">
			<div class="container-xl">
				
				<!-- 메인 제목 -->
				<h1 class="app-page-title">HOME</h1>
				
				<!-- 메인 알림 창 시작 -->
				<div class="app-card alert alert-dismissible shadow-sm mb-4 border-left-decoration"
					role="alert">
					<div class="inner">
						<div class="app-card-body p-3 p-lg-4">
							<h3 class="mb-3">(주)중앙 시스템</h3>
							
							<div class="row gx-5 gy-3">
								
								<div class="col-12 col-lg-9">
									<div>(주)중앙 시스템 제품 관리 프로그램 입니다.<p> 
										회원으로 등록해주세요.</div>
								</div>

								<!-- 버튼 -->
								<div class="col-12 col-lg-3">
									<!-- 메인 알림창 버튼 -->
									<a class="btn app-btn-primary" href="empForm.do"> 회원등록 </a>
								</div>
							
							</div>
							<button type="button" class="btn-close" data-bs-dismiss="alert"
								aria-label="Close"></button>
						</div>
					</div>
				</div>
				<!-- 메인 알림 창 끝 -->


				<!-- 메인 컨텐츠 항목 시작 -->
				<div class="row g-4 mb-4">
					
					<!-- 컨텐츠 1 시작 -->
					<div class="col-6 col-lg-3">
						<div class="app-card app-card-stat shadow-sm h-100">
							<div class="app-card-body p-3 p-lg-4">
								<h4 class="stats-type mb-1">회원관리</h4>
								<div class="stats-figure">회원조회</div>
								<div class="stats-meta text-success">
								회원조회 메뉴입니다.</div>
							</div>
							<!-- 컨텐츠 1 -->
							<a class="app-card-link-mask" href="empList.do"></a>

						</div>
					</div>
					<!-- 컨텐츠 1 끝 -->
					
					<!-- 컨텐츠 2 시작 -->
					<div class="col-6 col-lg-3">
						<div class="app-card app-card-stat shadow-sm h-100">
							<div class="app-card-body p-3 p-lg-4">
								<h4 class="stats-type mb-1">제품관리</h4>
								<div class="stats-figure">제품조회</div>
								<div class="stats-meta text-success">
									제품관리 메뉴입니다.
								</div>
							</div>

							<!--컨텐츠2-->
							<a class="app-card-link-mask" href="itemList.do"></a>

						</div>
					</div>
					<!-- 컨텐츠 2 끝 -->
					
					
					<!-- 컨텐츠 3 시작-->
					<div class="col-6 col-lg-3">
						<div class="app-card app-card-stat shadow-sm h-100">
							<div class="app-card-body p-3 p-lg-4">
								<h4 class="stats-type mb-1">주문관리</h4>
								<div class="stats-figure">주문조회</div>
								<div class="stats-meta text-success">
									주문관리 메뉴입니다.
								</div>
							</div>

							<!--컨텐츠 3-->
							<a class="app-card-link-mask" href="order1List.do"></a>

						</div>
					</div>
					<!-- 컨텐츠 3 끝-->
					
					
					
					<!-- 컨텐츠 4 시작-->
					<div class="col-6 col-lg-3">
						<div class="app-card app-card-stat shadow-sm h-100">
							<div class="app-card-body p-3 p-lg-4">
								<h4 class="stats-type mb-1">거래처관리</h4>
								<div class="stats-figure">거래처조회</div>
								<div class="stats-meta text-success">
									거래처관리 메뉴입니다.
								</div>
							</div>

							<!--컨텐츠 4-->
							<a class="app-card-link-mask" href="customList.do"></a>

						</div>
					</div>
					<!-- 컨텐츠 4 끝-->
					
					
				<!--  -->	
				</div>
				<!-- 컨텐츠 항목 끝 -->
				
				
				</tbody>
			</div>
		</div>
	</div>
	<!-- 메인 끝 -->

	<!-- Javascript -->
	<script src="assets/plugins/popper.min.js"></script>
	<script src="assets/plugins/bootstrap/js/bootstrap.min.js"></script>

	<!-- Charts JS -->
	<script src="assets/plugins/chart.js/chart.min.js"></script>
	<script src="assets/js/index-charts.js"></script>

	<!-- Page Specific JS -->
	<script src="assets/js/app.js"></script>

</body>
</html>

