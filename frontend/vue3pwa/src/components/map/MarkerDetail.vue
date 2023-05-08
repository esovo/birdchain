<template>
  <v-card width="400" height="600">
    <div class="flex-container">
      <v-card-title class="mr-14"> {{ detailData.nickname }} </v-card-title>
      <div>
        <v-btn icon="fa:fas fa-edit" size="40" class="mr-2"> </v-btn>
        <v-btn :icon="`mdiSvg:${mdiDelete}`" size="40" class="mr-2" @click="deleteMarker"> </v-btn>
      </div>
    </div>
    <v-img
      :src="detailData.image"
      height="300px"
      cover
      class="my-4"></v-img>

    <v-card-text class="d-flex align-start flex-column ml-3">
      <div v-if="deleteFlag">
        <form @submit.prevent>
        <label>비밀번호</label>
        <input type="password" />
      </form>
      </div>
      <div>
        <span> <strong>위치</strong></span>
        <span>{{ detailData.location }}</span>
      </div>
      <div>
        <span><strong>내용</strong></span>
        <span>{{ detailData.content }}</span>
      </div>
    </v-card-text>
  </v-card>
</template>

<script setup>
import { ref, defineProps, watch } from "vue";
import { mdiDelete } from "@mdi/js";
import { getMarkerDetail } from "@/api/markers";

// 마커 상세 조회
const props = defineProps({
  marker_id: {
    type: Number,
  },
});

const detailData = ref({
  nickname: null,
  image: null,
  type: null,
  location: null,
  content: null,
  createdAt: null,
});

const fetchMarker = () => {
	getMarkerDetail(String(props.marker_id)).then(({ data }) => {
    if (data.status === 'OK') {
      detailData.value.nickname = data.value.nickname;
      detailData.value.image = data.value.image;
      detailData.value.type = data.value.type;
      detailData.value.location = data.value.location;
      detailData.value.content = data.value.content;
      detailData.value.createdAt = data.value.createdAt;
    }
  });
};
fetchMarker(1);

watch(
  () => props.marker_id,
  (newValue, oldValue) => {
    if (newValue !== oldValue) {
      fetchMarker();
    }
  }
);

// 마커 삭제
const deleteFlag = ref(false);

const deleteMarker = () => {
  deleteFlag.value = !deleteFlag.value;
}
</script>

<style scoped>
.flex-container {
  display: flex;
  justify-content: flex-end;
  margin: 10px 0;
}
</style>
