<template>
  <div class="mypage">
    <mynft-componenet></mynft-componenet>

    <minting-component></minting-component>
  </div>
</template>
<script>
import MintingComponent from "@/components/mypage/MintingComponent.vue";
import MynftComponenet from "@/components/mypage/MynftComponene.vue";
import { createWeb3Instance } from "@/web3.js";
export default {
  name: "MypageView",
  components: {
    MynftComponenet,
    MintingComponent,
  },

  beforeMount() {
    createWeb3Instance();
  },
};
</script>
<style></style>
