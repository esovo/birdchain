<template>
  <div class="mypage">
    <mynft-componenet></mynft-componenet>
    <minting-component></minting-component>
  </div>
</template>
<script>
import MintingComponent from "@/components/mypage/MintingComponent.vue";
import MynftComponenet from "@/components/mypage/MynftComponene.vue";
export default {
  name: "MypageView",
  components: {
    MynftComponenet,
    MintingComponent,
  },
};
</script>
<style>
#nav{
  background: #F4F4F4;
  padding-bottom: 5vw;
}
</style>
