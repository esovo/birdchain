<template lang="">
  <DonateViewSwiper></DonateViewSwiper>
  <DonateViewPage></DonateViewPage>
  <router-view />
</template>

<script>
import DonateViewSwiper from "../components/donateComponent/DonateViewSwiper.vue";
import DonateViewPage from "../components/donateComponent/DonateViewDialog.vue";
export default {
  name: "DonateView",
  components: {
    DonateViewSwiper,
    DonateViewPage,
  },
};
</script>

<style scoped></style>
