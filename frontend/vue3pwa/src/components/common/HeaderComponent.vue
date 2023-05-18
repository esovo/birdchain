<template>
  <div id="navbar">
    <img
      :src="LogoUrl"
      class="Logoimg"
      @click="this.$router.push({ name: 'main' })"
      style="cursor: pointer"
    />
    <h1 class="headerLink">
      <router-link to="/birds">멸종 위기 조류</router-link>
    </h1>
    <h1 class="headerLink">
      <router-link to="/donate">기부하기</router-link>
    </h1>
    <h1 class="headerLink">
      <router-link to="/post">정보 공유</router-link>
    </h1>
    <h1 class="headerLink" v-if="accountStore.account">
      <router-link to="/mypage">마이페이지</router-link>
    </h1>
    <h1 class="headerLink">
      <router-link to="/game">게임</router-link>
    </h1>
  </div>
</template>

<script>
import { defineComponent, onMounted, ref } from "vue";
import { useAccountStore } from "@/stores/accountStore";

export default defineComponent({
  name: "HeaderComponent",
  setup() {
    const LogoUrl = ref(require("../../assets/img/Logo.png"));
    const accountStore = useAccountStore();

    onMounted(async () => {
      // 기존에 있는 계정 정보 가져오기
      await accountStore.getAccountAsync();

      // MetaMask 혹은 다른 Ethereum 지갑이 window.ethereum 객체를 제공하는지 확인합니다.
      if (window.ethereum) {
        // 'accountsChanged' 이벤트를 감지하고, 계정 정보를 업데이트합니다.
        window.ethereum.on("accountsChanged", async (accounts) => {
          if (accounts.length === 0) {
            accountStore.account = null;
          } else if (accounts[0] !== accountStore.account) {
            accountStore.account = accounts[0];
          }
        });
      }
    });
    return { LogoUrl, accountStore };
  },
});
</script>

<style scoped>
#navbar {
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  display: flex;
  flex-direction: row;
  font-size: 18;
  color: #4e4e4e;
  line-height: 27px;
  width: 100%;
  border-bottom: solid;
  background-color: white;
}
a {
  text-decoration: none;
  color: #473c33;
  font-weight: 700;
}

.wallettext {
  margin-top: 5px;
  font-size: 1.5vw;
  line-height: 27px;
  color: #4e4e4e;
}

.Logoimg {
  height: 100px;
  margin-left: 2vw;
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
  font-size: 1.5vw;
  line-height: 27px;
}

@media (max-width: 1200px) {
  .wallettext {
    display: none;
  }
}

@media (max-width: 600px) {
  #navbar {
    flex-wrap: wrap;
    flex-direction: row;
    justify-content: center;
    border-bottom: solid;
  }
  .Logoimg {
    width: 70%;
    margin-left: 7vw;
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
  .wallettext {
    display: none;
  }
}
</style>
