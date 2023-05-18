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
        console.log(res.data.value);
        this.items = res.data.value;
      });
  },
};
</script>
<style>
.nftbox {
  padding-right: 5vw;
  padding-left: 3vw;
  padding-top: 2vw;
  padding-bottom: 5vw;
  margin: 5vw 5vw 4vw 5vw;
  background: white;
}
#mynfttext {
  font-family: "Inter";
  font-style: normal;
  font-weight: 700;
  font-size: 20px;
  display: flex;
  text-align: left;
  color: #000000;
  margin-bottom: 35px;
}
#mynft {
  display: flex;
  flex-wrap: wrap;
}
.nfturl {
  width: 15vw;
  margin-right: 20px;
  border-radius: 10%;
}
</style>
