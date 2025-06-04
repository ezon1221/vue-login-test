console.log(':::::::::::::::::::::app.js 로딩 성공:::::::::::::::::::::');
//아이디와 비밀번호는 실제 개발 시 로그아웃 마이페이지등으로 사용 될 수 있으므로 전역 컴포넌트로 사용권장
// 사용자 아이디 입력 컴포넌트
Vue.component('user-id', {
  props: ['value'],
  template: `
    <div>
      <label>
        <input type="text"
               placeholder="아이디(영문과 숫자만 가능)"
               :value="value"
               @input="$emit('input', $event.target.value)">
      </label>
    </div>
  `
});

// 사용자 비밀번호 입력 컴포넌트
Vue.component('user-pw', {
  props: ['value'],
  template: `
    <div>
      <label>
        <input type="password"
               placeholder="비밀번호"
               :value="value"
               @input="$emit('input', $event.target.value)">
      </label>
    </div>
  `
});

new Vue({
  el: '#app',
  data: {
    username: '',
    password: ''
  },
  methods: {
    login() {
      console.log(":::::::::::::클릭:::::::::::::");
      console.log('::::::::::::::::::username::::::::::::::::::' + this.username);
      console.log('::::::::::::::::::password::::::::::::::::::' + this.password);

      const form = new URLSearchParams();
      form.append('username', this.username);
      form.append('password', this.password);

      axios.post('/login', form, {
    	  headers: {
    	    'Content-Type': 'application/x-www-form-urlencoded'
    	  }
    	}).then(response => {
    	  // 로그인 성공 처리
    	  if (response.status === 200 && response.data.status === 'success') {
    	    alert('로그인 성공');
    	  }
    	}).catch(error => {
    	  // 로그인 실패 처리
    	  if (error.response && error.response.data && error.response.data.message) {
    	    alert(error.response.data.message); 
    	  } else {
    	    alert('로그인 요청 중 오류가 발생했습니다.'); // 기타 예외(거의안쓰일듯)
    	  }
    	});
    }
  }
});
