<template>
  <div>
    <div style="margin-top: 3vw">
      <h1>코인을 기부하고 NFT를 받아가세요.</h1>
    </div>
    <div style="margin-top: 3vw">
      <h3>랜덤으로 4개의 이미지를 제공하고 하나를 선택할 수 있습니다.</h3>
    </div>
    <div style="margin-bottom: 3vw">
      <h3>아래는 받아갈 수 있는 NFT의 예시입니다.</h3>
    </div>
    <swiper ref="swiperRef" v-bind="swiperOptions" class="swiper-container">
      <swiper-slide v-for="(item, i) in items" :key="i">
        <img
          :src="item.src"
          :class="{
            'carousel-item-center': i === activeIndex,
            'center-image': i === activeIndex,
          }"
        />
      </swiper-slide>
      <div class="swiper-button-next"></div>
      <div class="swiper-button-prev"></div>
    </swiper>
  </div>
</template>

<script>
import { Swiper, SwiperSlide } from "swiper/vue";
import SwiperCore, { Navigation } from "swiper/core";
SwiperCore.use([Navigation]);
export default {
  components: {
    Swiper,
    SwiperSlide,
  },

  setup() {
    const items = [
      {
        src: require("@/assets/img/NFT1_carousel.png"),
      },
      {
        src: require("@/assets/img/NFT2_carousel.png"),
      },
      {
        src: require("@/assets/img/NFT3_carousel.png"),
      },
      {
        src: require("@/assets/img/NFT4_carousel.png"),
      },
      {
        src: require("@/assets/img/NFT5_carousel.png"),
      },
      {
        src: require("@/assets/img/NFT6_carousel.png"),
      },
    ];

    const swiperOptions = {
      loop: true,
      slidesPerView: 3,
      spaceBetween: 10,
      centeredSlides: true,
      navigation: {
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev",
      },
    };

    return {
      swiperOptions,
      items,
    };
  },
};
</script>
<style>
.swiper-slide img {
  width: 25vw;
  height: auto;
  border-radius: 50%;
}
.swiper-slide {
  display: flex;
  justify-content: center;
  align-items: center;
}
.center-image {
  width: 400px;
  height: auto;
}
</style>
