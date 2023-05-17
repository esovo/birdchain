<template>
  <div class="donateswiper">
    <div class="donatetitle">
      <h1>코인을 기부하고 NFT를 받아가세요.</h1>
    </div>
    <div class="donatesubtitle1">
      <div>랜덤으로 4개의 이미지를 제공하고 하나를 선택할 수 있습니다.</div>
    </div>
    <div class="donatesubtitle2">
      <div>아래는 받아갈 수 있는 NFT의 예시입니다.</div>
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
    <div class="donatetotalcash">
      <div>총 기부 금액</div>
      <div class="total">{{ totalValue }}ETH</div>
    </div>
  </div>
</template>

<script>
import { Swiper, SwiperSlide } from "swiper/vue";
import SwiperCore, { Navigation } from "swiper/core";
import { ref } from "vue";
import { createWeb3Instance } from "@/web3";
import DonationAbi from "../../abi/Donation.json";
import { onMounted } from "vue";
// import { useStore } from "@/stores/store";
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

    // const store = useStore();
    // const initValue = computed(() => store.getters.getTotalValue);
    let totalValue = ref(0);
    const watchTotalValue = async () => {
      const web3 = await createWeb3Instance();

      const Donation = new web3.eth.Contract(
        DonationAbi,
        "0x1678A184F4DEd0e15dd589fD98b8a87194c2412d",
      );
      await Donation.methods.getTotalContribution().call().then(function(value) {
        const total = web3.utils.fromWei(value, 'ether');
        totalValue.value = total;
        console.log("값이 " + value)
      });

      // 이벤트 감시
      await Donation.events
        .DonationReceived()
        .on("data", () => {
          // 이벤트가 변경되면 알림을 표시
          watchTotalValue();
        })
        .on("error", (error) => {
          console.error("이벤트 감시 중 오류 발생:", error);
        });
    };

    onMounted(watchTotalValue);

    return {
      swiperOptions,
      items,
      totalValue,
      watchTotalValue,
    };
  },
};
</script>
<style>
.donateswiper {
  margin-left: 5%;
  margin-right: 5%;
}

.donatetitle {
  margin-top: 3vw;
  font-size: 1.5vw;
}

.donatesubtitle1 {
  margin-top: 3vw;
  font-size: 1.5vw;
}

.donatesubtitle2 {
  margin-bottom: 2vw;
  font-size: 1.5vw;
}

.donatetotalcash {
  margin-top: 80px;
  font-size: 1.5vw;
}

.swiper-slide img {
  width: 20vw;
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
