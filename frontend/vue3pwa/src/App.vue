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
import DonationAbi from "./abi/Donation.json";
import { checkWeb3Instance } from "@/web3";
import { ref, onMounted, getCurrentInstance } from "vue";

export default {
  name: "App",
  components: {
    HeaderComponentVue,
    FooterComponent,
    BottomNavComponent,
  },

  setup() {
    const eventData = ref(null);
    const checkAccount = checkAccountConnection();
    const account = useAccountStore();
    const instance = getCurrentInstance();

    if (checkAccount === false) {
      console.log("계정이 연결되어 있지 않음");
    } else {
      account.setAccount(checkAccount);
    }

    const showNotification = (message) => {
      console.log(message);
      // Assuming $toast is available in your Vue instance
      instance.proxy.$toast.info(message);
      setTimeout(instance.proxy.$toast.clear, 3000);
    };

    const showLog = async () => {
      const web3 = await checkWeb3Instance();

      const Donation = new web3.eth.Contract(
        DonationAbi,
        "0x1678A184F4DEd0e15dd589fD98b8a87194c2412d"
      );

      // 이벤트 감시
      await Donation.events
        .DonationReceived()
        .on("data", (event) => {
          // 이벤트가 변경되면 알림을 표시
          var amount = web3.utils.fromWei(event.returnValues[1], "ether");
          showNotification(
            event.returnValues[0] +
              "계정에서 " +
              amount +
              "ETH를 기부하셨습니다."
          );
          eventData.value = event;
          console.log(event);
        })
        .on("error", (error) => {
          console.error("이벤트 감시 중 오류 발생:", error);
        });
    };

    onMounted(showLog);

    return {
      eventData,
      showNotification,
    };
  },
};
</script>

<style>
#app {
  /* font-family: 'The Jamsil 4 Medium'; */
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

h1, h2, h3, h4, h5, h6, v-btn {
  font-family: 'Cafe24Ssurround';
}
div {
  font-family: 'GyeonggiTitleM';
  font-weight: 100;
}
@media (max-width: 600px) {
  h1, h2, h3, h4, h5, h6, v-btn {
  font-family: 'Cafe24Ssurround';
}
div {
  font-family: 'GyeonggiTitleM';
}
}
</style>
