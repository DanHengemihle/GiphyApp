import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Giphy from '../views/Giphy.vue'
import Detail from '../views/Detail.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
  {
    path: '/giphy',
    name: 'Giphy',
    component: Giphy
  },
  {
    path: '/giphy/:id',
    name: 'Detail',
    component: Detail
  },

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
