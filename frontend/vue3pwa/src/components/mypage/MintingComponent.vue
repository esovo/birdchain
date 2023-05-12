<template lang="">
  <div class="mintingbox">
    <div id="mynfttext">
        나의 NFT 정보
    </div>
    <v-table
      fixed-header
      height="300px"
    >
      <thead>
        <tr>
          <th class="text-left">
            NFT
          </th>
          <th class="text-left">
            Value
          </th>
          <th class="text-left">
            Transaction Fee
          </th>
          <th class="text-left">
            TXID
          </th>
          <th class="text-left">
            RATING
          </th>
        </tr>
      </thead>
      <tbody>
        <tr
          v-for="item in desserts"
          :key="item.name"
        >
          <td class="text-left" id="nftid"><img :src="img1" id="nftimg" /> <div>{{ item.nft }}</div></td>
          <td class="text-left">{{ item.value }}</td>
          <td class="text-left">{{ item.transactionfee }}</td>
          <td class="text-left" id="txid">{{ item.txid }}</td>
          <td class="text-left">
            <v-rating
              v-model="item.rating"
              bg-color="orange-lighten-1"
              color="#FFA800"
              size="small"
              density="compact"
            ></v-rating>
            <!-- {{ item.rating }} -->
          </td>
        </tr>
      </tbody>
    </v-table>
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
  
  name: "MintingComponent",
  data () {
      return {
        desserts: [
          {
            nft: 'Cute Bird',
            value: "0.1 ETH",
            transactionfee: "0.005ETH",
            txid: "0xbe10d07e279ddecc33e9b48ff3c04320886604f49cc72f7a08269735cf25864e",
            rating:3
          }
        ],
        img1: require("../../assets/img/image 14.png"),

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
.mintingbox{
  padding-right: 5vw;
  padding-left: 5vw;
  padding-top: 2vw;
  padding-bottom: 5vw;
  margin: 0vw 10vw 10vw 10vw;
  /* background-color: grey; */
}
#txid{
  width: 20%;
}

#nftid{
  display: flex;
  flex-direction: row;
  margin-top: 10px;
}
#nftimg{
  margin-right: 10px;
 
  width: 50px;
  height: 50px;
}
</style>