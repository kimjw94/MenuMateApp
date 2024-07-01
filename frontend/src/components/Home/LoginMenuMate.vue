<template>
    <div class="login-container">
      <div class="login-card">
        <h2>로그인 페이지</h2>
        <form @submit.prevent="login">
          <div class="form-group">
            <label for="username">아이디:</label>
            <input type="text" id="username" v-model="user.username" required />
          </div>
  
          <div class="form-group">
            <label for="password">비밀번호:</label>
            <input type="password" id="password" v-model="user.password" required />
          </div>
  
          <button type="submit" class="login-button">로그인</button>
        </form>
  
        <div class="signup-link">
          <span>아직 회원이 아니신가요?</span>
          <router-link to="/signup" class="nav-item">회원가입</router-link>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    name: 'LoginMenuMate',
    data() {
      return {
        user: {
          username: '',
          password: ''
        }
      }
    },
    methods: {
      login() {
        console.log('Logging in with', this.user);
        // 로그인 로직을 여기에 추가합니다.
      }
    }
  }
  </script>
  
  <style scoped>
  .login-container {
    display: flex;
    justify-content: center;
    align-items: flex-start; /* 상단으로 정렬 */
    height: 80vh; /* 높이를 줄여 상단에 더 가까이 위치하도록 조정 */
    padding-top: 200px; /* 여유 공간 추가 */
    background-color: #f0f2f5;
  }
  
  .login-card {
    background: #ffffff;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
    width: 500px;
    text-align: center;
  }
  
  .login-card h2 {
    margin-bottom: 20px;
    font-size: 24px;
    color: #333;
  }
  
  .form-group {
    margin-bottom: 15px;
    text-align: left;
  }
  
  .form-group label {
    display: block;
    margin-bottom: 5px;
    font-weight: bold;
    color: #333;
  }
  
  .form-group input {
    width: calc(100% - 20px);
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
  }
  
  .login-button {
    width: 100%;
    padding: 10px;
    border: none;
    border-radius: 5px;
    background-color: #007BFF;
    color: white;
    font-size: 16px;
    cursor: pointer;
  }
  
  .login-button:hover {
    background-color: #0056b3;
  }
  
  .signup-link {
    margin-top: 20px;
  }
  
  .signup-link span {
    margin-right: 5px;
  }
  
  .signup-link .nav-item {
    color: #007BFF;
    text-decoration: none;
  }
  
  .signup-link .nav-item:hover {
    text-decoration: underline;
  }
  </style>
