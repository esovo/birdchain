<!-- <template>
  <v-card-text class="d-flex align-start flex-column ml-3">
    <div class="list-item">
      <p> <strong>위치</strong></p>
      <p>{{ detailData.location }}</p>
    </div>
    <div class="list-item">
      <p><strong>유형</strong></p>
      <p>{{ detailData.type }}</p>
    </div>
    <div class="list-item">
      <p><strong>내용</strong></p>
      <p v-if="!modifyFlagMarker">{{ detailData.content }}</p>
      <form @submit.prevent v-if="modifyFlagMarker" class="modify-form-marker">
        <textarea id="content" v-model="modiContentMarker" class="modify-input-marker"></textarea>
      </form>
    </div>
    <div v-if="deleteFlagMarker || modifyFlagMarker">
      <form @submit.prevent class="password-form">
        <label class="password-label"> <strong>비밀<br/>번호</strong></label>
        <input
          type="password"
          placeholder="비밀번호를 입력해주세요."
          v-model="password"
          class="password-input-marker"
          autoComplete="off" />
      </form>
      <span v-if="isAcceptable" class="warn-info" >
        비밀번호를 잘못 입력했습니다. <br/> 다시 입력해주세요.
      </span>
    </div>
  </v-card-text>
</template>

<script setup>
import { ref } from "vue";
import { modifyMarker } from "@/api/markers";
import Swal from "sweetalert2";

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
}

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
  }).catch((error) => {
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
</script>

<style lang="scss" scoped>
.modify-form-marker {
  width: 305px;
  height: 50px;
}

.modify-input-marker  {
  background: rgb(230, 230, 230);
  width: 295px;
  padding: 5px;
  margin-left: 10px;
  border-radius: 5px;
  text-align: start;
  margin-bottom: 0;
}

.modify-form-marker button:nth-child(2)  {
  border: 1px solid black;
}

.modify-form-marker button:nth-child(3)  {
  border: 1px solid red;
}
</style> -->
