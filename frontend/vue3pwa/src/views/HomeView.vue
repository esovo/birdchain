<template>
  <div class="backcircle">
    <div id="circle3"></div>
    <!-- <img :src="img4" id="bgbird"/> -->
    <img :src="img5" id="bgbird2"/>
    <Flybird></Flybird>
  </div>
  <div id="home">
    <div class="component1">
      <div class="mainComponent" 
        data-aos="fade-right" 
        data-aos-duration="1000" 
        data-aos-once="true">
        <img :src="img1" style="object-fit: cover"/>
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
          <div class="donatebtn"> 
            <v-btn size="x-large" @click="$router.push('/donate')" > 기부하기 </v-btn>
            <v-btn color="blue-darken-4" size="x-large" @click="$router.push('/donate')" > 보러가기 </v-btn>

          </div>
        </div>
      </div>
    </div>
    <div class="component2">
      <div class="mainComponent" 
        data-aos="fade-left" 
        data-aos-duration="1000" 
        data-aos-once="true"
      >
        <div class="textfield2">
          <div class="maintext2">
            새들은 자연의 아름다운<br/> 선물입니다.
          </div>
          <div class="subtext2">
            새는 농업 및 식량 생산에 중요한 역할을 합니다.<br />
            새는 자연의 다양성을 표현하는 동물입니다.<br />
            새 보호는 우리의 삶과 건강에도 긍정적인 영향을 미칩니다.
          </div>
        </div>
        <img :src="img2" style="object-fit: cover"/>
      </div>
    </div>
    <div class="component3">

      <div class="mainComponent"
        data-aos="fade-right" 
        data-aos-duration="1000" 
        data-aos-once="true"
      >
        <img :src="img3" style="object-fit: cover"/>

        <div class="textfield">
          <div class="maintext">우리는 그들을 <br />소중히 보호해야 합니다.</div>
          <div class="subtext">
            우리는 새의 멸종을 막기 위해 다양한 방법으로<br/> 새를 보호할 수
            있습니다.<br />
            예를 들어, 새의 서식지를 보호하고, <br/>유독 물질과 오염을 줄이고,<br />
            새를 위한 먹이와 물을 제공하는<br/> 노력을 기울일 수 있습니다.
          </div>
          <div class="goal">
            <div class="goaldetail">
              <div class="goaldetailtitle">우리의 목표</div>
              <div class="goaldetailtext">
                멸종위기의 새들을 보호하고<br />
                사람들의 관심을 얻는 것입니다.
              </div>
            </div>
            <div class="goaldetail">
              <div class="goaldetailtitle">우리의 도전</div>
              <div class="goaldetailtext">
                기부한 사용자에게<br/> NFT를 배부합니다.
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
    </div> 
    <div class="nftdonator">
      <div class="maintext3"
        data-aos="fade-left" 
        data-aos-duration="1000" 
        data-aos-once="true"
      >기부하고 NFT를 받아가세요</div>
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
        <swiper-slide v-for="product,i in products" :key="i" >
          <main-card :product="product"></main-card>
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
import AOS from 'aos';
import 'aos/dist/aos.css';
import Flybird from "@/components/common/FlyBird.vue";

export default {
  name: "HomeView",
  components: {
    MainCard,
    Swiper,
    SwiperSlide,
    Flybird
  },
  created() {
        AOS.init();
  },
  setup() {
    return {
      modules: [EffectCoverflow, Pagination, Navigation],
    };
  },
  data() {
    return {
      img1: require("../assets/img/bird5.jpg"),
      img2: require("../assets/img/bird3.jpg"),
      img3: require("../assets/img/bird4.jpg"),
      img4: require("../assets/img/bgbird1.png"),
      img5: require("../assets/img/bgbird4.png"),
      img6: require("../assets/img/bgbird5.png"),
      products : [
        {id : '0', img : require("@/assets/img/NFT1_carousel.png"), owner: "이인호", name:""},
        {id : '1', img : require("@/assets/img/NFT2_carousel.png"), owner: "김소진", name:""},
        {id : '2', img : require("@/assets/img/NFT3_carousel.png"), owner: "조은서", name:""},
        {id : '3', img : require("@/assets/img/NFT4_carousel.png"), owner: "현승민", name:""},
        {id : '4', img : require("@/assets/img/NFT5_carousel.png"), owner: "강지수", name:""},
        {id : '5', img : require("@/assets/img/NFT6_carousel.png"), owner: "남기정", name:""},
      ]
    };
  },
};
</script>

<style scoped>
#home {
  display: flex;
  flex-direction: column;

}
.component1{
  background-color: #f7fbf3;
}

.component3{
  background-color: #f7fbf3;
}
.mainComponent {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  margin-bottom: 15%;
  margin-right: 15%;
  margin-left: 15%;
  margin-top: 12%;

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
  width: 30vw;
  border-radius: 3%;
  box-shadow: 10px 10px #333
}



.maintext {
  font :700 3vw/1.1 Calibre-R,sans-serif;
  /* font-family: "IBM Plex Sans";
  font-style: normal;
  font-weight: 600;
  font-size: 3vw; */
  /* font-size: 64px; */
  text-align: right;
  text-transform: capitalize;
  color: #02100d;
}

.maintext2 {
  font :700 3vw/1.1 Calibre-R,sans-serif;
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
  font:700 1.5vw/3vw Inter,sans-serif;
  word-wrap: break-word;
  color: rgb(var(--neutral700-rgb,102,102,102));
  letter-spacing: -.03em;
  overflow: hidden;
  text-overflow: ellipsis;
  /* font-family: "IBM Plex Sans", sans-serif;
  font-style: normal;
  font-weight: 700;
  font-size: 1vw; */

  text-align: right;
  text-transform: capitalize;
  color: #444444;
}

.subtext2 {
  margin-top: 1rem;
  font:700 1.5vw/3vw Inter,sans-serif;
  word-wrap: break-word;
  color: rgb(var(--neutral700-rgb,102,102,102));
  letter-spacing: -.03em;
  overflow: hidden;
  text-overflow: ellipsis;
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
  box-shadow: 1px 1px 1px 1px grey;
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
  font-weight: 700;
  font-size: 1vw;
  text-align: center;
  text-transform: capitalize;
  color: #555555;
}

.nftdonator {
  display: flex;
  flex-wrap: wrap;
  flex-direction: row;
  justify-content: space-between;
  margin-right: 15%;
  margin-left: 15%;
  margin-top: 10%;
}

#circle1 {
  position: absolute;
  width: 55vw;
  height: 55vw;
  background-color: #eafed5;
  border-radius: 50%;
  left: 50%;
  top: -10%;
  z-index: -1;
}



#circle3 {
  position: absolute;
  width: 20vw;
  height: 20vw;
  background-color: #ff5546;
  border-radius: 50%;
  right: 10%;
  top: 100%;
  z-index: -1;
}




#bgbird{
  position: absolute;
  width: 30vw;
  right: 0px;
  /* filter: blur(2px); */
  opacity: 0.4;
}

#bgbird2{
  position: absolute;
  width: 30vw;
  top: 108%;
  right: 50px;
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

.donatebtn{
  display: flex;
  margin-top: 50px;
  margin-bottom: 50px;
  justify-content: space-around;
}

/* .swiper-slide img {
  display: block;
  width: 100%;
} */


@media (max-width: 600px) {
#home {
  display: flex;
  flex-direction: column;

}
.mainComponent {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  margin-right: 5%;
  margin-left: 5%;
  margin-top: 10%;
  margin-bottom: 5%;
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
  height: auto;
  object-fit: contain;
}

.maintext {
  font :700 5vw/1.1 Calibre-R,sans-serif;
  /* font-family: "IBM Plex Sans";
  font-style: normal;
  font-weight: 600;
  font-size: 3vw; */
  /* font-size: 64px; */
  text-align: right;
  text-transform: capitalize;
  color: #02100d;
}

.maintext2 {
  font :700 5vw/1.1 Calibre-R,sans-serif;
  /* font-size: 64px; */
  text-align: left;
  text-transform: capitalize;
  color: #02100d;
}

.maintext3 {
  font-family: "IBM Plex Sans", sans-serif;
  font-style: normal;
  font-weight: 600;
  font-size: 5vw;
  /* font-size: 64px; */
  text-align: left;
  text-transform: capitalize;
  color: #02100d;
}

.subtext {
  margin-top: 1rem;
  font:700 3vw/3vw Inter,sans-serif;
  word-wrap: break-word;
  color: rgb(var(--neutral700-rgb,102,102,102));
  letter-spacing: -.03em;
  overflow: hidden;
  text-overflow: ellipsis;
  /* font-family: "IBM Plex Sans", sans-serif;
  font-style: normal;
  font-weight: 700;
  font-size: 1vw; */

  text-align: right;
  text-transform: capitalize;
  color: #444444;
}

.subtext2 {
  margin-top: 1rem;
  font:700 3vw/3vw Inter,sans-serif;
  word-wrap: break-word;
  color: rgb(var(--neutral700-rgb,102,102,102));
  letter-spacing: -.03em;
  overflow: hidden;
  text-overflow: ellipsis;
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
  width: 30vw;
  height: 150px;
  background-color: #f5f5f5;
}

.goaldetailtitle {
  color: #204c4c;
  font-family: "Nunito";
  font-style: normal;
  font-weight: 700;
  font-size: 5vw;
}

.goaldetailtext {
  margin-top: 1rem;
  font-family: "IBM Plex Sans";
  font-style: normal;
  font-weight: 400;
  font-size: 4vw;
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


.backcircle{
  display: none;
}
}


</style>
