<template>
  <div>
    <div class="card-top">
      <div class="card-items">
        <v-card-title> {{ props.nickname }}</v-card-title>
        <v-card-subtitle>{{ transformDate }}</v-card-subtitle>
      </div>
      <div class="confirm-items">
        <div class="icons" v-if="!deleteFlag">
          <font-awesome-icon
          :icon="['fas', 'pen-to-square']"
          @click="modifyComment" />
          <span> | </span>
          <font-awesome-icon :icon="['fas', 'trash']" @click="showInputForm" />
        </div>
        <div v-if="deleteFlag" class="confirm-btns">
          <button type="reset" @click="showInputForm">취소</button>
          <span> | </span>
          <button type="submit" @click="doDeleteMarker">확인</button>
        </div>
      </div>
    </div>
    <div v-if="deleteFlag" class="password-items">
      <form @submit.prevent class="password-form">
          <label class="password-label">비밀번호</label>
          <input
            type="password"
            placeholder="비밀번호를 입력해주세요."
            v-model="password"
            class="password-input-comment" />
      </form>
      <div v-if="isAcceptable" class="warn-info">
        비밀번호를 잘못 입력했습니다. 다시 입력해주세요.
      </div>
    </div>
    <v-card-text> {{ props.content }}</v-card-text>
  </div>
</template>
<script setup>
import { ref, defineProps, defineEmits, computed } from "vue";
import { deleteComment } from "@/api/comments";
import Swal from "sweetalert2";
import moment from "moment";

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
  marker_id: {
    type: Number,
  },
});

const transformDate = computed(() =>
  moment(props.createdAt).format("YYYY-MM-DD HH:mm:ss")
);

const emit = defineEmits(["reloadComment"]);
const isAcceptable = ref(false);
const deleteFlag = ref(false);
const showInputForm = () => {
  deleteFlag.value = !deleteFlag.value;
  isAcceptable.value = false;
  password.value = null;

  if (deleteFlag.value) {
    setTimeout(function () {
      document.querySelector(".password-input-comment").focus();
    }, 10);
  }
};

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
          if (data.status === "OK") {
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
          }).then(function () {
            isAcceptable.value = true;
            password.value = null;
            setTimeout(function () {
              document.querySelector(".password-input-comment").focus();
            }, 300);
          });
        });
    }
  });
};

const modifyComment = () => {};
</script>
<style scoped>
.card-top {
  width: 380px;
  display: flex;
  justify-content: space-between;
  padding: 10px 5px 0 5px; 
}

/* .card-items {
} */

.v-card-title {
  padding-bottom: 5px;
  text-align:start; 
  max-width: 270px;
}
.v-card-subtitle {
  text-align:start; 
  padding-left: 17px;
}

.v-card-text {
  /* border-bottom: 1px solid rgb(195, 195, 195); */
  text-align:start; 
  padding: 15px 20px 25px 21px;
}

.confirm-items {
  margin-right: 10px;
  height: 25px; 
  margin-top: 10px;
}

.icons {
  cursor: pointer;
}

.confirm-btns {
  height: 20px;
}

.password-items {
  margin-top: 5px;
  margin-left: 21px; 
}

.password-form {
  display: flex;
}

.password-label {
  margin: auto 0;
}

.password-input-comment {
  margin-left: 10px;
  margin-right: 70px;
  font-size:small;
  width: 185px;
  padding: 5px;
}

.warn-info {
  color: red;
  font-size: 5px;
  padding-top: 5px;
  padding-left: 10px;
}
</style>
