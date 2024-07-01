<template>
  <div class="page-container">
    <header class="navbar">
      <img src="@/assets/img/MenuMateLogo.png" alt="MenuMate 로고" class="logo" @click="openStart">
      <h1 class="pageName" @click="openStart">
        <span class="first-m">M</span>enu <span class="second-m">M</span>ate
      </h1>
      <nav class="nav-links">
        <router-link to="/login" class="nav-item">로그인</router-link>
      </nav>
    </header>

    <router-view></router-view>

    <!-- Footer -->
    <footer class="footer">
      <div class="container">
        <div class="row">
          <div class="col-md-4">
            <img src="@/assets/img/MenuMateLogo.png" alt="MenuMate 로고" class="footer-logo">
            <h3>MenuMate</h3>
            <p>더 쉬운 주문, 더 쉬운 매출 관리</p>
          </div>
          <div class="col-md-4"></div>
          <div class="col-md-4">
            <h3>Contact Us</h3>
            <p>Email: info@menumate.com</p>
            <p>Phone: 010-1234-1234</p>
            <p>Address: 서울시 도봉구 평화로 15번길 9-21</p>
          </div>
        </div>
      </div>
    </footer>
  </div>
</template>

<script>
export default {
  name: 'Home',
  methods: {
    openStart() {
      this.$router.push('/');
    }
  }
}
</script>

<style>
/* 전체적인 레이아웃 및 컨테이너 설정 */
.page-container {
  display: flex;
  flex-direction: column;
  min-height: 100vh; /* 최소 화면 높이 */
  font-family: '명품굴림';
}
.pageName {
  cursor: pointer;
}

/* 네비게이션 바 설정 */
.navbar {
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 20px;
  width: 100%;
  background-color: white;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  box-sizing: border-box;
}

.logo {
  height: 50px;
  width: 50px;
  cursor: pointer;
}

.nav-links {
  display: flex;
  gap: 20px;
}

.nav-item {
  text-decoration: none;
  color: black;
  font-size: 1em;
  font-weight: bold;
}

.nav-item:hover {
  color: red;
}

/* M 스타일 수정 */
.first-m {
  color: red; /* 첫 번째 M 색상 */
}

.second-m {
  color: red; /* 두 번째 M 색상 */
}

/* 메인 컨텐츠 영역 설정 */
.startMenuMate {
  text-align: center;
  margin-top: 50px;
  width: 100%;
  padding: 20px;
  box-sizing: border-box;
}

h1 {
  font-size: 2.5em;
  margin: 0;
}

p {
  font-size: 1.2em;
  margin: 10px 0;
}

.btn-danger {
  /* 버튼 스타일 수정 */
  padding: 14px 28px; /* 버튼 내부 패딩 */
  font-size: 1.2em; /* 버튼 텍스트 크기 */
}

/* 푸터 설정 */
.footer {
  background-color: white;
  border-top: 1px solid #ccc;
  padding: 10px 0;
  margin: 0;
  color: #333;
  width: 100%;
}

.footer h3 {
  font-size: 15px;
}

.footer p {
  font-size: 15px;
}

.footer ul {
  list-style: none;
  padding: 0;
}

.footer ul li {
  margin-bottom: 10px;
}

.footer ul li a {
  color: #333;
  text-decoration: none;
}

.footer ul li a:hover {
  color: red;
}

.footer-logo {
  height: 70px;
  width: 70px;
}
</style>
