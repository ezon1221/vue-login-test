import Vue from 'vue';
import Router from 'vue-router';
import Login from '@/views/Login.vue';
import Home from '@/views/Home.vue'; 

Vue.use(Router);

export default new Router({
  mode: 'history',
  routes: [
    { path: '/', redirect: '/login' }, //최초 로그인화면
    { path: '/login', name: 'LoginPage', component: Login }, //최초 로그인화면(위와 동일)
    { path: '/home', name: 'HomePage', component: Home } // 로그인 완료시
  ]
});
