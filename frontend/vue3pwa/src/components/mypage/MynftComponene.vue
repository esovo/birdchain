<template lang="">
  <div class="nftbox">
    <div id="mynfttext">나의 NFT</div>
    <div id="mynft">
      <div v-for="item in items" :key="item.name">
        <img :src="item.imageUrl" class="nfturl" />
      </div>
    </div>
  </div>
</template>
<script>
import axios from "axios";
import { walletStore } from "@/stores/donationStore";
import { ref } from "vue";

export default {
  setup() {
    const wStore = walletStore();
    const address = wStore.wallet;
    const items = ref([]);
    return {
      address,
      items,
    };
  },
  name: "MynftComponenet",
  data() {
    return {
      nfturl: require("../../assets/img/nft1.png"),
    };
  },
  mounted() {
    axios
      .get(`https://k8b104.p.ssafy.io/api/items?address=${this.address}`)
      .then((res) => {
        this.items = res.data.value;
      });
  },
};
</script>
<style>
.nftbox {
  padding-right: 5vw;
  padding-left: 5vw;
  padding-top: 2vw;
  padding-bottom: 5vw;
  margin: 10vw 10vw 10vw 10vw;
  /* background-color: grey; */
}
#mynfttext {
  font-family: "Inter";
  font-style: normal;
  font-weight: 700;
  font-size: 20px;
  display: flex;
  text-align: left;
  color: #000000;
  margin-bottom: 50px;
}
#mynft {
  display: flex;
  flex-wrap: wrap;
}
.nfturl {
  width: 15vw;
  margin-left: 20px;
}
</style>
