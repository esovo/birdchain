<template>
  <div id="nav">
    <HeaderComponentVue></HeaderComponentVue>
      <!-- <router-link to="/">Home</router-link> -->
      <!-- <router-link to="/about">About</router-link> -->
  </div>
  <router-view />
</template>

<script>
import HeaderComponentVue from './components/common/HeaderComponent.vue';
export default {
  name: 'App',
  components: {
    HeaderComponentVue
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
