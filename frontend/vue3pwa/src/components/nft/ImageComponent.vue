<template lang="">
  <div style="margin-top: 30px; margin-bottom: 30px">
    <h1>기부가 완료되었습니다.</h1>
    <h1>4개의 그림 중 원하는 그림을 선택하세요!</h1>
  </div>
  <v-container>
    <v-row>
      <!-- 첫 번째 열 -->
      <v-col cols="12" sm="6" md="6">
        <v-card
          :elevation="elevation[0]"
          :class="hoverClass[0]"
          @mouseover="hover[0] = 0"
          @mouseleave="hover[0] = -1"
          @click="createNFT(imgA)"
        >
          <v-hover v-slot:default="{ hover }">
            <v-img
              :src=imgA
              :class="hover ? 'blur-image' : ''"
            ></v-img>
          </v-hover>
          <v-card-title v-if="hover[0] === 0" class="overlay">
            첫 번째 이미지 설명
          </v-card-title>
        </v-card>
      </v-col>

      <!-- 두 번째 열 -->
      <v-col cols="12" sm="6" md="6">
        <v-card
          :elevation="elevation[1]"
          :class="hoverClass[1]"
          @mouseover="hover[1] = 1"
          @mouseleave="hover[1] = -1"
          @click="createNFT(imgB)"
        >
          <v-hover v-slot:default="{ hover }">
            <v-img
              :src=imgB
              :class="hover ? 'blur-image' : ''"
            ></v-img>
          </v-hover>
          <v-card-title v-if="hover[1] === 1" class="overlay">
            두 번째 이미지 설명
          </v-card-title>
        </v-card>
      </v-col>
    </v-row>

    <v-row>
      <!-- 세 번째 열 -->
      <v-col cols="12" sm="6" md="6">
        <v-card
          :elevation="elevation[2]"
          :class="hoverClass[2]"
          @mouseover="hover[2] = 2"
          @mouseleave="hover[2] = -1"
          @click="createNFT(imgC)"
        >
          <v-hover v-slot:default="{ hover }">
            <v-img
              :src=imgC
              :class="hover ? 'blur-image' : ''"
            ></v-img>
          </v-hover>
          <v-card-title v-if="hover[2] === 2" class="overlay">
            세 번째 이미지 설명
          </v-card-title>
        </v-card>
      </v-col>

      <!-- 네 번째 열 -->
      <v-col cols="12" sm="6" md="6">
        <v-card
          :elevation="elevation[3]"
          :class="hoverClass[3]"
          @mouseover="hover[3] = 3"
          @mouseleave="hover[3] = -1"
          @click="createNFT(imgD)"
        >
          <v-hover v-slot:default="{ hover }">
            <v-img
              :src=imgD
              :class="hover ? 'blur-image' : ''"
            ></v-img>
          </v-hover>
          <v-card-title v-if="hover[3] === 3" class="overlay">
            네 번째 이미지 설명
          </v-card-title>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>
<script>
import axios from "axios";
import { ref, computed } from "vue";
import { createWeb3Instance } from "@/web3";
import NFTAbi from "../../abi/BirdNFT.json";
import router from "@/router";
export default {
  setup() {
    const itemName = [
      'Aquila chrysaetos', 
      'Eurynorhynchus pygmeus', 
      'Egretta eulophotes', 
      'Grus japonensis', 
      'Falco peregrinus', 
      'Ciconia nigra', 
      'Platalea minor', 
      'Haliaeetus pelagicus', 
      'Tringa guttifer', 
      'Dryocopus javensis', 
      'Mergus squamatus', 
      'Cygnus olor', 
      'Ciconia boyciana', 
      'Haliaeetus albicilla', 
      'Anser cygnoides', 
      'Larus saundersi', 
      'Haematopus ostralegus', 
      'Emberiza aureola', 
      'Grus grus', 
      'Cygnus columbianus', 
      'Larus relictus', 
      'Terpsiphone atrocaudata', 
      'Strix uralensis', 
      'Dryocopus martius', 
      'Platalea leucorodia', 
      'Otis tarda', 
      'Aegypius monachus', 
      'Nipponia nippon -> Crested ibis',
      'Gallicrex cinerea -> Watercock',
      'Emberiza sulphurata -> Yellow bunting',
      'Pandion haliaetus -> Osprey',
      'Pernis ptilorhynchus -> Crested honey buzzard',
      'Accipiter soloensis', 
      'Calidris tenuirostris', 
      'Gorsachius goisagi', 
      'Synthliboramphus wumizusume -> Japanese murrelet',
      'Galerida cristata', 
      'Accipiter nisus', 
      'Falco subbuteo', 
      'Locustella pleskei', 
      'Milvus migrans', 
      'Emberiza yessoensis', 
      'Bubo bubo', 
      'Circus melanoleucos', 
      'Numenius madagascariensis',
      'Columba rupestris', 
      'Strix aluco', 
      'Grus vipio', 
      'Circus cyaneus', 
      'Accipiter gularis', 
      'Accipiter gentilis', 
      'Cygnus cygnus', 
      'Anser fabalis', 
      'Ixobrychus eurhythmus', 
      'Buteo hemilasius', 
      'Pitta nympha', 
      'Aquila clanga', 
      'Branta bernicla', 
      'Grus monacha', 
      'Columba janthina', 
      'Charadrius placidus',
      'Anser erythropus', 
      'Aquila heliaca', 
    ];

    const level = [
      'RE',
      'CR',
      'EN',
      'VU',
      'NT',
      'LC',
    ];

    const hover = ref([-1, -1, -1, -1]);

    const NFTNum = ref("");

    const imgA = ref("");

    const imgB = ref("");

    const imgC = ref("");

    const imgD = ref("");

    const account = ref("");

    const elevation = computed(() =>
      hover.value.map((val, index) => (val === index ? 8 : 2))
    );
    const hoverClass = computed(() =>
      hover.value.map((val, index) => (val === index ? "elevation-hover" : ""))
    );

    const createNFT = async (imgURI) => {

      const web3 = await createWeb3Instance();

      if (web3) {
        const accounts = await web3.eth.getAccounts();
        account.value = accounts[0];
      }
      const NFT = new web3.eth.Contract(NFTAbi.abi, "0xDd253a06eAc4264Cc0E25AA2e3701EFDA59b2bBB");
      await NFT.methods.createNFT(account.value, imgURI).send({
        from: account.value
      }).then(() => {
        console.log("NFT 발급 완료");
        router.push('/mypage');
      })

    };

    return {
      hover,
      elevation,
      hoverClass,
      NFTNum,
      imgA,
      imgB,
      imgC,
      imgD,
      account,
      itemName,
      level,
      createNFT,
    };
  },

  mounted() {
    // axios.get(`http://localhost:8080/api/nft/available`)
    axios.get(`https://k8b104.p.ssafy.io/api/nft/available`)
      .then((res) => {
        const NFTNum = res.data.value.toString().padStart(3, '0');
        const imageNames = ['A', 'B', 'C', 'D'];
        // const imageRequests = imageNames.map(name => axios.get(`http://localhost:8080/api/nft/images?fileName=${NFTNum}${name}`));
        const imageRequests = imageNames.map(name => axios.get(`https://k8b104.p.ssafy.io/api/nft/images?fileName=${NFTNum}${name}`));

        axios.all(imageRequests)
          .then(axios.spread((...responses) => {
            this.imgA = responses[0].data.value;
            this.imgB = responses[1].data.value;
            this.imgC = responses[2].data.value;
            this.imgD = responses[3].data.value;
          }))
          .catch(error => {
            console.log(error);
          });
      })
      .catch(error => {
        console.log(error);
      });
  },

};
</script>
<style scoped>
.img-div {
  display: flex;
  flex-direction: column;
}
img {
  width: 300px;
  height: 300px;
  margin-right: 10px;
  margin-bottom: 10px;
}

.blur-image {
  filter: blur(3px);
}

.overlay {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  background: rgba(0, 0, 0, 0.5);
  color: white;
  font-weight: bold;
}

.elevation-hover {
  transition: transform 0.3s;
  transform: translateY(-5px);
}
</style>
