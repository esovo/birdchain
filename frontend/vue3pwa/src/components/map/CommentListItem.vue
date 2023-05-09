<template>
  <div class="flex-container">
    <div>
      <v-card-item class="d-flex">
        <v-card-title> {{ props.nickname }}</v-card-title>
        <v-card-subtitle>{{ props.createdAt }}</v-card-subtitle>
      </v-card-item>
      <div v-if="deleteFlag">
        <form @submit.prevent>
          <label> <strong>비밀번호</strong></label>
          <input type="password" v-model="password" />
        </form>
      </div>
      <v-card-text style="max-width: 300px"> {{ props.content }}</v-card-text>
    </div>
    <div class="icons" v-if="!deleteFlag">
      <v-btn icon="fa:fas fa-edit" size="40" class="mr-2"> </v-btn>
      <v-btn
        :icon="`mdiSvg:${mdiDelete}`"
        size="40"
        @click="deleteFlag = !deleteFlag">
      </v-btn>
    </div>
    <div v-if="deleteFlag">
      <button type="reset" @click="deleteFlag = !deleteFlag">취소</button>
      <span> | </span>
      <button type="submit" @click="doDeleteMarker">확인</button>
    </div>
  </div>
</template>
<script setup>
import { ref, defineProps } from "vue";
import { mdiDelete } from "@mdi/js";

const props = defineProps({
  id: {
    type: Number,
  },
  nickname: {
    type: String,
  },
  content: {
    type: String,
  },
  createdAt: {
    type: String,
  },
});

// 댓글 삭제
const deleteFlag = ref(false);
const doDeleteMarker = () => {
  // 댓글 삭제 구현
};
</script>
<style scoped>
.flex-container {
  display: flex;
  justify-content: space-around;
}
.icons {
  margin-top: 1vw;
}
</style>
