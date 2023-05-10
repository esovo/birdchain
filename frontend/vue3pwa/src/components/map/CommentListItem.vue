<template>
  <div class="flex-container">
    <div>
      <v-card-item class="d-flex">
        <v-card-title> {{ props.nickname }}</v-card-title>
        <v-card-subtitle>{{ transformDate }}</v-card-subtitle>
      </v-card-item>
      <div v-if="deleteFlag">
        <form @submit.prevent>
          <div class="flex-box">
            <div>
              <div>
                <label> <strong>비밀번호</strong></label>
                <input type="password" placeholder="비밀번호를 입력해주세요." v-model="password" class="passwordInput"/>
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
      <font-awesome-icon :icon="['fas', 'trash']" @click="showInputForm"/>
    </div>
    <div v-if="deleteFlag">
      <button type="reset" @click="showInputForm">취소</button>
      <span> | </span>
      <button type="submit" @click="doDeleteMarker">확인</button>
    </div>
  </div>
</template>
<script setup>
import { ref, defineProps, defineEmits, computed } from "vue";
import { deleteComment } from "@/api/comments";
import Swal from "sweetalert2";
import moment from 'moment';


const props = defineProps({
  comment_id: {
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
  marker_id : {
    type: Number
  }
});

const transformDate = computed(() =>
  moment(props.createdAt).format('YYYY-MM-DD HH:mm:ss')
);

const emit = defineEmits(["reloadComment"]);
const isAcceptable = ref(false);
const deleteFlag = ref(false);
const showInputForm = () => {
  deleteFlag.value = !deleteFlag.value;
  isAcceptable.value = false;
}

// 댓글 삭제
const password = ref();
const doDeleteMarker = () => {
  Swal.fire({
    title: "정말로 삭제하시겠습니까?",
    icon: "warning",
    showCancelButton: true,
    confirmButtonColor: "#3085d6",
    cancelButtonColor: "#d33",
    confirmButtonText: "승인",
    cancelButtonText: "취소",
    reverseButtons: true, // 버튼 순서 거꾸로
  }).then((result) => {
    if (result.isConfirmed) {
      const reqForm = {
        id: props.comment_id,
        nickname: props.nickname,
        password: password.value,
        markerId: props.marker_id,
      };
      deleteComment(reqForm)
        .then(({ data }) => {
          if(data.status === "OK"){
            password.value = null;
            isAcceptable.value = false;
            emit("reloadComment");

            Swal.fire({
              position: "center",
              title: "삭제되었습니다.",
              icon: "success",
            });
          }
        })
        .catch((error) => {
          Swal.fire({
            position: "center",
            title: `"${error.response.data.message}"`,
            icon: "error",
          }).then(function(){
            isAcceptable.value = true;
            password.value = null;
            setTimeout(function(){
              document.querySelector(".passwordInput").focus();
            }, 300);
          });
        })
      }
  });

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

.warnInfo {
  color: red;
  font-size: 5px;
  width: 240px;
  text-align:left;
}
</style>
