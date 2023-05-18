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
            TXID
          </th>
          <th class="text-left">
            IUCN
          </th>
        </tr>
      </thead>
      <tbody>
        <tr
          v-for="item in items"
          :key="item.name"
        >
          <td class="text-left" id="nftid"><img :src=item.imageUrl id="nftimg" /> <div>{{ item.name }}</div></td>
          <td class="text-left">{{item.amount}}</td>
          <td class="text-left" id="txid">{{ item.txid }}</td>
          <td class="text-left">
            {{item.iucn}}
            <!-- <v-rating
              v-model="item.rating"
              bg-color="orange-lighten-1"
              color="#FFA800"
              size="small"
              density="compact"
              readonly
            ></v-rating> -->
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
        items: [
        ],
        img1: require("../../assets/img/image 14.png"),
      }
  },
  mounted() {    
    axios.get(`https://k8b104.p.ssafy.io/api/items?address=${this.address}`)
      .then((res) => {
        console.log(res);
        this.items=res.data.value;
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