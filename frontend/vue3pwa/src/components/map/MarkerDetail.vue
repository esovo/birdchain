<template>
  <v-card class="my-card-marker" @wheel.prevent="onWheel">
    <div class="my-card-container">
      <div class="top-container">
        <div>
          <v-card-title> {{ detailData.nickname }} </v-card-title>
          <v-card-subtitle>{{ transformDateMarker }}</v-card-subtitle>
        </div>
        <div v-if="!deleteFlagMarker && !modifyFlagMarker" class="icons">
          <font-awesome-icon
            :icon="['fas', 'pen-to-square']"
            @click="showModifyInputMarker" />
          <span> | </span>
          <font-awesome-icon :icon="['fas', 'trash']" @click="showInputForm" />
        </div>
        <div v-if="deleteFlagMarker" class="confirm-btn">
          <button type="reset" @click="showInputForm">취소</button>
          <span> | </span>
          <button type="submit" @click="doDeleteMarker">확인</button>
        </div>
        <div v-if="modifyFlagMarker">
          <button type="reset" @click="showModifyInputMarker">취소</button>
          <span> | </span>
          <button type="submit" @click="doModifyMarker">수정</button>
        </div>
      </div>
      <v-img :src="detailData.image" height="300px" cover class="my-4"></v-img>
      <v-card-text class="d-flex align-start flex-column ml-3">
        <div class="list-item">
          <p><strong>위치</strong></p>
          <p>{{ detailData.location }}</p>
        </div>
        <div class="list-item">
          <p><strong>유형</strong></p>
          <p>{{ detailData.type }}</p>
        </div>
        <div class="list-item">
          <p><strong>내용</strong></p>
          <p v-if="!modifyFlagMarker">{{ detailData.content }}</p>
          <form
            @submit.prevent
            v-if="modifyFlagMarker"
            class="modify-form-marker">
            <textarea
              id="content"
              v-model="modiContentMarker"
              class="modify-input-marker"></textarea>
          </form>
        </div>
        <div v-if="deleteFlagMarker || modifyFlagMarker">
          <form @submit.prevent class="password-form">
            <label class="password-label">
              <strong>비밀<br />번호</strong></label
            >
            <input
              type="password"
              placeholder="비밀번호를 입력해주세요."
              v-model="password"
              class="password-input-marker"
              autoComplete="off" />
          </form>
          <span v-if="isAcceptable" class="warn-info">
            비밀번호를 잘못 입력했습니다. 다시 입력해주세요.
          </span>
        </div>
      </v-card-text>
    </div>
  </v-card>
</template>

<script setup>
import { ref, defineProps, watch, defineEmits, computed } from "vue";
import { getMarkerDetail, deleteMarker, modifyMarker } from "@/api/markers";
import moment from "moment";
import Swal from "sweetalert2";

// 마커 상세 조회
const props = defineProps({
  marker_id: {
    type: Number,
  },
});

const emit = defineEmits(["reloadMarker", "notValid"]);

const detailData = ref({
  id: null,
  nickname: null,
  image: null,
  type: null,
  location: null,
  content: null,
  createdAt: null,
});

const transformDateMarker = computed(() =>
  moment(detailData.value.createdAt).format("YYYY-MM-DD HH:mm:ss")
);

const onWheel = (event) => {
  event.preventDefault();
  const container = event.currentTarget.querySelector(".my-card-container");
  console.log(container.scrollTop);
  container.scrollTop += event.deltaY;
};

const fetchMarker = () => {
  getMarkerDetail(String(props.marker_id)).then(({ data }) => {
    if (data.status === "OK") {
      detailData.value.id = data.value.id;
      detailData.value.nickname = data.value.nickname;
      detailData.value.image = data.value.image;
      detailData.value.type = data.value.type;
      detailData.value.location = data.value.location;
      detailData.value.content = data.value.content;
      detailData.value.createdAt = data.value.createdAt;
    }
  });
};

fetchMarker();
watch(
  () => props.marker_id,
  (newValue, oldValue) => {
    if (newValue !== oldValue) {
      fetchMarker();
    }
  }
);

const deleteFlagMarker = ref(false);
const isAcceptable = ref(false);
const showInputForm = () => {
  deleteFlagMarker.value = !deleteFlagMarker.value;
  isAcceptable.value = false;
  password.value = null;

  if (deleteFlagMarker.value) {
    setTimeout(function () {
      document.querySelector(".password-input-marker").focus();
    }, 10);
  }
};

// <마커 수정>
const modiContentMarker = ref("");
const modifyFlagMarker = ref(false);

const showModifyInputMarker = () => {
  modifyFlagMarker.value = !modifyFlagMarker.value;
  modiContentMarker.value = detailData.value.content;

  if (modifyFlagMarker.value) {
    setTimeout(function () {
      document.querySelector(".modify-input-marker").focus();
    }, 10);
  }
};

const doModifyMarker = () => {
  modifyFlagMarker.value = true;

  const reqForm = new FormData();
  // 수정 정보
  const modiMarker = {
    id: detailData.value.id,
    nickname: detailData.value.nickname,
    content: modiContentMarker.value,
    password: password.value,
  };

  reqForm.append(
    "markerModifyReqDTO",
    new Blob([JSON.stringify(modiMarker)], {
      type: "application/json",
    })
  );
  reqForm.append("file", null);

  // 이미지 파일
  modifyMarker(reqForm)
    .then(({ data }) => {
      if (data.status === "OK") {
        modifyFlagMarker.value = false;
        detailData.value.content = modiContentMarker.value;

        Swal.fire({
          position: "center",
          title: "수정되었습니다.",
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
        password.value = null;
        setTimeout(function () {
          document.querySelector(".password-input-marker").focus();
        }, 300);
      });
    });
};

// <마커 삭제>
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
        id: props.marker_id,
        nickname: detailData.value.nickname,
        password: password.value,
      };
      deleteMarker(reqForm)
        .then(({ data }) => {
          if (data.status === "OK") {
            password.value = null;
            isAcceptable.value = false;
            emit("reloadMarker");
            emit("notValid");

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
              document.querySelector(".password-input-marker").focus();
            }, 300);
          });
        });
    } else {
      setTimeout(function () {
        document.querySelector(".password-input-marker").focus();
      }, 300);
    }
  });
};
</script>

<style scoped>
.my-card-marker {
  width: 450px;
  height: 650px;
  position: relative;
}
.my-card-container {
  height: 600px;
  overflow-y: auto;
}
.top-container {
  margin: 10px 0;
}

.icons {
  cursor: pointer;
}

.password-form {
  display: flex;
}

.password-label {
  margin-top: 10px;
}

.password-input-marker {
  font-size: small;
  padding: 5px;
  margin-left: 10px;
  border: 1px solid gray;
  background: rgb(230, 230, 230);
  border-radius: 5px;
  width: 295px;
  margin-top: 10px;
}

.warn-info {
  display: inline-block;
  color: red;
  font-size: 10px;
  padding-top: 5px;
  text-align: start;
}

.v-card-title {
  padding-bottom: 0px;
}

.v-card-subtitle {
  padding-bottom: 10px;
}

.v-card-text {
  /* border: 1px solid black; */
  padding-top: 0;
}

.list-item {
  display: flex;
  margin-top: 10px;
}

.list-item p:nth-child(1) {
  margin-top: 5px;
}
.list-item p:nth-child(2) {
  border: 1px solid rgb(227, 227, 227);
  width: 295px;
  padding: 5px;
  margin-left: 10px;
  border-radius: 5px;
  text-align: start;
}

.modify-form-marker {
  width: 305px;
  height: 50px;
}

.modify-input-marker {
  background: rgb(230, 230, 230);
  width: 295px;
  padding: 5px;
  margin-left: 10px;
  border-radius: 5px;
  text-align: start;
  margin-bottom: 0;
}

.modify-form-marker button:nth-child(2) {
  border: 1px solid black;
}

.modify-form-marker button:nth-child(3) {
  border: 1px solid red;
}
</style>
