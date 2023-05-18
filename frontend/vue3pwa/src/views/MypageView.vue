<template>
  <div class="mypage">
    <Suspense>
      <template #default>
        <mynft-componenet v-if="web3Loaded"></mynft-componenet>
        <minting-component v-if="web3Loaded"></minting-component>
      </template>
      <template #fallback>
        <div>Loading...</div>
      </template>
    </Suspense>
  </div>
</template>
<script>
import { ref } from "vue";
import MintingComponent from "@/components/mypage/MintingComponent.vue";
import MynftComponenet from "@/components/mypage/MynftComponene.vue";
import { checkWeb3Instance } from "@/web3.js";
export default {
  name: "MypageView",
  components: {
    MynftComponenet,
    MintingComponent,
  },
  setup() {
    const web3Loaded = ref(false);
    checkWeb3Instance().then(() => {
      web3Loaded.value = true;
    });
    return { web3Loaded };
  },
};
</script>
<style></style>
