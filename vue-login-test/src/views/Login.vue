<template>
  <div class="wrap">
    <div class="login_form">
      <h3>로그인 해주세요.</h3>
      <UserId v-model="username" />
      <UserPw v-model="password" />
      <button @click="login">로그인</button>
    </div>
  </div>
</template>

<script>
import UserId from '@/components/UserId.vue'
import UserPw from '@/components/UserPw.vue'
import axios from 'axios'

export default {
    name : 'LoginPage',
    components: { UserId, UserPw },
  data() {
    return {
      username: '',
      password: ''
    }
  },
  methods: {
    login() {
      const form = new URLSearchParams()
      form.append('username', this.username)
      form.append('password', this.password)

      axios.post('/login', form, {
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
      }).then(() => {
        alert('로그인 성공')
      }).catch(error => {
        if (error.response && error.response.data) {
          alert(error.response.data.message)
        } else {
          alert('로그인 실패')
        }
      })
    }
  }
}
</script>

<style scoped>
.wrap {
  position: relative;
  height: 100vh;
  letter-spacing: -0.5px;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: #f9f9f9;
}

.login_form {
  width: 300px;
  padding: 40px;
  border: 1px solid #ccc;
  border-radius: 6px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  background-color: white;
}

.login_form h3 {
  margin-bottom: 20px;
  font-size: 20px;
  text-align: center;
}

.login_form input {
  width: 100%;
  padding: 15px;
  margin-bottom: 12px;
  box-sizing: border-box;
  border: 1px solid #ccc;
  border-radius: 4px;
}

.login_form button {
  width: 100%;
  padding: 10px;
  background-color: #6482ff;
  border: none;
  color: white;
  font-weight: bold;
  cursor: pointer;
  border-radius: 4px;
}

.login_form button:hover {
  background-color: #3232ff;
}
</style>

