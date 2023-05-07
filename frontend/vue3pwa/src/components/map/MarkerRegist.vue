<template>
  <v-app>
    <v-main>
      <v-container class="pt-0">
        <div class="flex-box">
          <!-- 도로명 주소 -->
          <!-- <p>{{ props.placeInfo[2] }}</p> -->
          <!-- 지명 주소 -->
          <p>{{ props.placeInfo[3] }}</p>
          <v-btn
            variant="tonal"
            color="light-green lighten-3"
            @click="showModal"
            class="mt-2"
            >마커 등록하기</v-btn
          >
        </div>
        <v-dialog v-model="modalVisible">
          <v-card>
            <v-card-title class="text-center">
              <span class="headline">마커 등록</span>
            </v-card-title>
            <v-card-text>
              <v-form @submit.prevent="regist">
                <v-text-field
                  label="닉네임"
                  v-model="form.nickname"></v-text-field>
                <v-text-field
                  label="비밀번호"
                  type="password"
                  v-model="form.password"></v-text-field>
                <v-file-input
                  label="이미지"
                  v-model="form.image"
                  @change="previewImage"
                  @click:clear="hidePreview"></v-file-input>
                <v-img
                  v-if="imageUrl"
                  :src="imageUrl"
                  alt="이미지 미리보기"
                  class="mb-6" />
                <v-select
                  :items="categories"
                  label="유형"
                  v-model="form.category"></v-select>
                <v-text-field
                  label="위치"
                  v-model="form.location"
                  readonly></v-text-field>
                <v-divider></v-divider>
                <v-textarea
                  label="글 내용"
                  v-model="form.content"
                  rows="5"></v-textarea>
              </v-form>
            </v-card-text>
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn text @click="closeModal"> 취소 </v-btn>
              <v-btn color="success" text> 저장 </v-btn>
            </v-card-actions>
          </v-card>
        </v-dialog>
      </v-container>
    </v-main>
  </v-app>
</template>

<script setup>
import { ref, defineProps } from "vue";

// 위도 placeInfo[0]
// 경도 placeInfo[1]
// 도로명 주소 placeInfo[2]
// 지번 주소 placeInfo[3]
const props = defineProps({
  placeInfo: Array,
});
const categories = ["새발견", "버드스트라이크"];
const modalVisible = ref(false);
const form = ref({
  nickname: null,
  password: null,
  image: null,
  category: null,
  location: null,
  content: null,
});

// 등록창 띄우기
const showModal = () => {
  modalVisible.value = true;
  form.value.location = props.placeInfo[3];
  // if (props.placeInfo[2] == null) {
  //   form.value.location = props.placeInfo[3];
  // }
  // form.value.location = props.placeInfo[2];
};

// 사진 미리보기
const imageUrl = ref(null);
const previewImage = (event) => {
  const file = event.target.files[0];

  if (!file) {
    return;
  }

  const reader = new FileReader();
  reader.readAsDataURL(file);
  reader.onload = (event) => {
    imageUrl.value = event.target.result;
  };
};

const hidePreview = () => {
  form.value.image = null;
  imageUrl.value = null;
};

// 모달창 닫기
const closeModal = () => {
  modalVisible.value = false;
  form.value.nickname = null;
  form.value.password = null;
  form.value.image = null;
  form.value.category = null;
  form.value.content = null;
  imageUrl.value = null;
};

// axios 요청
const regist = () => {};
</script>

<style scoped>
.flex-box {
  border: 1px solid gray;
  padding: 10px;
}

@media (min-width: 600px) {
  /* 노트북 크기 이상일 때 */
  .v-dialog {
    max-width: 600px;
  }
  .v-card {
    max-height: 70vh;
  }

  /* .flex-box {
    width: 100vw;
  } */
}

@media (max-width: 300px) {
  /* 모바일 크기 일 때 */
  .v-card-title {
    justify-content: center;
  }
  .v-card-text {
    display: flex;
    flex-direction: column;
    align-items: center;
  }
}
</style>
