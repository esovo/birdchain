<template>
  <div class="flex-container">
    <div>
      <v-card-item class="d-flex">
        <v-card-title> {{ props.nickname }}</v-card-title>
        <v-card-subtitle>{{ props.createdAt }}</v-card-subtitle>
      </v-card-item>
      <div v-if="deleteFlag">
        <form @submit.prevent>
          <div class="flex-box">
            <div>
              <div>
                <label> <strong>비밀번호</strong></label>
                <input type="password" v-model="password" />
              </div>
              <div v-if="isAcceptable" class="warnInfo">비밀번호를 잘못 입력했습니다. 다시 입력해주세요.</div>
            </div>
          </div>
        </form>
      </div>
      <v-card-text style="max-width: 300px"> {{ props.content }}</v-card-text>
    </div>
    <div class="icons" v-if="!deleteFlag">
      <font-awesome-icon :icon="['fas', 'pen-to-square']" @click="modifyComment"/>
      <span> | </span>
      <font-awesome-icon :icon="['fas', 'trash']" @click="deleteFlag = !deleteFlag"/>
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

const modifyComment = () => {

};
</script>
<style scoped>
.flex-container {
  display: flex;
  justify-content: space-around;
}
.icons {
  margin-top: 2vw;
  cursor: pointer;
  height: 20px;
}
</style>
