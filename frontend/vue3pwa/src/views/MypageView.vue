<template>
  <div class="mypage">
    <mynft-componenet></mynft-componenet>
    <minting-component></minting-component>
  </div>
</template>
<script>
import MintingComponent from "@/components/mypage/MintingComponent.vue";
import MynftComponenet from "@/components/mypage/MynftComponene.vue";
import mydata from "../assets/json/mydatadummy.json";
import { reactive } from "vue";
export default {
  name: "MypageView",
  components: {
    MynftComponenet,
    MintingComponent,
  },
  setup() {
    const state = reactive({
      mydata,
    });

    return {
      state,
    };
  },
};
</script>
<style>
#nav{
  background: #F4F4F4;
  padding-bottom: 5vw;
}
</style>
