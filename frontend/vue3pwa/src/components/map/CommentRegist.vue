<template>
  <div class="form-container">
    <form @submit.prevent="regist" class="form-input">
      <ul class="wrapper">
        <li class="form-row">
          <label for="name">아이디</label>
          <input type="text" v-model="form.nickname" />
        </li>
        <li class="form-row">
          <label for="townborn">비밀번호</label>
          <input type="password" v-model="form.password" />
        </li>
        <li class="form-row">
          <label for="email">내용</label>
          <textarea id="content" v-model="form.content"></textarea>
        </li>
      </ul>
      <button type="submit">등록</button>
    </form>
  </div>
</template>
<script setup>
import { ref, defineProps } from "vue";
import { registComment } from "@/api/comments";
import Swal from "sweetalert2";

const props = defineProps({
  marker_id: {
    type: Number,
  },
});

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

      // 등록 후 어떻게??
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
.form-input {
  display: flex;
  flex-direction: row;
  margin-top: 250px;
}
.wrapper {
  list-style-type: none;
  padding: 0;
  border-radius: 3px;
}
.form-row {
  display: flex;
  justify-content: flex-end;
  padding: 0.5em;
}
.form-row > label {
  padding: 0.5em 1em 0.5em 0;
  flex: 1;
}
.form-row > input {
  background: rgb(230, 230, 230);
  flex: 3;
}

.form-row > textarea {
  background: rgb(230, 230, 230);
  flex: 3;
}

button[type="submit"] {
  width: 50px;
  margin-top: 10px;
  margin-bottom: 10px;
  margin-left: 20px;
  /* padding: 10px 20px; */
  background-color: #4caf50;
  color: white;
  font-size: 16px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

button[type="submit"]:hover {
  background-color: #3e8e41;
}
</style>
