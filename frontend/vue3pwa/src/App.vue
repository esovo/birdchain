<template>
  <div id="nav">
    <HeaderComponentVue></HeaderComponentVue>
    <!-- <router-link to="/">Home</router-link> -->
    <!-- <router-link to="/about">About</router-link> -->

    <router-view />
  </div>
  <div id="footer">
    <FooterComponent></FooterComponent>
  </div>
  <div id="bottomnav">
    <BottomNavComponent></BottomNavComponent>
  </div>
</template>

<script>
import BottomNavComponent from "./components/common/BottomNavComponent.vue";
import FooterComponent from "./components/common/FooterComponent.vue";
import HeaderComponentVue from "./components/common/HeaderComponent.vue";
import { checkAccountConnection } from "@/web3";
import { useAccountStore } from "@/stores/accountStore";
export default {
  name: "App",
  components: {
    HeaderComponentVue,
    FooterComponent,
    BottomNavComponent,
  },

  setup() {
    const checkAccount = checkAccountConnection();
    const account = useAccountStore();
    if (checkAccount === false) {
      console.log("계정이 연결되어 있지 않음");
    } else {
      account.setAccount(checkAccount);
    }
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#bottomnav {
  display: none;
}

@media (max-width: 600px) {
  #footer {
    display: none;
  }
  #bottomnav {
    display: block;
  }
}
</style>
