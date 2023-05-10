<template>
  <v-card width="400" height="600">
    <div class="flex-container">
      <div class="title">
        <v-card-title class="pa-0"> {{ detailData.nickname }} </v-card-title>
      </div>
      <div class="icons">
        <font-awesome-icon :icon="['fas', 'pen-to-square']" @click="modifyMarker"/>
        <span> | </span>
        <font-awesome-icon :icon="['fas', 'trash']" @click="showInputForm"/>
      </div>
    </div>
    <v-img :src="detailData.image" height="300px" cover class="my-4"></v-img>

    <v-card-text class="d-flex align-start flex-column ml-3">
      <div v-if="deleteFlag">
        <form @submit.prevent="doDeleteMarker">
          <div class="flex-box">
            <div>
              <div>
                <label> <strong>비밀번호</strong></label>
                <input type="password" v-model="password" class="passwordInput" />
              </div>
              <div v-if="isAcceptable" class="warnInfo">비밀번호를 잘못 입력했습니다. 다시 입력해주세요.</div>
            </div>
            <div class="confirmBtn">
              <button type="reset" @click="showInputForm">취소</button>
              <span> | </span>
              <button type="submit">확인</button>
            </div>
          </div>
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
import { ref, defineProps, watch, defineEmits } from "vue";
import { getMarkerDetail, deleteMarker } from "@/api/markers";
import Swal from "sweetalert2";

// 마커 상세 조회
const props = defineProps({
  marker_id: {
    type: Number,
  },
});

const emit = defineEmits(["reloadMarker", "notValid"]);

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
    if (data.status === "OK") {
      detailData.value.nickname = data.value.nickname;
      detailData.value.image = data.value.image;
      detailData.value.type = data.value.type;
      detailData.value.location = data.value.location;
      detailData.value.content = data.value.content;
      detailData.value.createdAt = data.value.createdAt;
    } else {
      console.log(data.status);
      console.log(data.message);
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

const deleteFlag = ref(false);
const isAcceptable = ref(false);
const showInputForm = () => {
  deleteFlag.value = !deleteFlag.value;
  isAcceptable.value = false;

}


// 마커 수정
const modifyMarker = () => {

}


// 마커 삭제
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
          if(data.status === "OK"){
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
          })
          isAcceptable.value = true;
          password.value = null;
          document.querySelector(".passwordInput").focus();
        })
      }
  });
};
</script>

<style scoped>
.flex-container {
  display: flex;
  margin: 10px 0;
  border: 1px solid black;
  /* flex-direction: row-reverse; */
  justify-content :space-between;
  /* justify-content: center; */
  justify-content: flex-end;
}

.title{
  border: 1px solid black;
  /* display: inline-block; */
  /* display: flex; */
  /* justify-content: center; */
}

.icons {
  margin: auto 0;
  cursor: pointer;
  border: 1px solid black;
  height: 25px;
  /* margin-left: auto; */
}

.warnInfo {
  color: red;
  font-size: 5px;
  width: 240px;
  text-align:left;
}

.flex-box {
  display: flex;
}

.confirmBtn {
  padding-left: 40px;
}

</style>
