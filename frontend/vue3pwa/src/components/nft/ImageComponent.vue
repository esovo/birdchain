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
        >
          <v-hover v-slot:default="{ hover }">
            <v-img
              :src="require('@/assets/img/NFT_ex1.png')"
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
        >
          <v-hover v-slot:default="{ hover }">
            <v-img
              :src="require('@/assets/img/NFT_ex2.png')"
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
        >
          <v-hover v-slot:default="{ hover }">
            <v-img
              :src="require('@/assets/img/NFT_ex3.png')"
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
        >
          <v-hover v-slot:default="{ hover }">
            <v-img
              :src="require('@/assets/img/NFT_ex4.png')"
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
import { ref, computed } from "vue";
export default {
  setup() {
    const hover = ref([-1, -1, -1, -1]);

    const elevation = computed(() =>
      hover.value.map((val, index) => (val === index ? 8 : 2))
    );
    const hoverClass = computed(() =>
      hover.value.map((val, index) => (val === index ? "elevation-hover" : ""))
    );
    return {
      hover,
      elevation,
      hoverClass,
    };
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
