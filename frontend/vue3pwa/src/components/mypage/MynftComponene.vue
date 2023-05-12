<template lang="">
  <div class="nftbox">
    <div id="mynfttext">
        나의 NFT
    </div>
    <div id="mynft">
      <img :src="nfturl" class="nfturl"/>
      <img :src="nfturl" class="nfturl"/>
      <img :src="nfturl" class="nfturl"/>
      <img :src="nfturl" class="nfturl"/>
    </div>
  </div>
</template>
<script>
import axios from "axios";
import { walletStore } from "@/stores/donationStore";

export default {
  setup() {
    const wStore = walletStore();
    const address = wStore.wallet;

    return {
      address,
    };
  }, 
  name: "MynftComponenet",
  data() {
    return {
      nfturl:  require("../../assets/img/nft1.png"),
    }
  },
  mounted() {    
    axios.get(`https://k8b104.p.ssafy.io/api/items?address=${this.address}`)
      .then((res) => {
        console.log("pinia에 저장된 주소 : ", this.address);
        console.log(res);
      })
  },
}
</script>
<style>
.nftbox{
  padding-right: 5vw;
  padding-left: 5vw;
  padding-top: 2vw;
  padding-bottom: 5vw;
  margin: 10vw 10vw 10vw 10vw;
  /* background-color: grey; */

}
#mynfttext{
  font-family: 'Inter';
  font-style: normal;
  font-weight: 700;
  font-size: 20px;
  display: flex;
  text-align: left;
  color: #000000;
  margin-bottom: 50px;

}
#mynft{
  display: flex;
  justify-content: space-between;
  flex-wrap: wrap;
}
.nfturl{
  width: 15vw;
}
</style>