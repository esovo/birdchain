<template>
  <div>
    <form @submit.prevent="regist" class="regist-form">
      <ul class="form-list">
        <li class="form-row">
          <label>아이디</label>
          <input
            type="text"
            v-model="form.nickname"
            placeholder="아이디를 입력해주세요." />
        </li>
        <li class="form-row">
          <label>비밀번호</label>
          <input
            type="password"
            v-model="form.password"
            placeholder="비밀번호를 입력해주세요." />
        </li>
        <li class="form-row">
          <label>내용</label>
          <textarea
            id="content"
            v-model="form.content"
            placeholder="내용을 입력해주세요."></textarea>
        </li>
      </ul>
      <button type="submit">등록</button>
    </form>
  </div>
</template>
<script setup>
import { ref, defineProps, defineEmits } from "vue";
import { registComment } from "@/api/comments";
import Swal from "sweetalert2";

const props = defineProps({
  marker_id: {
    type: Number,
  },
});

const emit = defineEmits(["reloadComment"]);

const form = ref({
  nickname: null,
  password: null,
  content: null,
});

const regist = () => {
  const reqForm = {
    nickname: form.value.nickname,
    password: form.value.password,
    content: form.value.content,
    markerId: props.marker_id,
  };

  registComment(reqForm).then(({ data }) => {
    if (data.status === "OK") {
      form.value.nickname = null;
      form.value.password = null;
      form.value.content = null;

      Swal.fire({
        position: "center",
        title: "등록되었습니다.",
        icon: "success",
      });

      emit("reloadComment");
    } else {
      Swal.fire({
        position: "center",
        title: "등록에 실패했습니다.",
        icon: "error",
      });
    }
  });
};
</script>

<style scoped>
.regist-form {
  display: flex;
}
.form-list {
  list-style-type: none;
  border-radius: 3px;
}
.form-row {
  display: flex;
  justify-content: space-between;
  padding: 0.5em;
}
.form-row > label {
  flex: 1;
  width: 1px;
  text-align: start;
  margin-top: 5px;
}
.form-row > input {
  background: rgb(230, 230, 230);
  flex: 3;
  padding: 7px;
  height: 40px;
  width: 330px;
}

.form-row > textarea {
  background: rgb(230, 230, 230);
  flex: 3;
  padding: 7px;
  height: 80px;
  width: 330px;
}

button[type="submit"] {
  height: 185px;
  width: 50px;
  margin-top: 10px;
  margin-bottom: 10px;
  margin-left: 10px;
  background-color: #6dcd01;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

button[type="submit"]:hover {
  background-color: #64ba02;
}
</style>
