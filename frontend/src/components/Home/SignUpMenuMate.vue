<template lang="html">
  <div class="signup-container">
    <div class="signup-card">
      <h2>회원가입 페이지</h2>
      <form @submit.prevent="signup" method="post" class="signup-form">
        <div class="form-group" :class="{ 'has-error': !valid.userId }">
          <label>아이디:</label>
          <input type="text" v-model="user.userId" @input="validateUserId">
          <div class="error-message-container">
            <span v-if="!valid.userId" class="error-message">아이디는 필수입니다.</span>
          </div>
        </div>

        <div class="form-group" :class="{ 'has-error': !valid.userPassword }">
          <label>비밀번호:</label>
          <input type="password" v-model="user.userPassword" @input="validatePassword">
          <div class="error-message-container">
            <span v-if="!valid.userPassword" class="error-message">비밀번호는 8자 이상이어야 합니다.</span>
          </div>
        </div>

        <div class="form-group" :class="{ 'has-error': !valid.userPasswordChk }">
          <label>비밀번호 확인:</label>
          <input type="password" v-model="user.userPasswordChk" @input="validatePasswordChk">
          <div class="error-message-container">
            <span v-if="!valid.userPasswordChk" class="error-message">비밀번호가 일치하지 않습니다.</span>
          </div>
        </div>

        <div class="form-group" :class="{ 'has-error': !valid.userName }">
          <label>이름:</label>
          <input type="text" v-model="user.userName" @input="validateUserName">
          <div class="error-message-container">
            <span v-if="!valid.userName" class="error-message">이름은 필수입니다.</span>
          </div>
        </div>

        <div class="form-group">
          <label>전화번호:</label>
          <div class="phone-group">
            <select v-model="user.phoneArea">
              <option value="" disabled>지역번호</option>
              <option v-for="area in phoneAreas" :key="area" :value="area">{{ area }}</option>
            </select>
            <input type="text" v-model="user.phonePrefix" placeholder="중간 번호" maxlength="4">
            <input type="text" v-model="user.phoneLine" placeholder="마지막 번호" maxlength="4">
          </div>
        </div>

        <div class="form-group">
          <label>생년월일:</label>
          <input type="date" v-model="user.userBirthdate">
        </div>
        <hr>
        <div class="form-group">
          <label>우편번호:</label>
          <input type="text" v-model="user.postcode" readonly>
          <button type="button" @click="openAddressSearch">주소 검색</button>
        </div>

        <div class="form-group">
          <label>주소:</label>
          <input type="text" v-model="user.address" placeholder="주소" readonly>
        </div>

        <div class="form-group">
          <label>상세주소:</label>
          <input type="text" v-model="user.addressDetail" placeholder="상세 주소">
        </div>
        <hr>

        <button type="submit" class="submit-button" :disabled="!isFormValid">회원가입</button>
      </form>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'SignUpMenuMate',
  data() {
    return {
      user: {
        userId: '',
        userPassword: '',
        userPasswordChk: '',
        userName: '',
        phoneArea: '',
        phonePrefix: '',
        phoneLine: '',
        postcode: '',
        address: '',
        addressDetail: '',
        userBirthdate: ''
      },
      phoneAreas: ['010', '02', '031', '032', '033', '041', '042', '043', '044', '051', '052', '053', '054', '055', '061', '062', '063', '064'],
      valid: {
        userId: true,
        userPassword: true,
        userPasswordChk: true,
        userName: true,
      }
    };
  },
  methods: {
    validateUserId() {
      this.valid.userId = this.user.userId.trim() !== '';
    },
    validatePassword() {
      this.valid.userPassword = this.user.userPassword.length >= 8;
    },
    validatePasswordChk() {
      this.valid.userPasswordChk = this.user.userPassword === this.user.userPasswordChk;
    },
    validateUserName() {
      this.valid.userName = this.user.userName.trim() !== '';
    },
    isFormValid() {
      return Object.values(this.valid).every(value => value);
    },
    signup() {
  const completePhoneNumber = `${this.user.phoneArea}-${this.user.phonePrefix}-${this.user.phoneLine}`;
  const completeAddress = `${this.user.postcode} ${this.user.address} ${this.user.addressDetail}`;

  const signUpData = {
    userId: this.user.userId,
    userPassword: this.user.userPassword,
    userName: this.user.userName,
    phoneNumber: completePhoneNumber,
    birthdate: this.user.userBirthdate,
    address: completeAddress
  };

  axios.post('/api/signupProc', signUpData, {
    headers: {
      'Content-Type': 'application/json'
    }
  })
  .then(response => {
    console.log('회원가입 성공: ', response.data);
    alert('회원가입 성공');
    this.$router.push('/')
  })
  .catch(error => {
    console.error('회원가입 실패:', error);
  });
},
    openAddressSearch() {
      if (window.daum && window.daum.Postcode) {
        new window.daum.Postcode({
          oncomplete: (data) => {
            this.user.postcode = data.zonecode;
            this.user.address = data.roadAddress;
            this.user.addressDetail = ''; // 상세주소 초기화
          }
        }).open();
      } else {
        alert('Daum Postcode API를 로드할 수 없습니다.');
      }
    }
  },
  watch: {
    'user.userId': 'validateUserId',
    'user.userPassword': 'validatePassword',
    'user.userPasswordChk': 'validatePasswordChk',
    'user.userName': 'validateUserName'
  }
}
</script>


<style>
.signup-container {
  display: flex;
  justify-content: center;
  align-items: flex-start;
  /* 상단으로 정렬 */
  height: 80vh;
  /* 높이를 줄여 상단에 더 가까이 위치하도록 조정 */
  padding-top: 15px;
  /* 여유 공간 추가 */
  background-color: #f0f2f5;
  overflow-y: auto;
  /* 스크롤 활성화 */
}

.signup-card {
  background: #ffffff;
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
  width: 600px;
  text-align: center;
}

.signup-form {
  display: flex;
  flex-direction: column;
}

.form-group {
  display: flex;
  align-items: center;
  margin-bottom: 20px;
  position: relative;
  /* 상대적 위치 */
}

.form-group label {
  width: 120px;
  /* 라벨 너비 설정 */
  margin-right: 10px;
  /* 오른쪽 여백 추가 */
  font-weight: bold;
}

.form-group input,
.form-group select {
  flex: 1;
  /* 입력 필드와 셀렉트 박스의 너비를 균등하게 */
  padding: 8px;
  box-sizing: border-box;
  border: 1px solid #ccc;
  border-radius: 5px;
}

.form-group.has-error input {
  border-color: red;
}

.error-message-container {
  width: 100%;
  /* 전체 너비 */
  position: absolute;
  /* 절대적 위치 */
  bottom: -20px;
  /* 입력 필드 아래에 위치 */
  left: 0;
  /* 왼쪽 정렬 */
}

.error-message {
  color: red;
  font-size: 12px;
}

.phone-group {
  display: flex;
  justify-content: space-between;
  width: 100%;
}

.phone-group input {
  width: calc(32% - 5px);
  /* 여백을 고려한 너비 조정 */
}

.phone-group select {
  width: calc(32% - 5px);
  /* 여백을 고려한 너비 조정 */
  margin-right: 10px;
  /* 오른쪽 여백 추가 */
}

.submit-button {
  padding: 10px;
  border: none;
  border-radius: 5px;
  background-color: #007BFF;
  color: white;
  font-size: 16px;
  cursor: pointer;
  margin-top: 10px;
}

.submit-button:disabled {
  background-color: #cccccc;
}

.submit-button:hover {
  background-color: #0056b3;
}

.signup-form .form-group button {
  margin-left: 10px;
  padding: 8px 12px;
  border: none;
  border-radius: 5px;
  background-color: #28a745;
  color: white;
  font-size: 14px;
  cursor: pointer;
}

.signup-form .form-group button:hover {
  background-color: #218838;
}
</style>