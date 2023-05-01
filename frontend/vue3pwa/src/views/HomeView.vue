<template>
  <div class="backcircle">
    <div id="circle1"></div>
    <div id="circle2"></div>
    <div id="circle3"></div>
    <div id="circle4"></div>
  </div>
  <div id="home">
    <div class="mainComponent">
      <img :src="img1" />
      <div class="textfield">
        <div class="maintext">
          멸종위기에 처한<br />
          새들을 위해 기부하세요.
        </div>
        <div class="subtext">
          새는 매우 중요한 생태계의 일원입니다.<br />
          새의 멸종은 식량 연쇄 반응과 함께 <br />
          다른 동물과 식물들도 영향을 받을 수 있습니다.
        </div>
        <div>
          <v-btn @click="$router.push('/donate')"> 기부하기 </v-btn>
        </div>
      </div>
    </div>
    <div class="mainComponent">
      <div class="textfield2">
        <div class="maintext2">
          새들은 자연의 가장 아름다운 선물 중 하나입니다.
        </div>
        <div class="subtext2">
          새는 농업 및 식량 생산에 중요한 역할을 합니다.<br />
          새는 자연의 다양성을 표현하는 동물입니다.<br />
          새 보호는 우리의 삶과 건강에도 긍정적인 영향을 미칩니다.
        </div>
      </div>
      <img :src="img1" />
    </div>
    <div class="mainComponent">
      <img :src="img1" />
      <div class="textfield">
        <div class="maintext">우리는 그들을 <br />소중히 보호해야 합니다.</div>
        <div class="subtext">
          우리는 새의 멸종을 막기 위해 다양한 방법으로 새를 보호할 수
          있습니다.<br />
          예를 들어, 새의 서식지를 보호하고, 유독 물질과 오염을 줄이고,<br />
          새를 위한 먹이와 물을 제공하는 등의 노력을 기울일 수 있습니다.
        </div>
        <div class="goal">
          <div class="goaldetail">
            <div class="goaldetailtitle">우리의 목표</div>
            <div class="goaldetailtext">
              멸종위기의 새들을 보호하고<br />
              사람들의 관심을 이끄는 것입니다.
            </div>
          </div>
          <div class="goaldetail">
            <div class="goaldetailtitle">우리의 도전</div>
            <div class="goaldetailtext">
              기부한 사용자에게 NFT를 배부합니다.
            </div>
          </div>
        </div>
        <div>Donations</div>
        <v-progress-linear v-model="skill" color="blue-grey" height="25">
          <template v-slot:default="{ value }">
            <strong>{{ Math.ceil(value) }}%</strong>
          </template>
        </v-progress-linear>
        <div>Medical Help</div>
        <v-progress-linear v-model="skill" color="blue-grey" height="25">
          <template v-slot:default="{ value }">
            <strong>{{ Math.ceil(value) }}%</strong>
          </template>
        </v-progress-linear>
      </div>
    </div>
    <div class="maintext3">기부하고 NFT를 받아가세요</div>
    <div class="nftdonator">
      <swiper
        :effect="'coverflow'"
        :navigation="true"
        :grabCursor="true"
        :centeredSlides="true"
        :slidesPerView="'auto'"
        :loop="true"
        :coverflowEffect="{
          rotate: 50,
          stretch: 10,
          depth: 100,
          modifier: 1,
          slideShadows: false,
        }"
        :modules="modules"
        class="mySwiper"
      >
        <swiper-slide>
          <main-card></main-card>
        </swiper-slide>
        <swiper-slide>
          <main-card></main-card>
        </swiper-slide>
        <swiper-slide>
          <main-card></main-card>
        </swiper-slide>
        <swiper-slide>
          <main-card></main-card>
        </swiper-slide>
        <swiper-slide>
          <main-card></main-card>
        </swiper-slide>
        <swiper-slide>
          <main-card></main-card>
        </swiper-slide>
        <swiper-slide>
          <main-card></main-card>
        </swiper-slide>
      </swiper>
    </div>
  </div>
</template>

<script>
import MainCard from "@/components/home/MainCard.vue";
import { EffectCoverflow, Pagination } from "swiper";
import { Swiper, SwiperSlide } from "swiper/vue";
import { Navigation } from "swiper";
import "swiper/css";
import "swiper/css/effect-coverflow";
import "swiper/css/pagination";
import "swiper/css/navigation";
export default {
  name: "HomeView",
  components: {
    MainCard,
    Swiper,
    SwiperSlide,
  },
  setup() {
    return {
      modules: [EffectCoverflow, Pagination, Navigation],
    };
  },
  data() {
    return {
      img1: require("../assets/img/image 14.png"),
      // img2:  require("../../assets/img/wallet.png"),
      // img3:  require("../../assets/img/wallet.png")
    };
  },
};
</script>

<style>
#home {
  display: flex;
  flex-direction: column;
  margin-right: 15%;
  margin-left: 15%;
  margin-top: 10%;
}

.mainComponent {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  margin-bottom: 20%;
}

.textfield {
  display: flex;
  flex-direction: column;
  margin-left: 5vw;
}

.textfield2 {
  display: flex;
  flex-direction: column;
  margin-right: 5vw;
}

.mainComponent img {
  width: 20vw;
}

.maintext {
  font-family: "IBM Plex Sans";
  font-style: normal;
  font-weight: 600;
  font-size: 3vw;
  /* font-size: 64px; */
  text-align: right;
  text-transform: capitalize;
  color: #02100d;
}

.maintext2 {
  font-family: "IBM Plex Sans";
  font-style: normal;
  font-weight: 600;
  font-size: 3vw;
  /* font-size: 64px; */
  text-align: left;
  text-transform: capitalize;
  color: #02100d;
}

.maintext3 {
  font-family: "IBM Plex Sans", sans-serif;
  font-style: normal;
  font-weight: 600;
  font-size: 3vw;
  /* font-size: 64px; */
  text-align: left;
  text-transform: capitalize;
  color: #02100d;
}

.subtext {
  margin-top: 1rem;
  font-family: "IBM Plex Sans", sans-serif;
  font-style: normal;
  font-weight: 400;
  font-size: 1vw;
  text-align: right;
  text-transform: capitalize;
  color: #444444;
}

.subtext2 {
  margin-top: 1rem;
  font-family: "IBM Plex Sans", sans-serif;
  font-style: normal;
  font-weight: 400;
  font-size: 1vw;
  text-align: left;
  text-transform: capitalize;
  color: #444444;
}

.goal {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  text-align: center;
}

.goaldetail {
  width: 15vw;
  height: 100px;
  background-color: #f5f5f5;
}

.goaldetailtitle {
  color: #204c4c;
  font-family: "Nunito";
  font-style: normal;
  font-weight: 700;
  font-size: 1.5vw;
}

.goaldetailtext {
  margin-top: 1rem;
  font-family: "IBM Plex Sans";
  font-style: normal;
  font-weight: 400;
  font-size: 0.5vw;
  text-align: center;
  text-transform: capitalize;
  color: #555555;
}

.nftdonator {
  display: flex;
  flex-wrap: wrap;
  flex-direction: row;
  justify-content: space-between;
}

#circle1 {
  position: absolute;
  width: 55vw;
  height: 55vw;
  background-color: #f7fbf3;
  border-radius: 50%;
  left: 50%;
  top: -10%;
  z-index: -1;
}

#circle2 {
  position: absolute;
  width: 6vw;
  height: 6vw;
  background-color: #d6e8c5;
  border-radius: 50%;
  left: 20%;
  top: 100%;
  z-index: -1;
}

#circle3 {
  position: absolute;
  width: 25vw;
  height: 25vw;
  background-color: #f8f8f8;
  border-radius: 50%;
  left: 30%;
  top: 120%;
  z-index: -1;
}

#circle4 {
  position: absolute;
  width: 55vw;
  height: 55vw;
  background-color: #f7fbf3;
  border-radius: 50%;
  left: 0%;
  top: 250%;
  z-index: -1;
}

.swiper {
  width: 100%;
  padding-top: 50px;
  padding-bottom: 50px;
}

.swiper-slide {
  background-position: center;
  background-size: cover;
  width: 350px;
  height: 500px;
}

/* .swiper-slide img {
  display: block;
  width: 100%;
} */

@media (max-width: 600px) {
  #home {
    display: flex;
    flex-direction: column;
    margin-right: 5%;
    margin-left: 5%;
    margin-top: 10%;
  }
}
</style>
