<template lang="">
  <DonateViewSwiper></DonateViewSwiper>
  <DonateViewDialog></DonateViewDialog>
  <router-view />
</template>

<script>
import DonateViewSwiper from "../components/donateComponent/DonateViewSwiper.vue";
import DonateViewDialog from "../components/donateComponent/DonateViewDialog.vue";
export default {
  name: "DonateView",
  components: {
    DonateViewSwiper,
    DonateViewDialog,
  },
};
</script>

<style scoped></style>
