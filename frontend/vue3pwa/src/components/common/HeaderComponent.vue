<template>
  <div id="navbar">
    <img :src="LogoUrl" class="Logoimg" @click="this.$router.push({ name: 'main' })" />
    <div class="headerLink">
      <router-link to="/birds">멸종 위기 조류</router-link>
    </div>
    <div class="headerLink">
      <router-link to="/Donate">기부하기</router-link>
    </div>
    <div class="headerLink">
      <router-link to="/infomation">정보 공유</router-link>
    </div>
    <div class="headerLink">
      <router-link to="/mypage">마이페이지</router-link>
    </div>
    <div class="headerLink">
      <router-link to="/game">미니게임</router-link>
    </div>
    <div class="walletimg" @click="getAccount">
      <img :src="walletUrl" />
    </div>
  </div>
</template>

<script>
import { createWeb3Instance } from "@/web3";
export default {
  name: "HeaderComponent",
  data() {
    return {
      LogoUrl: require("../../assets/img/Logo.png"),
      walletUrl: require("../../assets/img/wallet.png"),
    };
  },

  methods: {
    async getAccount() {
      const web3 = await createWeb3Instance();
      if (web3) {
        const accounts = await web3.eth.getAccount();
        this.account = accounts[0];
      }
    },
  },
};
</script>

<style>
#navbar {
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  display: flex;
  flex-direction: row;
  font-size: 18;
  color: #4e4e4e;
  font-family: "IBM Plex Sans KR";
  font-style: normal;
  font-weight: 400;
  line-height: 27px;
  width: 100%;
  border-bottom: solid;
  background-color: white;
}
a {
  text-decoration: none;
  color: #4e4e4e;
}

.Logoimg {
  height: 100px;
}

.walletimg {
  flex: 1;
  display: flex;
  align-self: center;
  justify-content: flex-end;
  height: 30px;
  margin-right: 20px;
}

.headerLink {
  display: flex;
  flex-direction: row;
  margin-left: 4%;
  margin-top: 40px;
  font-family: "IBM Plex Sans KR";
  font-style: bold;
  font-weight: 400;
  font-size: 18px;
  line-height: 27px;
}

@media (max-width: 600px) {
  #navbar {
    flex-wrap: wrap;
    flex-direction: row;
    justify-content: center;
    border-bottom: solid;
  }
  .Logoimg {
    width: 80%;
  }

  .headerLink {
    display: none;
    flex-basis: 50%;
    margin-left: 4%;
    margin-top: 10px;
  }
  .walletimg img {
    display: flex;
    justify-content: flex-end;
    width: 30px;
  }
}
</style>
